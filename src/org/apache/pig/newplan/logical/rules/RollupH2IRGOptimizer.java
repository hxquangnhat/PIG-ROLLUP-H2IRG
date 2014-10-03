/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pig.newplan.logical.rules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.pig.Algebraic;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataType;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.OperatorPlan;
import org.apache.pig.newplan.OperatorSubPlan;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LORollupH2IRGForEach;
import org.apache.pig.newplan.logical.relational.LOInnerLoad;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.optimizer.Rule;
import org.apache.pig.newplan.optimizer.Transformer;

public class RollupH2IRGOptimizer extends Rule {

    private OperatorSubPlan subPlan;
    
    private Integer nRollup = 0;

    public RollupH2IRGOptimizer(String n) {
        super(n, false);
    }

    @Override
    protected OperatorPlan buildPattern() {
  
        LogicalPlan plan = new LogicalPlan();      
        LOForEach foreach = new LOForEach(plan);
        LOCogroup groupby = new LOCogroup(plan);
        
        plan.add(foreach);
        plan.add(groupby);
        plan.connect(foreach, groupby);
        
        return plan;
    }

    @Override
    public Transformer getNewTransformer() {
        return new RollupTransformer();
    }

    public class RollupTransformer extends Transformer {

        /**
         * User defined schema for generate operator. If not specified output schema
         * of UDF will be used which will prefix "dimensions" namespace to all fields
         * @param input
         * @return
         * @throws FrontendException
         */
        private List<LogicalSchema> getUserDefinedSchema(List<LogicalExpressionPlan> input) throws FrontendException {
        	List<LogicalSchema> result = new ArrayList<LogicalSchema>();
            for (int i = 0; i < input.size(); i++) {
            	//get sources of input (roots)
            	List<Operator> sources = input.get(i).getSources();
            	//iterate sources list
                for (Operator op : sources) {

                    if (op instanceof ProjectExpression) {
                        LogicalSchema output = new LogicalSchema();
                        output.addField(new LogicalFieldSchema(((ProjectExpression) op).getColAlias(), null,
                                DataType.NULL));
                        result.add(output);
                    } else if (op instanceof UserFuncExpression) {
                        LogicalSchema output = new LogicalSchema();
                        for (Operator new_op : ((UserFuncExpression) op).getPlan().getSinks()) {
                            output.addField(new LogicalFieldSchema(((ProjectExpression) new_op).getFieldSchema()));
                        }
                        result.add(output);
                    } else if (op instanceof CastExpression) {
                        LogicalSchema output = new LogicalSchema();
                        output.addField(new LogicalFieldSchema(((CastExpression) op).getFieldSchema()));
                        result.add(output);
                    } else if (op instanceof DereferenceExpression) {
                        LogicalSchema output = new LogicalSchema();
                        output.addField(new LogicalFieldSchema(((ProjectExpression) ((DereferenceExpression) op)
                                .getReferredExpression()).getColAlias(), null, DataType.NULL));
                        result.add(output);
                    }

                }
            }
            return result;
        }

        @Override
        /**
         * Check if the plan operator and its sub-tree has a match to the pattern 
         * operator and its sub-tree.
         */
        public boolean check(OperatorPlan matched) throws FrontendException {
            
        	//Check if we have the Rollup operation or not
        	
        	LOForEach foreach1 = (LOForEach) matched.getSources().get(0);
        	
            LOCogroup cogroup = (LOCogroup) matched.getSuccessors(foreach1).get(0);

            if (currentPlan.getSuccessors(cogroup) == null)
                return false;

            boolean bRollup = false;

            Iterator<Operator> it = foreach1.getInnerPlan().getOperators();
            while (it.hasNext()) {
                Operator op = it.next();
                if (op instanceof LOGenerate) {
                    List<LogicalExpressionPlan> inner_leplan = ((LOGenerate) op).getOutputPlans();
                    for (LogicalExpressionPlan op2 : inner_leplan) {
                        for (Operator op3 : op2.getSources()) {
                            if (op3 instanceof UserFuncExpression) {
                                UserFuncExpression uf = (UserFuncExpression) op3;
                                if (uf.getFuncSpec().toString().equals("org.apache.pig.builtin.RollupDimensions")) {
                                    bRollup = true;
                                    nRollup++;
                                }
                                List<LogicalExpression> inpUfs = uf.getArguments();
                                for (LogicalExpression op4 : inpUfs) {
                                    if (op4 instanceof ProjectExpression) {
                                        ProjectExpression pe = (ProjectExpression) op4;
                                    } else if (op4 instanceof CastExpression) {
                                        CastExpression ce = (CastExpression) op4;
                                    } else {
                                    }
                                }
                            } else if (op3 instanceof ProjectExpression) {
                                ProjectExpression pe = (ProjectExpression) op3;

                            } else if (op3 instanceof CastExpression) {
                                CastExpression ce = (CastExpression) op3;
                            } else {
                            }
                        }
                    }

                } else if (op instanceof LOInnerLoad) {
                    LOInnerLoad iltmp = (LOInnerLoad) op;
                    ProjectExpression pe = iltmp.getProjection();
                }
            }

            //If we did not find out a rollup or there are more than
            //rollup, this operator plan fails the checks
            
            if (!bRollup)
                return false;

            /*if (currentPlan.getSuccessors(cogroup) == null)
                return false;*/
            
            //We check if our userfuncexpression can be applied with the optimization
            //or not.
            
            List<Operator> succs = currentPlan.getSuccessors(cogroup);

            // check if the optimization if applicable with the function
            boolean bOptimization = false;

            if (!succs.isEmpty() && succs.size() == 1) {
                if (succs.get(0) instanceof LOForEach) {
                    LOForEach foreach2 = (LOForEach) succs.get(0);
                    it = foreach2.getInnerPlan().getOperators();
                    while (it.hasNext()) {
                        Operator op = it.next();
                        if (op instanceof LOGenerate) {
                            List<LogicalExpressionPlan> inner_leplan = ((LOGenerate) op).getOutputPlans();
                            for (LogicalExpressionPlan loplan2 : inner_leplan) {
                                for (Operator op3 : loplan2.getSources()) {
                                    if (op3 instanceof UserFuncExpression) {
                                        UserFuncExpression uf = (UserFuncExpression) op3;
                                        EvalFunc<?> ef = (EvalFunc<?>) PigContext.instantiateFuncFromSpec(uf.getFuncSpec());

                                        // check if the evaluate function is algebraic so that we
                                        // can apply our optimization
                                        if (ef instanceof Algebraic) {
                                            bOptimization = true;
                                            Operator op4 = loplan2.getSuccessors(op3).get(0);
                                            if (op4 instanceof DereferenceExpression) {
                                                DereferenceExpression deref = (DereferenceExpression) op4;
                                            }
                                        }
                                    } else {
                                        
                                    }
                                }
                            }

                        }
                    }
                }
            }

            return bOptimization;
        }

        @Override
        /**
         * If the OperatorPlan which was checked is matched the rule, transform it.
         */
        public void transform(OperatorPlan matched) throws FrontendException {
            // TODO Auto-generated method stub
            
        	//the original rollup index in comparison to others operations before being transformed
        	int rollup_index = 0;
        	
        	//the number of fields that involve in the rollup operation
        	int rollup_size = 0;
        	
        	//the original position of the first field of the rollup operation
        	int rollup_field_start = 0;
        	
        	//the length of the tuple
        	int dimension_size = 0;
        	
        	//the rollup first field index in comparison to others fields after being transformed
        	int rollup_updated_index = 0;
       
        	//number of user function
        	int userfunc_size = 0;
        	
        	subPlan = new OperatorSubPlan(currentPlan);
            
            LOForEach foreach1 = (LOForEach) matched.getSources().get(0);
            
            List<LogicalFieldSchema> foreach_field_lst = foreach1.getSchema().getFields();
            
            LOCogroup cogroup = (LOCogroup) matched.getSuccessors(foreach1).get(0);
            
            LOForEach foreach2 = (LOForEach) currentPlan.getSuccessors(cogroup).get(0);
            
            Iterator<Operator> it = foreach1.getInnerPlan().getOperators();
            while (it.hasNext()) {
                Operator op = it.next();
                if (op instanceof LOGenerate) {
                    List<LogicalExpressionPlan> inner_leplan = ((LOGenerate) op).getOutputPlans();
                    
                    //If there is a rollup and multiple cubes, we move
                    //the rollup operation to the end of the operations.
                    //Update the indexes of the rollup operation and its fields.
                    for (LogicalExpressionPlan op2 : inner_leplan) {
                        for (Operator op3 : op2.getSources()) {
                            if (op3 instanceof UserFuncExpression) {
                            	
                            	userfunc_size++;
                            	
                                UserFuncExpression uf = (UserFuncExpression) op3; 
                                
                                dimension_size += uf.getFieldSchema().schema.getFields().get(0).schema.getFields().size();
                                
                                if (uf.getFuncSpec().toString().equals("org.apache.pig.builtin.RollupDimensions")) {
                                	
                                	nRollup--;
                                	if (nRollup == 0) {
	                                	//the original position of the first field of the rollup operation
	                                	rollup_field_start = dimension_size - uf.getFieldSchema().schema.getFields().get(0).schema.getFields().size();
	                                	
	                                	LogicalFieldSchema first_rollup = uf.getFieldSchema().schema.getFields().get(0).schema.getFields().get(0);
	                                    
	                                    for (LogicalFieldSchema a : foreach_field_lst)
	                                    	if (a.alias.equals(first_rollup.alias)) {
	                                    		rollup_index = inner_leplan.indexOf(op2);
	                                    		break;
	                                    	}
	                                    
	                                    rollup_size = uf.getFieldSchema().schema.getFields().get(0).schema.getFields().size();
	                                    
	                                	if(cogroup.getPivot()!=null)
	                                    	uf.setPivot(cogroup.getPivot());
	                                    else 
	                                    	uf.setPivot(0);
	                                	uf.setRollupH2IRGOptimizable(true);
	                                	uf.setRollupPosition(dimension_size - rollup_size);
	                                	uf.setRollupStartPosition(rollup_field_start);
	                                	//set field start
	                                	//set position
                                	}
                                }
                            }
                        }
                    }
                    
                    for (LogicalExpressionPlan op2 : inner_leplan)
                        for (Operator op3 : op2.getSources()) {
                            if (op3 instanceof UserFuncExpression) {
                            	UserFuncExpression uf = (UserFuncExpression) op3; 
                            	if (uf.getFuncSpec().toString().equals("org.apache.pig.builtin.RollupDimensions")) {
                                	uf.setRollupPosition(dimension_size - rollup_size);
                                	uf.setDimensionSize(dimension_size);
                            	}
                            }
                        }
                    
                    //Move the rollup operation to the end of the operation list
                    //in case it doensnt stand at the end
                    if (rollup_index < userfunc_size -1) {
                    	LogicalExpressionPlan temp = inner_leplan.get(rollup_index);
                    
                    	for (int l = rollup_index; l < userfunc_size - 1; l++)
                    	inner_leplan.set(l, inner_leplan.get(l+1));
                    
                    	inner_leplan.set(userfunc_size - 1, temp);
                    }
                    rollup_updated_index = dimension_size - rollup_size;
                }
            }
            
            //Change the default partitioner to the RollupH2IRG partitioner
            cogroup.setCustomPartitioner("org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners.RollupH2IRGPartitioner");
            
            //Create a new LORollupH2IRGForEach logical operator
            LORollupH2IRGForEach hfe = new LORollupH2IRGForEach(foreach2);
            
            //Setup the pivot position for the new LORollupH2IRGForEach logical operator
            //Setup the old and new rollup index and the indexes of its fields.
            if(cogroup.getPivot()!=null)
            	hfe.setPivot(cogroup.getPivot());
            else {
            	hfe.setPivot(0);
            	hfe.setOnlyIRG();
            }
            hfe.setRollupPosition(rollup_updated_index);
            hfe.setRollupStartPosition(rollup_field_start);
            hfe.setRollupSize(rollup_size);
            
            //Replace the old LOForEach to our new LORollupH2IRGForEach.
            //Transformation done.
            currentPlan.replace(foreach2, hfe);
                        
            subPlan.add(foreach1);
            subPlan.add(hfe);
        }

        @Override
        public OperatorPlan reportChanges() {

            // TODO Auto-generated method stub
            return subPlan;
        }

    }
}
