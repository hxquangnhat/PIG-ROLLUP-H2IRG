// $ANTLR 3.4 /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g 2014-09-17 14:41:20

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.NumValCarrier;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOCube;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LORank;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.math.BigDecimal;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", "AS", "ASC", "ASSERT", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", "BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", "FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", "IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PIVOT", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "REGISTER", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", "CASE_EXPR_LHS", "CASE_EXPR_RHS", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "IN_LHS", "IN_RHS", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AMPERSAND=5;
    public static final int AND=6;
    public static final int ARROBA=7;
    public static final int AS=8;
    public static final int ASC=9;
    public static final int ASSERT=10;
    public static final int BAG=11;
    public static final int BIGDECIMAL=12;
    public static final int BIGDECIMALNUMBER=13;
    public static final int BIGINTEGER=14;
    public static final int BIGINTEGERNUMBER=15;
    public static final int BOOLEAN=16;
    public static final int BY=17;
    public static final int BYTEARRAY=18;
    public static final int CACHE=19;
    public static final int CASE=20;
    public static final int CHARARRAY=21;
    public static final int COGROUP=22;
    public static final int COLON=23;
    public static final int COMMA=24;
    public static final int CROSS=25;
    public static final int CUBE=26;
    public static final int DATETIME=27;
    public static final int DCOLON=28;
    public static final int DEFINE=29;
    public static final int DENSE=30;
    public static final int DESC=31;
    public static final int DIGIT=32;
    public static final int DISTINCT=33;
    public static final int DIV=34;
    public static final int DOLLAR=35;
    public static final int DOLLARVAR=36;
    public static final int DOUBLE=37;
    public static final int DOUBLENUMBER=38;
    public static final int DOUBLE_PERIOD=39;
    public static final int ELSE=40;
    public static final int END=41;
    public static final int EQUAL=42;
    public static final int EXECCOMMAND=43;
    public static final int FALSE=44;
    public static final int FAT_ARROW=45;
    public static final int FILTER=46;
    public static final int FLATTEN=47;
    public static final int FLOAT=48;
    public static final int FLOATINGPOINT=49;
    public static final int FLOATNUMBER=50;
    public static final int FOREACH=51;
    public static final int FULL=52;
    public static final int GENERATE=53;
    public static final int GROUP=54;
    public static final int ID=55;
    public static final int IDENTIFIER=56;
    public static final int IF=57;
    public static final int IMPORT=58;
    public static final int IN=59;
    public static final int INNER=60;
    public static final int INPUT=61;
    public static final int INT=62;
    public static final int INTEGER=63;
    public static final int INTO=64;
    public static final int INVOKE=65;
    public static final int IS=66;
    public static final int JOIN=67;
    public static final int LEFT=68;
    public static final int LEFT_BRACKET=69;
    public static final int LEFT_CURLY=70;
    public static final int LEFT_PAREN=71;
    public static final int LETTER=72;
    public static final int LIMIT=73;
    public static final int LOAD=74;
    public static final int LONG=75;
    public static final int LONGINTEGER=76;
    public static final int MAP=77;
    public static final int MAPREDUCE=78;
    public static final int MINUS=79;
    public static final int ML_COMMENT=80;
    public static final int MULTILINE_QUOTEDSTRING=81;
    public static final int NOT=82;
    public static final int NULL=83;
    public static final int NUM_OP_EQ=84;
    public static final int NUM_OP_GT=85;
    public static final int NUM_OP_GTE=86;
    public static final int NUM_OP_LT=87;
    public static final int NUM_OP_LTE=88;
    public static final int NUM_OP_NE=89;
    public static final int ONSCHEMA=90;
    public static final int OR=91;
    public static final int ORDER=92;
    public static final int OTHERWISE=93;
    public static final int OUTER=94;
    public static final int OUTPUT=95;
    public static final int PARALLEL=96;
    public static final int PARTITION=97;
    public static final int PERCENT=98;
    public static final int PERIOD=99;
    public static final int PIVOT=100;
    public static final int PLUS=101;
    public static final int POUND=102;
    public static final int QMARK=103;
    public static final int QUOTEDSTRING=104;
    public static final int RANK=105;
    public static final int REGISTER=106;
    public static final int RETURNS=107;
    public static final int RIGHT=108;
    public static final int RIGHT_BRACKET=109;
    public static final int RIGHT_CURLY=110;
    public static final int RIGHT_PAREN=111;
    public static final int ROLLUP=112;
    public static final int SAMPLE=113;
    public static final int SEMI_COLON=114;
    public static final int SHIP=115;
    public static final int SL_COMMENT=116;
    public static final int SPECIALCHAR=117;
    public static final int SPLIT=118;
    public static final int STAR=119;
    public static final int STDERROR=120;
    public static final int STDIN=121;
    public static final int STDOUT=122;
    public static final int STORE=123;
    public static final int STREAM=124;
    public static final int STR_OP_EQ=125;
    public static final int STR_OP_GT=126;
    public static final int STR_OP_GTE=127;
    public static final int STR_OP_LT=128;
    public static final int STR_OP_LTE=129;
    public static final int STR_OP_MATCHES=130;
    public static final int STR_OP_NE=131;
    public static final int THEN=132;
    public static final int THROUGH=133;
    public static final int TRUE=134;
    public static final int TUPLE=135;
    public static final int UNION=136;
    public static final int USING=137;
    public static final int VOID=138;
    public static final int WHEN=139;
    public static final int WS=140;
    public static final int ANY=141;
    public static final int BAG_TYPE=142;
    public static final int BAG_TYPE_CAST=143;
    public static final int BAG_VAL=144;
    public static final int BIN_EXPR=145;
    public static final int BOOL=146;
    public static final int BOOL_COND=147;
    public static final int CASE_COND=148;
    public static final int CASE_EXPR=149;
    public static final int CASE_EXPR_LHS=150;
    public static final int CASE_EXPR_RHS=151;
    public static final int CAST_EXPR=152;
    public static final int COL_RANGE=153;
    public static final int EXPR_IN_PAREN=154;
    public static final int FIELD_DEF=155;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=156;
    public static final int FOREACH_PLAN_COMPLEX=157;
    public static final int FOREACH_PLAN_SIMPLE=158;
    public static final int FUNC=159;
    public static final int FUNC_EVAL=160;
    public static final int FUNC_REF=161;
    public static final int INVOKER_FUNC_EVAL=162;
    public static final int IN_LHS=163;
    public static final int IN_RHS=164;
    public static final int JOIN_ITEM=165;
    public static final int KEY_VAL_PAIR=166;
    public static final int MACRO_BODY=167;
    public static final int MACRO_DEF=168;
    public static final int MACRO_INLINE=169;
    public static final int MAP_TYPE=170;
    public static final int MAP_VAL=171;
    public static final int NEG=172;
    public static final int NESTED_CMD=173;
    public static final int NESTED_CMD_ASSI=174;
    public static final int NESTED_PROJ=175;
    public static final int PARAMS=176;
    public static final int QUERY=177;
    public static final int REALIAS=178;
    public static final int RETURN_VAL=179;
    public static final int SPLIT_BRANCH=180;
    public static final int STATEMENT=181;
    public static final int TOBAG=182;
    public static final int TOMAP=183;
    public static final int TOTUPLE=184;
    public static final int TUPLE_TYPE=185;
    public static final int TUPLE_TYPE_CAST=186;
    public static final int TUPLE_VAL=187;
    public static final int EVAL=188;
    public static final int MATCHES=189;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

    public String getLastRel() {
        return builder.getLastRel();
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query87); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query89);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:162:1: statement : ( general_statement | split_statement | realias_statement | assert_statement | register_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;

        LogicalPlanGenerator.assert_statement_return assert_statement6 =null;

        LogicalPlanGenerator.register_statement_return register_statement7 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:2: ( general_statement | split_statement | realias_statement | assert_statement | register_statement )
            int alt2=5;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            case ASSERT:
                {
                alt2=4;
                }
                break;
            case REGISTER:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement111);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement116);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:175:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement121);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:176:4: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement126);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:177:4: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement131);
                    register_statement7=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement7.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:17: ( split_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement140);
            split_clause8=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause8.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:19: ( realias_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement149);
            realias_clause9=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause9.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:1: assert_statement : assert_clause ;
    public final LogicalPlanGenerator.assert_statement_return assert_statement() throws RecognitionException {
        LogicalPlanGenerator.assert_statement_return retval = new LogicalPlanGenerator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.assert_clause_return assert_clause10 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:18: ( assert_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement158);
            assert_clause10=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause10.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_statement"


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final LogicalPlanGenerator.register_statement_return register_statement() throws RecognitionException {
        LogicalPlanGenerator.register_statement_return retval = new LogicalPlanGenerator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER11=null;
        CommonTree QUOTEDSTRING12=null;
        CommonTree USING13=null;
        CommonTree IDENTIFIER14=null;
        CommonTree AS15=null;
        CommonTree IDENTIFIER16=null;

        CommonTree REGISTER11_tree=null;
        CommonTree QUOTEDSTRING12_tree=null;
        CommonTree USING13_tree=null;
        CommonTree IDENTIFIER14_tree=null;
        CommonTree AS15_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER11=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER11_tree = (CommonTree)adaptor.dupNode(REGISTER11);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


            adaptor.addChild(root_1, QUOTEDSTRING12_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:28: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:29: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING13=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING13_tree = (CommonTree)adaptor.dupNode(USING13);


                    adaptor.addChild(root_1, USING13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


                    adaptor.addChild(root_1, IDENTIFIER14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS15=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS15_tree = (CommonTree)adaptor.dupNode(AS15);


                    adaptor.addChild(root_1, AS15_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


                    adaptor.addChild(root_1, IDENTIFIER16_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                // registers are handled by QueryParserDriver and are not actually part of the logical plan
                // so we just ignore them here
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias18 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause19 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:16: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement203);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias18!=null?alias18.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement214);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement216);
                    parallel_clause19=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause19.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:205:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS20=null;
        CommonTree IDENTIFIER22=null;
        LogicalPlanGenerator.alias_return alias21 =null;


        CommonTree REALIAS20_tree=null;
        CommonTree IDENTIFIER22_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS20=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS20_tree = (CommonTree)adaptor.dupNode(REALIAS20);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS20_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause235);
            alias21=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias21.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


            adaptor.addChild(root_1, IDENTIFIER22_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER22!=null?IDENTIFIER22.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input,
            	            new SourceLocation( (PigParserNode)IDENTIFIER22 ), (IDENTIFIER22!=null?IDENTIFIER22.getText():null));
            	    }
            	    builder.putOperator( (alias21!=null?alias21.name:null), (LogicalRelationalOperator)op );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:217:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL23=null;
        CommonTree INTEGER24=null;

        CommonTree PARALLEL23_tree=null;
        CommonTree INTEGER24_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:2: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL23=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL23_tree = (CommonTree)adaptor.dupNode(PARALLEL23);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL23_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER24=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER24_tree = (CommonTree)adaptor.dupNode(INTEGER24);


            adaptor.addChild(root_1, INTEGER24_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER24!=null?INTEGER24.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER25=null;

        CommonTree IDENTIFIER25_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:27: ( IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER25=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER25_tree = (CommonTree)adaptor.dupNode(IDENTIFIER25);


            adaptor.addChild(root_0, IDENTIFIER25_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER25!=null?IDENTIFIER25.getText():null); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause26 =null;

        LogicalPlanGenerator.load_clause_return load_clause27 =null;

        LogicalPlanGenerator.group_clause_return group_clause28 =null;

        LogicalPlanGenerator.store_clause_return store_clause29 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause30 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause31 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause32 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause33 =null;

        LogicalPlanGenerator.order_clause_return order_clause34 =null;

        LogicalPlanGenerator.rank_clause_return rank_clause35 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause36 =null;

        LogicalPlanGenerator.join_clause_return join_clause37 =null;

        LogicalPlanGenerator.union_clause_return union_clause38 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause39 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause40 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause41 =null;

        LogicalPlanGenerator.cube_clause_return cube_clause42 =null;

        LogicalPlanGenerator.assert_clause_return assert_clause43 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=18;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt6=1;
                }
                break;
            case LOAD:
                {
                alt6=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt6=3;
                }
                break;
            case STORE:
                {
                alt6=4;
                }
                break;
            case FILTER:
                {
                alt6=5;
                }
                break;
            case DISTINCT:
                {
                alt6=6;
                }
                break;
            case LIMIT:
                {
                alt6=7;
                }
                break;
            case SAMPLE:
                {
                alt6=8;
                }
                break;
            case ORDER:
                {
                alt6=9;
                }
                break;
            case RANK:
                {
                alt6=10;
                }
                break;
            case CROSS:
                {
                alt6=11;
                }
                break;
            case JOIN:
                {
                alt6=12;
                }
                break;
            case UNION:
                {
                alt6=13;
                }
                break;
            case STREAM:
                {
                alt6=14;
                }
                break;
            case MAPREDUCE:
                {
                alt6=15;
                }
                break;
            case FOREACH:
                {
                alt6=16;
                }
                break;
            case CUBE:
                {
                alt6=17;
                }
                break;
            case ASSERT:
                {
                alt6=18;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause302);
                    define_clause26=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:229:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause316);
                    load_clause27=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause27!=null?load_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:230:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause332);
                    group_clause28=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause28!=null?group_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:231:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause348);
                    store_clause29=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause29!=null?store_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:232:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause364);
                    filter_clause30=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause30!=null?filter_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:233:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause31=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause31!=null?distinct_clause31.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:234:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause396);
                    limit_clause32=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause32.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause32!=null?limit_clause32.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:235:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause412);
                    sample_clause33=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause33.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause33!=null?sample_clause33.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:236:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause428);
                    order_clause34=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause34.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause34!=null?order_clause34.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:237:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause444);
                    rank_clause35=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause35.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (rank_clause35!=null?rank_clause35.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:238:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause460);
                    cross_clause36=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause36.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause36!=null?cross_clause36.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:239:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause476);
                    join_clause37=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause37.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause37!=null?join_clause37.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:240:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause492);
                    union_clause38=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause38.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause38!=null?union_clause38.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:241:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause508);
                    stream_clause39=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause39.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause39!=null?stream_clause39.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:242:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause524);
                    mr_clause40=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause40.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause40!=null?mr_clause40.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:243:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause540);
                    foreach_clause41=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause41.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause41!=null?foreach_clause41.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause556);
                    cube_clause42=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause42.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cube_clause42!=null?cube_clause42.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:245:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause572);
                    assert_clause43=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause43.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (assert_clause43!=null?assert_clause43.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:248:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE44=null;
        CommonTree DEFINE47=null;
        LogicalPlanGenerator.alias_return alias45 =null;

        LogicalPlanGenerator.cmd_return cmd46 =null;

        LogicalPlanGenerator.alias_return alias48 =null;

        LogicalPlanGenerator.func_clause_return func_clause49 =null;


        CommonTree DEFINE44_tree=null;
        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DEFINE) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==DOWN) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==IDENTIFIER) ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==EXECCOMMAND) ) {
                            alt7=1;
                        }
                        else if ( (LA7_3==FUNC||LA7_3==FUNC_REF) ) {
                            alt7=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE44=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE44_tree = (CommonTree)adaptor.dupNode(DEFINE44);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE44_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause588);
                    alias45=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias45.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause590);
                    cmd46=cmd((alias45!=null?alias45.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd46.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias45!=null?alias45.name:null), (cmd46!=null?cmd46.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause607);
                    alias48=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias48.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause609);
                    func_clause49=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause49.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias48!=null?alias48.name:null), (func_clause49!=null?func_clause49.funcSpec:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:259:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND50=null;
        LogicalPlanGenerator.ship_clause_return ship_clause51 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause52 =null;

        LogicalPlanGenerator.input_clause_return input_clause53 =null;

        LogicalPlanGenerator.output_clause_return output_clause54 =null;

        LogicalPlanGenerator.error_clause_return error_clause55 =null;


        CommonTree EXECCOMMAND50_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND50=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND50_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND50);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND50_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
                loop8:
                do {
                    int alt8=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt8=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt8=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt8=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt8=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt8=5;
                        }
                        break;

                    }

                    switch (alt8) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd642);
                	    ship_clause51=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause51.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd647);
                	    cache_clause52=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause52.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd652);
                	    input_clause53=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause53.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd656);
                	    output_clause54=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause54.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd660);
                	    error_clause55=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause55.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND50!=null?EXECCOMMAND50.getText():null) ), shipPaths,
                       cachePaths, (input_clause53!=null?input_clause53.inputHandleSpecs:null), (output_clause54!=null?output_clause54.outputHandleSpecs:null),
                       (error_clause55!=null?error_clause55.dir:null), (error_clause55!=null?error_clause55.limit:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP56=null;
        LogicalPlanGenerator.path_list_return path_list57 =null;


        CommonTree SHIP56_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP56=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP56_tree = (CommonTree)adaptor.dupNode(SHIP56);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP56_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: ( path_list[$paths] )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause685);
                        path_list57=path_list(paths);

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list57.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING58=null;

        CommonTree QUOTEDSTRING58_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:2: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING58=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list702); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING58_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING58);


            	    adaptor.addChild(root_0, QUOTEDSTRING58_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING58!=null?QUOTEDSTRING58.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:281:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE59=null;
        LogicalPlanGenerator.path_list_return path_list60 =null;


        CommonTree CACHE59_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:2: ( ^( CACHE path_list[$paths] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE59=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE59_tree = (CommonTree)adaptor.dupNode(CACHE59);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause722);
            path_list60=path_list(paths);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list60.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:285:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT61=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd62 =null;


        CommonTree INPUT61_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT61=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT61_tree = (CommonTree)adaptor.dupNode(INPUT61);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT61_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:13: ( stream_cmd[true] )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause749);
            	    stream_cmd62=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd62.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd62!=null?stream_cmd62.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:292:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN63=null;
        CommonTree STDOUT65=null;
        CommonTree QUOTEDSTRING67=null;
        LogicalPlanGenerator.func_clause_return func_clause64 =null;

        LogicalPlanGenerator.func_clause_return func_clause66 =null;

        LogicalPlanGenerator.func_clause_return func_clause68 =null;


        CommonTree STDIN63_tree=null;
        CommonTree STDOUT65_tree=null;
        CommonTree QUOTEDSTRING67_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt15=1;
                }
                break;
            case STDOUT:
                {
                alt15=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN63=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN63_tree = (CommonTree)adaptor.dupNode(STDIN63);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN63_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd795);
                                func_clause64=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause64.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause64!=null?func_clause64.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:306:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT65=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT65_tree = (CommonTree)adaptor.dupNode(STDOUT65);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT65_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd822);
                                func_clause66=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause66.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause66!=null?func_clause66.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:308:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING67=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING67_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING67);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING67_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING67!=null?QUOTEDSTRING67.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:7: ( func_clause[ft] )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd849);
                                func_clause68=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause68.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause68!=null?func_clause68.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:312:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT69=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd70 =null;


        CommonTree OUTPUT69_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT69=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause877); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT69_tree = (CommonTree)adaptor.dupNode(OUTPUT69);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:14: ( stream_cmd[false] )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause881);
            	    stream_cmd70=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd70.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd70!=null?stream_cmd70.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:319:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR71=null;
        CommonTree QUOTEDSTRING72=null;
        CommonTree INTEGER73=null;

        CommonTree STDERROR71_tree=null;
        CommonTree QUOTEDSTRING72_tree=null;
        CommonTree INTEGER73_tree=null;


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR71=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR71_tree = (CommonTree)adaptor.dupNode(STDERROR71);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR71_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING72=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause919); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING72_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING72);


                        adaptor.addChild(root_1, QUOTEDSTRING72_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING72!=null?QUOTEDSTRING72.getText():null) );
                                }

                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:9: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER73=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause941); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER73_tree = (CommonTree)adaptor.dupNode(INTEGER73);


                                adaptor.addChild(root_1, INTEGER73_tree);
                                }


                                if ( state.backtracking==0 ) {
                                              retval.limit = Integer.parseInt( (INTEGER73!=null?INTEGER73.getText():null) );
                                          }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD74=null;
        LogicalPlanGenerator.filename_return filename75 =null;

        LogicalPlanGenerator.func_clause_return func_clause76 =null;

        LogicalPlanGenerator.as_clause_return as_clause77 =null;


        CommonTree LOAD74_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD74=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause994); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD74_tree = (CommonTree)adaptor.dupNode(LOAD74);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD74_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause996);
            filename75=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename75.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause998);
                    func_clause76=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause76.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause1002);
                    as_clause77=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename75!=null?filename75.filename:null), (func_clause76!=null?func_clause76.funcSpec:null), (as_clause77!=null?as_clause77.logicalSchema:null)  );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:346:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING78=null;

        CommonTree QUOTEDSTRING78_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING78=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING78_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING78);


            adaptor.addChild(root_0, QUOTEDSTRING78_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING78!=null?QUOTEDSTRING78.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:350:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS79=null;
        LogicalPlanGenerator.field_def_list_return field_def_list80 =null;


        CommonTree AS79_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:2: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS79=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1039); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS79_tree = (CommonTree)adaptor.dupNode(AS79);


            root_1 = (CommonTree)adaptor.becomeRoot(AS79_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1041);
            field_def_list80=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list80.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list80!=null?field_def_list80.schema:null));
                    retval.logicalSchema = (field_def_list80!=null?field_def_list80.schema:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:358:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
    public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF81=null;
        CommonTree IDENTIFIER82=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84=null;
        LogicalPlanGenerator.type_return type83 =null;

        LogicalPlanGenerator.type_return type85 =null;


        CommonTree FIELD_DEF81_tree=null;
        CommonTree IDENTIFIER82_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84_tree=null;


            byte datatype = DataType.NULL;
            if (nvc==null) {
                nvc =new NumValCarrier();
            }

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                alt22=1;
            }
            else if ( (LA22_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF81=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF81_tree = (CommonTree)adaptor.dupNode(FIELD_DEF81);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER82=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER82_tree = (CommonTree)adaptor.dupNode(IDENTIFIER82);


                    adaptor.addChild(root_1, IDENTIFIER82_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:28: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:30: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1075);
                            type83=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type83.getTree());


                            if ( state.backtracking==0 ) { datatype = (type83!=null?type83.datatype:null);}

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER82!=null?IDENTIFIER82.getText():null), (type83!=null?type83.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER84=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER84_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER84);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:36: ( type )
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:38: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1098);
                    type85=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type85.getTree());


                    if ( state.backtracking==0 ) { datatype = (type85!=null?type85.datatype:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema ( nvc.makeNameFromDataType(datatype) , (type85!=null?type85.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:375:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def86 =null;




            retval.schema = new LogicalSchema();
            NumValCarrier nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:2: ( ( field_def[nvc] )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= FIELD_DEF && LA23_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:6: field_def[nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1129);
            	    field_def86=field_def(nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def86.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def86!=null?field_def86.fieldSchema:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:384:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type87 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type88 =null;

        LogicalPlanGenerator.bag_type_return bag_type89 =null;

        LogicalPlanGenerator.map_type_return map_type90 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:2: ( simple_type | tuple_type | bag_type | map_type )
            int alt24=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt24=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt24=2;
                }
                break;
            case BAG_TYPE:
                {
                alt24=3;
                }
                break;
            case MAP_TYPE:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1149);
                    simple_type87=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type87.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type87!=null?simple_type87.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:389:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1159);
                    tuple_type88=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type88.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type88!=null?tuple_type88.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:394:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1169);
                    bag_type89=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type89.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type89!=null?bag_type89.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:399:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1179);
                    map_type90=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type90.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type90!=null?map_type90.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:406:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN91=null;
        CommonTree INT92=null;
        CommonTree LONG93=null;
        CommonTree FLOAT94=null;
        CommonTree DOUBLE95=null;
        CommonTree BIGINTEGER96=null;
        CommonTree BIGDECIMAL97=null;
        CommonTree DATETIME98=null;
        CommonTree CHARARRAY99=null;
        CommonTree BYTEARRAY100=null;

        CommonTree BOOLEAN91_tree=null;
        CommonTree INT92_tree=null;
        CommonTree LONG93_tree=null;
        CommonTree FLOAT94_tree=null;
        CommonTree DOUBLE95_tree=null;
        CommonTree BIGINTEGER96_tree=null;
        CommonTree BIGDECIMAL97_tree=null;
        CommonTree DATETIME98_tree=null;
        CommonTree CHARARRAY99_tree=null;
        CommonTree BYTEARRAY100_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt25=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case LONG:
                {
                alt25=3;
                }
                break;
            case FLOAT:
                {
                alt25=4;
                }
                break;
            case DOUBLE:
                {
                alt25=5;
                }
                break;
            case BIGINTEGER:
                {
                alt25=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt25=7;
                }
                break;
            case DATETIME:
                {
                alt25=8;
                }
                break;
            case CHARARRAY:
                {
                alt25=9;
                }
                break;
            case BYTEARRAY:
                {
                alt25=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN91=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN91_tree = (CommonTree)adaptor.dupNode(BOOLEAN91);


                    adaptor.addChild(root_0, BOOLEAN91_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT92=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT92_tree = (CommonTree)adaptor.dupNode(INT92);


                    adaptor.addChild(root_0, INT92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:409:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG93=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG93_tree = (CommonTree)adaptor.dupNode(LONG93);


                    adaptor.addChild(root_0, LONG93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:410:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT94=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT94_tree = (CommonTree)adaptor.dupNode(FLOAT94);


                    adaptor.addChild(root_0, FLOAT94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:411:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE95=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE95_tree = (CommonTree)adaptor.dupNode(DOUBLE95);


                    adaptor.addChild(root_0, DOUBLE95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:412:4: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER96=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER96_tree = (CommonTree)adaptor.dupNode(BIGINTEGER96);


                    adaptor.addChild(root_0, BIGINTEGER96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:413:4: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL97=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL97_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL97);


                    adaptor.addChild(root_0, BIGDECIMAL97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:414:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME98=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME98_tree = (CommonTree)adaptor.dupNode(DATETIME98);


                    adaptor.addChild(root_0, DATETIME98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:415:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY99=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY99_tree = (CommonTree)adaptor.dupNode(CHARARRAY99);


                    adaptor.addChild(root_0, CHARARRAY99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:416:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY100=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY100_tree = (CommonTree)adaptor.dupNode(BYTEARRAY100);


                    adaptor.addChild(root_0, BYTEARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:419:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE101=null;
        LogicalPlanGenerator.field_def_list_return field_def_list102 =null;


        CommonTree TUPLE_TYPE101_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE101=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE101_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE101);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE101_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:7: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1287);
                        field_def_list102=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list102.getTree());


                        if ( state.backtracking==0 ) {
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list102!=null?field_def_list102.schema:null));
                                    retval.logicalSchema = (field_def_list102!=null?field_def_list102.schema:null);
                                }

                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE103=null;
        CommonTree IDENTIFIER104=null;
        LogicalPlanGenerator.tuple_type_return tuple_type105 =null;


        CommonTree BAG_TYPE103_tree=null;
        CommonTree IDENTIFIER104_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE103=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE103_tree = (CommonTree)adaptor.dupNode(BAG_TYPE103);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE103_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER104=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1329); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER104_tree = (CommonTree)adaptor.dupNode(IDENTIFIER104);


                        adaptor.addChild(root_1, IDENTIFIER104_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1332);
                        tuple_type105=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type105.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if ((tuple_type105!=null?tuple_type105.logicalSchema:null)!=null && (tuple_type105!=null?tuple_type105.logicalSchema:null).size()==1 && (tuple_type105!=null?tuple_type105.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type105!=null?tuple_type105.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER104!=null?IDENTIFIER104.getText():null), (tuple_type105!=null?tuple_type105.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
                   }
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE106=null;
        LogicalPlanGenerator.type_return type107 =null;


        CommonTree MAP_TYPE106_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:2: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE106=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE106_tree = (CommonTree)adaptor.dupNode(MAP_TYPE106);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE106_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1357);
                        type107=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type107.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   LogicalSchema s = null;
                   if( (type107!=null?type107.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type107!=null?type107.logicalSchema:null), (type107!=null?type107.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:456:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF108=null;
        CommonTree FUNC110=null;
        LogicalPlanGenerator.func_name_return func_name109 =null;

        LogicalPlanGenerator.func_name_return func_name111 =null;

        LogicalPlanGenerator.func_args_return func_args112 =null;


        CommonTree FUNC_REF108_tree=null;
        CommonTree FUNC110_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FUNC_REF) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNC) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF108=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF108_tree = (CommonTree)adaptor.dupNode(FUNC_REF108);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF108_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1388);
                    func_name109=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name109.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name109!=null?func_name109.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name109!=null?func_name109.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC110=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC110_tree = (CommonTree)adaptor.dupNode(FUNC110);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC110_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1404);
                    func_name111=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name111.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1406);
                            func_args112=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args112.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name111!=null?func_name111.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args112!=null?func_args112.args:null) != null )
                                   argList = (func_args112!=null?func_args112.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name111!=null?func_name111.funcName:null), argList, ft );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:478:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD113=null;
        CommonTree DOLLAR114=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD113_tree=null;
        CommonTree DOLLAR114_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1436);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOLLAR||LA33_0==PERIOD) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==PERIOD) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==DOLLAR) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD113=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1450); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD113_tree = (CommonTree)adaptor.dupNode(PERIOD113);


            	            adaptor.addChild(root_0, PERIOD113_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD113!=null?PERIOD113.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR114=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1456); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR114_tree = (CommonTree)adaptor.dupNode(DOLLAR114);


            	            adaptor.addChild(root_0, DOLLAR114_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR114!=null?DOLLAR114.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1472);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:488:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING115=null;
        CommonTree MULTILINE_QUOTEDSTRING116=null;

        CommonTree QUOTEDSTRING115_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING116_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt34=0;
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==QUOTEDSTRING) ) {
                    alt34=1;
                }
                else if ( (LA34_0==MULTILINE_QUOTEDSTRING) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING115=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1501); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING115_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING115);


            	    adaptor.addChild(root_0, QUOTEDSTRING115_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING115!=null?QUOTEDSTRING115.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:491:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING116=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING116_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING116);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING116_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING116!=null?MULTILINE_QUOTEDSTRING116.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class pivot_clause_return extends TreeRuleReturnScope {
        public int pivot;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:1: pivot_clause returns [int pivot] : ^( PIVOT INTEGER ) ;
    public final LogicalPlanGenerator.pivot_clause_return pivot_clause() throws RecognitionException {
        LogicalPlanGenerator.pivot_clause_return retval = new LogicalPlanGenerator.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT117=null;
        CommonTree INTEGER118=null;

        CommonTree PIVOT117_tree=null;
        CommonTree INTEGER118_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:502:2: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:502:4: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT117=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1539); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT117_tree = (CommonTree)adaptor.dupNode(PIVOT117);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT117_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER118=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1541); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER118_tree = (CommonTree)adaptor.dupNode(INTEGER118);


            adaptor.addChild(root_1, INTEGER118_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.pivot = Integer.parseInt( (INTEGER118!=null?INTEGER118.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pivot_clause"


    protected static class cube_clause_scope {
        LOCube cubeOp;
        MultiMap<Integer, LogicalExpressionPlan> cubePlans;
        List<String> operations;
        int inputIndex;
        int pivot;
    }
    protected Stack cube_clause_stack = new Stack();


    public static class cube_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:508:1: cube_clause returns [String alias] : ^( CUBE cube_item ) ;
    public final LogicalPlanGenerator.cube_clause_return cube_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        cube_clause_stack.push(new cube_clause_scope());
        LogicalPlanGenerator.cube_clause_return retval = new LogicalPlanGenerator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE119=null;
        LogicalPlanGenerator.cube_item_return cube_item120 =null;


        CommonTree CUBE119_tree=null;


            ((cube_clause_scope)cube_clause_stack.peek()).cubeOp = builder.createCubeOp();
            ((GScope_scope)GScope_stack.peek()).currentOp = ((cube_clause_scope)cube_clause_stack.peek()).cubeOp;
            ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((cube_clause_scope)cube_clause_stack.peek()).operations = new ArrayList<String>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE119=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1577); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE119_tree = (CommonTree)adaptor.dupNode(CUBE119);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1579);
            cube_item120=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item120.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                   retval.alias = builder.buildCubeOp( loc, ((cube_clause_scope)cube_clause_stack.peek()).cubeOp, ((statement_scope)statement_stack.peek()).alias,
                   ((statement_scope)statement_stack.peek()).inputAlias, ((cube_clause_scope)cube_clause_stack.peek()).operations, ((cube_clause_scope)cube_clause_stack.peek()).cubePlans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            cube_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:531:1: cube_item : rel ( cube_by_clause ) ;
    public final LogicalPlanGenerator.cube_item_return cube_item() throws RecognitionException {
        LogicalPlanGenerator.cube_item_return retval = new LogicalPlanGenerator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel121 =null;

        LogicalPlanGenerator.cube_by_clause_return cube_by_clause122 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:532:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:532:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1596);
            rel121=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel121.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:532:8: ( cube_by_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:532:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1600);
            cube_by_clause122=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause122.getTree());


            if ( state.backtracking==0 ) {
                   ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = (cube_by_clause122!=null?cube_by_clause122.plans:null);
                   ((cube_clause_scope)cube_clause_stack.peek()).operations = (cube_by_clause122!=null?cube_by_clause122.operations:null);
               }

            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:539:1: cube_by_clause returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ^( BY cube_or_rollup ) ;
    public final LogicalPlanGenerator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        LogicalPlanGenerator.cube_by_clause_return retval = new LogicalPlanGenerator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY123=null;
        LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup124 =null;


        CommonTree BY123_tree=null;


            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY123=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1627); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY123_tree = (CommonTree)adaptor.dupNode(BY123);


            root_1 = (CommonTree)adaptor.becomeRoot(BY123_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1629);
            cube_or_rollup124=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup124.getTree());


            if ( state.backtracking==0 ) { retval.operations = (cube_or_rollup124!=null?cube_or_rollup124.operations:null); retval.plans = (cube_or_rollup124!=null?cube_or_rollup124.plans:null); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:547:1: cube_or_rollup returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ( cube_rollup_list )+ ;
    public final LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        LogicalPlanGenerator.cube_or_rollup_return retval = new LogicalPlanGenerator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list125 =null;




            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:552:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:552:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:552:4: ( cube_rollup_list )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==CUBE||LA35_0==ROLLUP) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:552:6: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1652);
            	    cube_rollup_list125=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list125.getTree());


            	    if ( state.backtracking==0 ) {
            	           retval.operations.add((cube_rollup_list125!=null?cube_rollup_list125.operation:null));
            	           retval.plans.put( ((cube_clause_scope)cube_clause_stack.peek()).inputIndex, (cube_rollup_list125!=null?cube_rollup_list125.plans:null));
            	           ((cube_clause_scope)cube_clause_stack.peek()).inputIndex++;
            	       }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        public String operation;
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:560:1: cube_rollup_list returns [String operation, List<LogicalExpressionPlan> plans] : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) );
    public final LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        LogicalPlanGenerator.cube_rollup_list_return retval = new LogicalPlanGenerator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE126=null;
        CommonTree ROLLUP128=null;
        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list127 =null;

        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list129 =null;

        LogicalPlanGenerator.pivot_clause_return pivot_clause130 =null;


        CommonTree CUBE126_tree=null;
        CommonTree ROLLUP128_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:564:2: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==CUBE) ) {
                alt37=1;
            }
            else if ( (LA37_0==ROLLUP) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:564:4: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE126=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE126_tree = (CommonTree)adaptor.dupNode(CUBE126);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE126_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "CUBE"; }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1684);
                    cube_by_expr_list127=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list127.getTree());


                    if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list127!=null?cube_by_expr_list127.plans:null); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:564:98: ^( ROLLUP cube_by_expr_list ( pivot_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP128=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1694); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP128_tree = (CommonTree)adaptor.dupNode(ROLLUP128);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP128_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "ROLLUP"; }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1698);
                    cube_by_expr_list129=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list129.getTree());


                    if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list129!=null?cube_by_expr_list129.plans:null); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:564:192: ( pivot_clause )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==PIVOT) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:564:192: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1702);
                            pivot_clause130=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause130.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { if ((pivot_clause130!=null?((CommonTree)pivot_clause130.tree):null)!=null) builder.setPivotRollupCubeOp(((cube_clause_scope)cube_clause_stack.peek()).cubeOp, (pivot_clause130!=null?pivot_clause130.pivot:0)); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:567:1: cube_by_expr_list returns [List<LogicalExpressionPlan> plans] : ( cube_by_expr )+ ;
    public final LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_list_return retval = new LogicalPlanGenerator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_by_expr_return cube_by_expr131 =null;




            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:4: ( cube_by_expr )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==BIGDECIMALNUMBER||LA38_0==BIGINTEGERNUMBER||LA38_0==CUBE||LA38_0==DIV||LA38_0==DOLLARVAR||LA38_0==DOUBLENUMBER||LA38_0==FALSE||LA38_0==FLOATNUMBER||LA38_0==GROUP||LA38_0==IDENTIFIER||LA38_0==INTEGER||LA38_0==LONGINTEGER||LA38_0==MINUS||LA38_0==NULL||LA38_0==PERCENT||LA38_0==PLUS||LA38_0==QUOTEDSTRING||LA38_0==STAR||LA38_0==TRUE||(LA38_0 >= BAG_VAL && LA38_0 <= BIN_EXPR)||(LA38_0 >= CASE_COND && LA38_0 <= CASE_EXPR)||(LA38_0 >= CAST_EXPR && LA38_0 <= EXPR_IN_PAREN)||LA38_0==FUNC_EVAL||LA38_0==INVOKER_FUNC_EVAL||(LA38_0 >= MAP_VAL && LA38_0 <= NEG)||LA38_0==TUPLE_VAL) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:6: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1727);
            	    cube_by_expr131=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr131.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (cube_by_expr131!=null?cube_by_expr131.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:574:1: cube_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_return retval = new LogicalPlanGenerator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR134=null;
        LogicalPlanGenerator.col_range_return col_range132 =null;

        LogicalPlanGenerator.expr_return expr133 =null;


        CommonTree STAR134_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:578:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt39=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt39=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt39=2;
                }
                break;
            case STAR:
                {
                int LA39_3 = input.LA(2);

                if ( (LA39_3==DOWN) ) {
                    alt39=2;
                }
                else if ( (LA39_3==EOF||LA39_3==UP||LA39_3==BIGDECIMALNUMBER||LA39_3==BIGINTEGERNUMBER||LA39_3==CUBE||LA39_3==DIV||LA39_3==DOLLARVAR||LA39_3==DOUBLENUMBER||LA39_3==FALSE||LA39_3==FLOATNUMBER||LA39_3==GROUP||LA39_3==IDENTIFIER||LA39_3==INTEGER||LA39_3==LONGINTEGER||LA39_3==MINUS||LA39_3==NULL||LA39_3==PERCENT||(LA39_3 >= PIVOT && LA39_3 <= PLUS)||LA39_3==QUOTEDSTRING||LA39_3==STAR||LA39_3==TRUE||(LA39_3 >= BAG_VAL && LA39_3 <= BIN_EXPR)||(LA39_3 >= CASE_COND && LA39_3 <= CASE_EXPR)||(LA39_3 >= CAST_EXPR && LA39_3 <= EXPR_IN_PAREN)||LA39_3==FUNC_EVAL||LA39_3==INVOKER_FUNC_EVAL||(LA39_3 >= MAP_VAL && LA39_3 <= NEG)||LA39_3==TUPLE_VAL) ) {
                    alt39=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:578:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1750);
                    col_range132=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range132.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:579:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1756);
                    expr133=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr133.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:580:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR134=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1762); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR134_tree = (CommonTree)adaptor.dupNode(STAR134);


                    adaptor.addChild(root_0, STAR134_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR134 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 0, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    protected static class group_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:586:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP135=null;
        CommonTree COGROUP139=null;
        LogicalPlanGenerator.group_item_return group_item136 =null;

        LogicalPlanGenerator.group_type_return group_type137 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause138 =null;

        LogicalPlanGenerator.group_item_return group_item140 =null;

        LogicalPlanGenerator.group_type_return group_type141 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause142 =null;


        CommonTree GROUP135_tree=null;
        CommonTree COGROUP139_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp();
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==GROUP) ) {
                alt46=1;
            }
            else if ( (LA46_0==COGROUP) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP135=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP135_tree = (CommonTree)adaptor.dupNode(GROUP135);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP135_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:13: ( group_item )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==ARROBA||LA40_0==ASSERT||LA40_0==COGROUP||(LA40_0 >= CROSS && LA40_0 <= CUBE)||LA40_0==DEFINE||LA40_0==DISTINCT||LA40_0==FILTER||LA40_0==FOREACH||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==JOIN||(LA40_0 >= LIMIT && LA40_0 <= LOAD)||LA40_0==MAPREDUCE||LA40_0==ORDER||LA40_0==RANK||LA40_0==SAMPLE||(LA40_0 >= STORE && LA40_0 <= STREAM)||LA40_0==UNION) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1803);
                    	    group_item136=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item136.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:25: ( group_type )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==QUOTEDSTRING) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1808);
                            group_type137=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type137.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type137!=null?group_type137.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:146: ( partition_clause )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==PARTITION) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:604:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1815);
                            partition_clause138=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause138.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause138!=null?partition_clause138.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP139=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP139_tree = (CommonTree)adaptor.dupNode(COGROUP139);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP139_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:15: ( group_item )+
                    int cnt43=0;
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==ARROBA||LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==IDENTIFIER||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1832);
                    	    group_item140=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item140.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt43 >= 1 ) break loop43;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(43, input);
                                throw eee;
                        }
                        cnt43++;
                    } while (true);


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:27: ( group_type )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==QUOTEDSTRING) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1837);
                            group_type141=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type141.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type141!=null?group_type141.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:147: ( partition_clause )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==PARTITION) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1844);
                            partition_clause142=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause142.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause142!=null?partition_clause142.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING143=null;

        CommonTree QUOTEDSTRING143_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING143=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING143_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING143);


            adaptor.addChild(root_0, QUOTEDSTRING143_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING143!=null?QUOTEDSTRING143.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING143 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:625:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL146=null;
        CommonTree ANY147=null;
        CommonTree INNER148=null;
        CommonTree OUTER149=null;
        LogicalPlanGenerator.rel_return rel144 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause145 =null;


        CommonTree ALL146_tree=null;
        CommonTree ANY147_tree=null;
        CommonTree INNER148_tree=null;
        CommonTree OUTER149_tree=null;

         boolean inner = false; 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:627:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:627:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1885);
            rel144=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel144.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:627:8: ( join_group_by_clause | ALL | ANY )
            int alt47=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt47=1;
                }
                break;
            case ALL:
                {
                alt47=2;
                }
                break;
            case ANY:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:627:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1889);
                    join_group_by_clause145=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause145.getTree());


                    if ( state.backtracking==0 ) {
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause145!=null?join_group_by_clause145.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:631:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL146=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL146_tree = (CommonTree)adaptor.dupNode(ALL146);


                    adaptor.addChild(root_0, ALL146_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL146 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:640:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY147=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY147_tree = (CommonTree)adaptor.dupNode(ANY147);


                    adaptor.addChild(root_0, ANY147_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY147 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:649:11: ( INNER | OUTER )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==INNER) ) {
                alt48=1;
            }
            else if ( (LA48_0==OUTER) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:649:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER148=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1962); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER148_tree = (CommonTree)adaptor.dupNode(INNER148);


                    adaptor.addChild(root_0, INNER148_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:649:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER149=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER149_tree = (CommonTree)adaptor.dupNode(OUTER149);


                    adaptor.addChild(root_0, OUTER149_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:658:1: rel : ( alias | previous_rel | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias150 =null;

        LogicalPlanGenerator.previous_rel_return previous_rel151 =null;

        LogicalPlanGenerator.inline_op_return inline_op152 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:659:2: ( alias | previous_rel | inline_op )
            int alt49=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt49=1;
                }
                break;
            case ARROBA:
                {
                alt49=2;
                }
                break;
            case ASSERT:
            case COGROUP:
            case CROSS:
            case CUBE:
            case DEFINE:
            case DISTINCT:
            case FILTER:
            case FOREACH:
            case GROUP:
            case JOIN:
            case LIMIT:
            case LOAD:
            case MAPREDUCE:
            case ORDER:
            case RANK:
            case SAMPLE:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:659:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1986);
                    alias150=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias150.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias150!=null?alias150.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:663:4: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1996);
                    previous_rel151=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel151.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (previous_rel151!=null?previous_rel151.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:667:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel2006);
                    inline_op152=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op152.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:670:1: previous_rel returns [String name] : ARROBA ;
    public final LogicalPlanGenerator.previous_rel_return previous_rel() throws RecognitionException {
        LogicalPlanGenerator.previous_rel_return retval = new LogicalPlanGenerator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA153=null;

        CommonTree ARROBA153_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:670:35: ( ARROBA )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:670:37: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA153=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel2018); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA153_tree = (CommonTree)adaptor.dupNode(ARROBA153);


            adaptor.addChild(root_0, ARROBA153_tree);
            }


            if ( state.backtracking==0 ) { retval.name = builder.getLastRel(new SourceLocation((PigParserNode)ARROBA153)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "previous_rel"


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:673:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause154 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause155 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:681:2: ( op_clause ( parallel_clause )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:681:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op2040);
            op_clause154=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause154.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:681:14: ( parallel_clause )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==PARALLEL) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:681:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op2042);
                    parallel_clause155=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, parallel_clause155.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause154!=null?op_clause154.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause154!=null?op_clause154.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:689:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR159=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause156 =null;

        LogicalPlanGenerator.col_range_return col_range157 =null;

        LogicalPlanGenerator.expr_return expr158 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list160 =null;


        CommonTree STAR159_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt51=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt51=1;
                }
                break;
            case COL_RANGE:
                {
                alt51=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt51=3;
                }
                break;
            case STAR:
                {
                int LA51_4 = input.LA(2);

                if ( (LA51_4==DOWN) ) {
                    alt51=3;
                }
                else if ( (LA51_4==EOF||LA51_4==UP||LA51_4==BIGDECIMALNUMBER||LA51_4==BIGINTEGERNUMBER||LA51_4==CUBE||LA51_4==DIV||LA51_4==DOLLARVAR||LA51_4==DOUBLENUMBER||LA51_4==FALSE||LA51_4==FLATTEN||LA51_4==FLOATNUMBER||LA51_4==GROUP||LA51_4==IDENTIFIER||LA51_4==INTEGER||LA51_4==LONGINTEGER||LA51_4==MINUS||LA51_4==NULL||LA51_4==PERCENT||LA51_4==PLUS||LA51_4==QUOTEDSTRING||LA51_4==STAR||LA51_4==TRUE||(LA51_4 >= BAG_VAL && LA51_4 <= BIN_EXPR)||(LA51_4 >= CASE_COND && LA51_4 <= CASE_EXPR)||(LA51_4 >= CAST_EXPR && LA51_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA51_4==FUNC_EVAL||LA51_4==INVOKER_FUNC_EVAL||(LA51_4 >= MAP_VAL && LA51_4 <= NEG)||LA51_4==TUPLE_VAL) ) {
                    alt51=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item2068);
                    flatten_clause156=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause156.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:694:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item2078);
                    col_range157=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range157.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:695:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item2086);
                    expr158=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr158.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:696:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR159=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item2094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR159_tree = (CommonTree)adaptor.dupNode(STAR159);


                    adaptor.addChild(root_0, STAR159_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR159 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:4: ( field_def_list )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0 >= FIELD_DEF && LA52_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item2113);
                    field_def_list160=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list160.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list160!=null?field_def_list160.schema:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:705:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN161=null;
        LogicalPlanGenerator.expr_return expr162 =null;


        CommonTree FLATTEN161_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:706:2: ( ^( FLATTEN expr[$plan] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:706:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN161=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN161_tree = (CommonTree)adaptor.dupNode(FLATTEN161);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN161_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause2133);
            expr162=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr162.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE163=null;
        LogicalPlanGenerator.rel_return rel164 =null;

        LogicalPlanGenerator.filename_return filename165 =null;

        LogicalPlanGenerator.func_clause_return func_clause166 =null;


        CommonTree STORE163_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE163=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE163_tree = (CommonTree)adaptor.dupNode(STORE163);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE163_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2153);
            rel164=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel164.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2155);
            filename165=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename165.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FUNC||LA53_0==FUNC_REF) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2157);
                    func_clause166=func_clause(FunctionType.STOREFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause166.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE163 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename165!=null?filename165.filename:null), (func_clause166!=null?func_clause166.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class assert_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:718:1: assert_clause returns [String alias] : ^( ASSERT rel cond[exprPlan] ( comment )? ) ;
    public final LogicalPlanGenerator.assert_clause_return assert_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.assert_clause_return retval = new LogicalPlanGenerator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT167=null;
        LogicalPlanGenerator.rel_return rel168 =null;

        LogicalPlanGenerator.cond_return cond169 =null;

        LogicalPlanGenerator.comment_return comment170 =null;


        CommonTree ASSERT167_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:2: ( ^( ASSERT rel cond[exprPlan] ( comment )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:4: ^( ASSERT rel cond[exprPlan] ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT167=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2191); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT167_tree = (CommonTree)adaptor.dupNode(ASSERT167);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT167_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause2193);
            rel168=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel168.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause2195);
            cond169=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond169.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:33: ( comment )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==QUOTEDSTRING) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:33: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause2198);
                    comment170=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment170.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ASSERT167 );
                   retval.alias = builder.buildAssertOp(loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (cond169!=null?cond169.expr:null), (comment170!=null?comment170.comment:null), exprPlan);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "assert_clause"


    public static class comment_return extends TreeRuleReturnScope {
        public String comment;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:732:1: comment returns [String comment] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.comment_return comment() throws RecognitionException {
        LogicalPlanGenerator.comment_return retval = new LogicalPlanGenerator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING171=null;

        CommonTree QUOTEDSTRING171_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:733:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:733:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING171=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING171_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING171);


            adaptor.addChild(root_0, QUOTEDSTRING171_tree);
            }


            if ( state.backtracking==0 ) { retval.comment = builder.unquote( (QUOTEDSTRING171!=null?QUOTEDSTRING171.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comment"


    public static class filter_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:736:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER172=null;
        LogicalPlanGenerator.rel_return rel173 =null;

        LogicalPlanGenerator.cond_return cond174 =null;


        CommonTree FILTER172_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:742:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:742:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER172=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER172_tree = (CommonTree)adaptor.dupNode(FILTER172);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER172_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2248);
            rel173=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel173.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2250);
            cond174=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond174.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER172 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:750:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR175=null;
        CommonTree AND176=null;
        CommonTree NOT177=null;
        CommonTree NULL178=null;
        CommonTree NOT180=null;
        CommonTree STR_OP_MATCHES187=null;
        CommonTree BOOL_COND190=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr179 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq181 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne182 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt183 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte184 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt185 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte186 =null;

        LogicalPlanGenerator.in_eval_return in_eval188 =null;

        LogicalPlanGenerator.func_eval_return func_eval189 =null;


        CommonTree OR175_tree=null;
        CommonTree AND176_tree=null;
        CommonTree NOT177_tree=null;
        CommonTree NULL178_tree=null;
        CommonTree NOT180_tree=null;
        CommonTree STR_OP_MATCHES187_tree=null;
        CommonTree BOOL_COND190_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:751:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
            int alt56=14;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt56=1;
                }
                break;
            case AND:
                {
                alt56=2;
                }
                break;
            case NOT:
                {
                alt56=3;
                }
                break;
            case NULL:
                {
                alt56=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt56=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt56=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt56=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt56=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt56=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt56=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt56=11;
                }
                break;
            case IN:
                {
                alt56=12;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt56=13;
                }
                break;
            case BOOL_COND:
                {
                alt56=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:751:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR175=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2274); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR175_tree = (CommonTree)adaptor.dupNode(OR175);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR175_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2280);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2287);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR175 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:756:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND176=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND176_tree = (CommonTree)adaptor.dupNode(AND176);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND176_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2308);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2315);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND176 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:761:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT177=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT177_tree = (CommonTree)adaptor.dupNode(NOT177);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT177_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2336);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT177 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:766:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL178=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2351); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL178_tree = (CommonTree)adaptor.dupNode(NULL178);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL178_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2353);
                    expr179=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr179.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:766:28: ( NOT )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==NOT) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:766:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT180=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2356); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT180_tree = (CommonTree)adaptor.dupNode(NOT180);


                            adaptor.addChild(root_1, NOT180_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new IsNullExpression( exprPlan, (expr179!=null?expr179.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL178 ) );
                           if( NOT180 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT180 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:775:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond2371);
                    rel_op_eq181=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq181.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2377);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2384);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq181!=null?((CommonTree)rel_op_eq181.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:780:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond2399);
                    rel_op_ne182=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne182.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2405);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2412);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne182!=null?((CommonTree)rel_op_ne182.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:785:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond2427);
                    rel_op_lt183=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt183.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2433);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2440);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt183!=null?((CommonTree)rel_op_lt183.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:790:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2455);
                    rel_op_lte184=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte184.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2461);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2468);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte184!=null?((CommonTree)rel_op_lte184.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:795:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2483);
                    rel_op_gt185=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt185.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2489);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2496);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt185!=null?((CommonTree)rel_op_gt185.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:800:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2511);
                    rel_op_gte186=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte186.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2517);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2524);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte186!=null?((CommonTree)rel_op_gte186.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:805:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES187=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES187_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES187);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES187_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2545);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2552);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES187 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:810:4: in_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2565);
                    in_eval188=in_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval188.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (in_eval188!=null?in_eval188.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:814:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2576);
                    func_eval189=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval189.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval189!=null?func_eval189.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:818:4: ^( BOOL_COND e1= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND190=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND190_tree = (CommonTree)adaptor.dupNode(BOOL_COND190);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND190_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2595);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e1!=null?e1.expr:null);
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)BOOL_COND190 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:825:1: in_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) ;
    public final LogicalPlanGenerator.in_eval_return in_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.in_eval_return retval = new LogicalPlanGenerator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN191=null;
        CommonTree IN_LHS192=null;
        CommonTree IN_RHS193=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree IN191_tree=null;
        CommonTree IN_LHS192_tree=null;
        CommonTree IN_RHS193_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:830:2: ( ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:830:4: ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN191=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2624); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN191_tree = (CommonTree)adaptor.dupNode(IN191);


            root_1 = (CommonTree)adaptor.becomeRoot(IN191_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:830:10: ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==IN_LHS) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:830:12: ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS192=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2630); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS192_tree = (CommonTree)adaptor.dupNode(IN_LHS192);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS192_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2636);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_RHS193=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2656); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS193_tree = (CommonTree)adaptor.dupNode(IN_RHS193);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS193_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2662);
            	    rhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, rhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert IN tree to nested or expressions. Please also see
                    // QueryParser.g for how IN tree is constructed from IN expression.
                    EqualExpression firstBoolExpr = new EqualExpression(plan, lhsExprs.get(0), rhsExprs.get(0));
                    if (lhsExprs.size() == 1) {
                        retval.expr = firstBoolExpr;
                    } else {
                        OrExpression currOrExpr = null;
                        OrExpression prevOrExpr = null;
                        for (int i = 1; i < lhsExprs.size(); i++) {
                            EqualExpression boolExpr = new EqualExpression(plan, lhsExprs.get(i), rhsExprs.get(i));
                            currOrExpr = new OrExpression( plan, prevOrExpr == null ? firstBoolExpr : prevOrExpr, boolExpr );
                            prevOrExpr = currOrExpr;
                        }
                        retval.expr = currOrExpr;
                    }
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:852:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) );
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree package_name=null;
        CommonTree function_name=null;
        CommonTree is_static=null;
        CommonTree FUNC_EVAL194=null;
        CommonTree INVOKER_FUNC_EVAL197=null;
        LogicalPlanGenerator.func_name_return func_name195 =null;

        LogicalPlanGenerator.real_arg_return real_arg196 =null;

        LogicalPlanGenerator.real_arg_return real_arg198 =null;


        CommonTree package_name_tree=null;
        CommonTree function_name_tree=null;
        CommonTree is_static_tree=null;
        CommonTree FUNC_EVAL194_tree=null;
        CommonTree INVOKER_FUNC_EVAL197_tree=null;


            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:856:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FUNC_EVAL) ) {
                alt60=1;
            }
            else if ( (LA60_0==INVOKER_FUNC_EVAL) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:856:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL194=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL194_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL194);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL194_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2701);
                    func_name195=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name195.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:856:27: ( real_arg[$plan] )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==BIGDECIMALNUMBER||LA58_0==BIGINTEGERNUMBER||LA58_0==CUBE||LA58_0==DIV||LA58_0==DOLLARVAR||LA58_0==DOUBLENUMBER||LA58_0==FALSE||LA58_0==FLOATNUMBER||LA58_0==GROUP||LA58_0==IDENTIFIER||LA58_0==INTEGER||LA58_0==LONGINTEGER||LA58_0==MINUS||LA58_0==NULL||LA58_0==PERCENT||LA58_0==PLUS||LA58_0==QUOTEDSTRING||LA58_0==STAR||LA58_0==TRUE||(LA58_0 >= BAG_VAL && LA58_0 <= BIN_EXPR)||(LA58_0 >= CASE_COND && LA58_0 <= CASE_EXPR)||(LA58_0 >= CAST_EXPR && LA58_0 <= EXPR_IN_PAREN)||LA58_0==FUNC_EVAL||LA58_0==INVOKER_FUNC_EVAL||(LA58_0 >= MAP_VAL && LA58_0 <= NEG)||LA58_0==TUPLE_VAL) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:856:29: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2705);
                    	    real_arg196=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg196.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg196!=null?real_arg196.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(func_name195!=null?((CommonTree)func_name195.start):null) );
                           retval.expr = builder.buildUDF( loc, plan, (func_name195!=null?func_name195.funcName:null), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:861:4: ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL197=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL197_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL197);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL197_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    package_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    package_name_tree = (CommonTree)adaptor.dupNode(package_name);


                    adaptor.addChild(root_1, package_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    function_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    function_name_tree = (CommonTree)adaptor.dupNode(function_name);


                    adaptor.addChild(root_1, function_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    is_static=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2737); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    is_static_tree = (CommonTree)adaptor.dupNode(is_static);


                    adaptor.addChild(root_1, is_static_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:861:95: ( real_arg[$plan] )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==BIGDECIMALNUMBER||LA59_0==BIGINTEGERNUMBER||LA59_0==CUBE||LA59_0==DIV||LA59_0==DOLLARVAR||LA59_0==DOUBLENUMBER||LA59_0==FALSE||LA59_0==FLOATNUMBER||LA59_0==GROUP||LA59_0==IDENTIFIER||LA59_0==INTEGER||LA59_0==LONGINTEGER||LA59_0==MINUS||LA59_0==NULL||LA59_0==PERCENT||LA59_0==PLUS||LA59_0==QUOTEDSTRING||LA59_0==STAR||LA59_0==TRUE||(LA59_0 >= BAG_VAL && LA59_0 <= BIN_EXPR)||(LA59_0 >= CASE_COND && LA59_0 <= CASE_EXPR)||(LA59_0 >= CAST_EXPR && LA59_0 <= EXPR_IN_PAREN)||LA59_0==FUNC_EVAL||LA59_0==INVOKER_FUNC_EVAL||(LA59_0 >= MAP_VAL && LA59_0 <= NEG)||LA59_0==TUPLE_VAL) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:861:97: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2741);
                    	    real_arg198=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg198.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg198!=null?real_arg198.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)function_name );
                           retval.expr = builder.buildInvokerUDF( loc, plan, (package_name!=null?package_name.getText():null), (function_name!=null?function_name.getText():null), Boolean.parseBoolean((is_static!=null?is_static.getText():null)), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:868:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR199=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR199_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:869:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt61=3;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt61=1;
                }
                break;
            case STAR:
                {
                int LA61_2 = input.LA(2);

                if ( (LA61_2==DOWN) ) {
                    alt61=1;
                }
                else if ( (LA61_2==EOF||LA61_2==UP||LA61_2==BIGDECIMALNUMBER||LA61_2==BIGINTEGERNUMBER||LA61_2==CUBE||LA61_2==DIV||LA61_2==DOLLARVAR||LA61_2==DOUBLENUMBER||LA61_2==FALSE||LA61_2==FLOATNUMBER||LA61_2==GROUP||LA61_2==IDENTIFIER||LA61_2==INTEGER||LA61_2==LONGINTEGER||LA61_2==MINUS||LA61_2==NULL||LA61_2==PERCENT||LA61_2==PLUS||LA61_2==QUOTEDSTRING||LA61_2==STAR||LA61_2==TRUE||(LA61_2 >= BAG_VAL && LA61_2 <= BIN_EXPR)||(LA61_2 >= CASE_COND && LA61_2 <= CASE_EXPR)||(LA61_2 >= CAST_EXPR && LA61_2 <= EXPR_IN_PAREN)||LA61_2==FUNC_EVAL||LA61_2==INVOKER_FUNC_EVAL||(LA61_2 >= MAP_VAL && LA61_2 <= NEG)||LA61_2==TUPLE_VAL) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:869:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2773);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:870:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR199=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR199_tree = (CommonTree)adaptor.dupNode(STAR199);


                    adaptor.addChild(root_0, STAR199_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR199 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:875:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2795);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:878:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS200=null;
        CommonTree MINUS201=null;
        CommonTree STAR202=null;
        CommonTree DIV203=null;
        CommonTree PERCENT204=null;
        CommonTree NEG207=null;
        CommonTree CAST_EXPR208=null;
        CommonTree EXPR_IN_PAREN210=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr205 =null;

        LogicalPlanGenerator.var_expr_return var_expr206 =null;

        LogicalPlanGenerator.type_cast_return type_cast209 =null;


        CommonTree PLUS200_tree=null;
        CommonTree MINUS201_tree=null;
        CommonTree STAR202_tree=null;
        CommonTree DIV203_tree=null;
        CommonTree PERCENT204_tree=null;
        CommonTree NEG207_tree=null;
        CommonTree CAST_EXPR208_tree=null;
        CommonTree EXPR_IN_PAREN210_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:879:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt62=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt62=1;
                }
                break;
            case MINUS:
                {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==DOWN) ) {
                    alt62=2;
                }
                else if ( (LA62_2==BIGDECIMALNUMBER||LA62_2==BIGINTEGERNUMBER||LA62_2==DOUBLENUMBER||LA62_2==FLOATNUMBER||LA62_2==INTEGER||LA62_2==LONGINTEGER) ) {
                    alt62=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt62=3;
                }
                break;
            case DIV:
                {
                alt62=4;
                }
                break;
            case PERCENT:
                {
                alt62=5;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case TUPLE_VAL:
                {
                alt62=6;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt62=7;
                }
                break;
            case NEG:
                {
                alt62=8;
                }
                break;
            case CAST_EXPR:
                {
                alt62=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt62=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:879:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS200=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS200_tree = (CommonTree)adaptor.dupNode(PLUS200);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS200_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2820);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2827);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS200 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:884:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS201=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS201_tree = (CommonTree)adaptor.dupNode(MINUS201);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS201_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2848);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2855);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS201 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:889:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR202=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR202_tree = (CommonTree)adaptor.dupNode(STAR202);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR202_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2876);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2883);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR202 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:894:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV203=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV203_tree = (CommonTree)adaptor.dupNode(DIV203);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2904);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2911);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV203 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:899:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT204=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2926); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT204_tree = (CommonTree)adaptor.dupNode(PERCENT204);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT204_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2932);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2939);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT204 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:904:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2952);
                    const_expr205=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr205.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr205!=null?const_expr205.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:908:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2963);
                    var_expr206=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr206.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr206!=null?var_expr206.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:912:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG207=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG207_tree = (CommonTree)adaptor.dupNode(NEG207);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG207_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2982);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:917:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR208=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2997); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR208_tree = (CommonTree)adaptor.dupNode(CAST_EXPR208);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR208_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2999);
                    type_cast209=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast209.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3005);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast209!=null?type_cast209.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast209!=null?((CommonTree)type_cast209.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:922:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN210=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr3021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN210_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN210);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN210_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr3027);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:928:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type211 =null;

        LogicalPlanGenerator.map_type_return map_type212 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast213 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast214 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt63=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt63=1;
                }
                break;
            case MAP_TYPE:
                {
                alt63=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt63=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt63=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast3049);
                    simple_type211=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type211.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type211!=null?simple_type211.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:933:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast3059);
                    map_type212=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type212.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type212!=null?map_type212.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:937:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast3069);
                    tuple_type_cast213=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast213.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast213!=null?tuple_type_cast213.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:941:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast3079);
                    bag_type_cast214=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast214.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast214!=null?bag_type_cast214.logicalSchema:null), DataType.BAG );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:947:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST215=null;
        LogicalPlanGenerator.type_cast_return type_cast216 =null;


        CommonTree TUPLE_TYPE_CAST215_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:951:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:951:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST215=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3104); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST215_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST215);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST215_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:951:23: ( type_cast )*
                loop64:
                do {
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==BIGDECIMAL||LA64_0==BIGINTEGER||LA64_0==BOOLEAN||LA64_0==BYTEARRAY||LA64_0==CHARARRAY||LA64_0==DATETIME||LA64_0==DOUBLE||LA64_0==FLOAT||LA64_0==INT||LA64_0==LONG||LA64_0==BAG_TYPE_CAST||LA64_0==MAP_TYPE||LA64_0==TUPLE_TYPE_CAST) ) {
                        alt64=1;
                    }


                    switch (alt64) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:951:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast3108);
                	    type_cast216=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast216.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast216!=null?type_cast216.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop64;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:954:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST217=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast218 =null;


        CommonTree BAG_TYPE_CAST217_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:958:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:958:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST217=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST217_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST217);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST217_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:958:21: ( tuple_type_cast )?
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==TUPLE_TYPE_CAST) ) {
                    alt65=1;
                }
                switch (alt65) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:958:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast3137);
                        tuple_type_cast218=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast218.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast218!=null?tuple_type_cast218.logicalSchema:null), DataType.TUPLE ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:964:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr219 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj220 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj221 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:969:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:969:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr3164);
            projectable_expr219=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr219.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr219!=null?projectable_expr219.expr:null); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:4: ( dot_proj | pound_proj )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==PERIOD) ) {
                    alt66=1;
                }
                else if ( (LA66_0==POUND) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:970:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr3174);
            	    dot_proj220=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj220.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj220!=null?dot_proj220.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }

            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;

            	                 if( (dot_proj220!=null?dot_proj220.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }

            	                 Object val = (dot_proj220!=null?dot_proj220.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }

            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj220!=null?dot_proj220.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj220!=null?((CommonTree)dot_proj220.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1027:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr3188);
            	    pound_proj221=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj221.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj221!=null?pound_proj221.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj221!=null?((CommonTree)pound_proj221.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
                  }
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1042:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval222 =null;

        LogicalPlanGenerator.col_ref_return col_ref223 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr224 =null;

        LogicalPlanGenerator.case_expr_return case_expr225 =null;

        LogicalPlanGenerator.case_cond_return case_cond226 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] )
            int alt67=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt67=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt67=2;
                }
                break;
            case BIN_EXPR:
                {
                alt67=3;
                }
                break;
            case CASE_EXPR:
                {
                alt67=4;
                }
                break;
            case CASE_COND:
                {
                alt67=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr3218);
                    func_eval222=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval222.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval222!=null?func_eval222.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1047:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr3229);
                    col_ref223=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref223.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref223!=null?col_ref223.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1051:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr3240);
                    bin_expr224=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr224.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr224!=null?bin_expr224.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1055:4: case_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr3251);
                    case_expr225=case_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr225.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_expr225!=null?case_expr225.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:4: case_cond[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr3262);
                    case_cond226=case_cond(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond226.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_cond226!=null?case_cond226.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1065:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD227=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index228 =null;


        CommonTree PERIOD227_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD227=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj3288); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD227_tree = (CommonTree)adaptor.dupNode(PERIOD227);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD227_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:14: ( col_alias_or_index )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj3292);
            	    col_alias_or_index228=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index228.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index228!=null?col_alias_or_index228.col:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias229 =null;

        LogicalPlanGenerator.col_index_return col_index230 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1073:2: ( col_alias | col_index )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==CUBE||LA69_0==GROUP||LA69_0==IDENTIFIER) ) {
                alt69=1;
            }
            else if ( (LA69_0==DOLLARVAR) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1073:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index3312);
                    col_alias229=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias229.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias229!=null?col_alias229.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1073:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index3318);
                    col_index230=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index230.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index230!=null?col_index230.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1076:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP231=null;
        CommonTree CUBE232=null;
        CommonTree IDENTIFIER233=null;

        CommonTree GROUP231_tree=null;
        CommonTree CUBE232_tree=null;
        CommonTree IDENTIFIER233_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1077:2: ( GROUP | CUBE | IDENTIFIER )
            int alt70=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt70=1;
                }
                break;
            case CUBE:
                {
                alt70=2;
                }
                break;
            case IDENTIFIER:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1077:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP231=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP231_tree = (CommonTree)adaptor.dupNode(GROUP231);


                    adaptor.addChild(root_0, GROUP231_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP231!=null?GROUP231.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1078:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE232=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE232_tree = (CommonTree)adaptor.dupNode(CUBE232);


                    adaptor.addChild(root_0, CUBE232_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (CUBE232!=null?CUBE232.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1079:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER233=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3347); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER233_tree = (CommonTree)adaptor.dupNode(IDENTIFIER233);


                    adaptor.addChild(root_0, IDENTIFIER233_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER233!=null?IDENTIFIER233.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1082:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR234=null;

        CommonTree DOLLARVAR234_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1083:2: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1083:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR234=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3362); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR234_tree = (CommonTree)adaptor.dupNode(DOLLARVAR234);


            adaptor.addChild(root_0, DOLLARVAR234_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR234!=null?DOLLARVAR234.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE235=null;
        CommonTree DOUBLE_PERIOD236=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE235_tree=null;
        CommonTree DOUBLE_PERIOD236_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE235=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3381); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE235_tree = (CommonTree)adaptor.dupNode(COL_RANGE235);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE235_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:17: (startExpr= col_ref[$plan] )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3388);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD236=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD236_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD236);


            adaptor.addChild(root_1, DOUBLE_PERIOD236_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:61: (endExpr= col_ref[$plan] )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1088:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3400);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex,
                                (startExpr!=null?startExpr.expr:null),
                                (endExpr!=null?endExpr.expr:null)
                            );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1100:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND237=null;
        CommonTree QUOTEDSTRING238=null;
        CommonTree NULL239=null;

        CommonTree POUND237_tree=null;
        CommonTree QUOTEDSTRING238_tree=null;
        CommonTree NULL239_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1101:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1101:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND237=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND237_tree = (CommonTree)adaptor.dupNode(POUND237);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND237_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1101:13: ( QUOTEDSTRING | NULL )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==QUOTEDSTRING) ) {
                alt73=1;
            }
            else if ( (LA73_0==NULL) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }
            switch (alt73) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1101:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING238=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3430); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING238_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING238);


                    adaptor.addChild(root_1, QUOTEDSTRING238_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING238!=null?QUOTEDSTRING238.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1101:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL239=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3436); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL239_tree = (CommonTree)adaptor.dupNode(NULL239);


                    adaptor.addChild(root_1, NULL239_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR240=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond241 =null;


        CommonTree BIN_EXPR240_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1105:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1105:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR240=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR240_tree = (CommonTree)adaptor.dupNode(BIN_EXPR240);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR240_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr3458);
            cond241=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond241.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3465);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3472);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond241!=null?cond241.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1112:1: case_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) ;
    public final LogicalPlanGenerator.case_expr_return case_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_expr_return retval = new LogicalPlanGenerator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR242=null;
        CommonTree CASE_EXPR_LHS243=null;
        CommonTree CASE_EXPR_RHS244=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree CASE_EXPR242_tree=null;
        CommonTree CASE_EXPR_LHS243_tree=null;
        CommonTree CASE_EXPR_RHS244_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:2: ( ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:4: ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR242=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr3501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR242_tree = (CommonTree)adaptor.dupNode(CASE_EXPR242);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:17: ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==CASE_EXPR_LHS) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) )
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1117:21: ^( CASE_EXPR_LHS lhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS243=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr3509); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS243_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS243);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS243_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr3515);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }


            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1118:19: ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    int cnt74=0;
            	    loop74:
            	    do {
            	        int alt74=2;
            	        int LA74_0 = input.LA(1);

            	        if ( (LA74_0==CASE_EXPR_RHS) ) {
            	            alt74=1;
            	        }


            	        switch (alt74) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1118:21: ^( CASE_EXPR_RHS rhs= expr[$plan] )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS244=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr3546); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS244_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS244);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS244_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr3552);
            	    	    rhs=expr(plan);

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, rhs.getTree());


            	    	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt74 >= 1 ) break loop74;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(74, input);
            	                throw eee;
            	        }
            	        cnt74++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = rhsExprs.size() % 2 == 1;
                    LogicalExpression elseExpr = hasElse ? rhsExprs.get(rhsExprs.size()-1)
                                                         : new ConstantExpression(plan, null);

                    int numWhenBranches = rhsExprs.size() / 2;
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            new EqualExpression( plan, lhsExprs.get(i), rhsExprs.get(2*i) ), rhsExprs.get(2*i+1),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1140:1: case_cond[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) ;
    public final LogicalPlanGenerator.case_cond_return case_cond(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_cond_return retval = new LogicalPlanGenerator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND245=null;
        CommonTree WHEN246=null;
        CommonTree THEN248=null;
        LogicalPlanGenerator.cond_return cond247 =null;

        LogicalPlanGenerator.expr_return expr249 =null;


        CommonTree CASE_COND245_tree=null;
        CommonTree WHEN246_tree=null;
        CommonTree THEN248_tree=null;


            List<LogicalExpression> conds = new ArrayList<LogicalExpression>();
            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1145:2: ( ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1145:4: ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND245=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3592); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND245_tree = (CommonTree)adaptor.dupNode(CASE_COND245);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND245_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN246=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN246_tree = (CommonTree)adaptor.dupNode(WHEN246);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN246_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1145:25: ( cond[$plan] )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==AND||LA76_0==IN||(LA76_0 >= NOT && LA76_0 <= NUM_OP_NE)||LA76_0==OR||(LA76_0 >= STR_OP_EQ && LA76_0 <= STR_OP_NE)||LA76_0==BOOL_COND||LA76_0==FUNC_EVAL||LA76_0==INVOKER_FUNC_EVAL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1145:27: cond[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3600);
            	    cond247=cond(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond247.getTree());


            	    if ( state.backtracking==0 ) { conds.add((cond247!=null?cond247.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            THEN248=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3628); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN248_tree = (CommonTree)adaptor.dupNode(THEN248);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN248_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1146:25: ( expr[$plan] )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==BIGDECIMALNUMBER||LA77_0==BIGINTEGERNUMBER||LA77_0==CUBE||LA77_0==DIV||LA77_0==DOLLARVAR||LA77_0==DOUBLENUMBER||LA77_0==FALSE||LA77_0==FLOATNUMBER||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==INTEGER||LA77_0==LONGINTEGER||LA77_0==MINUS||LA77_0==NULL||LA77_0==PERCENT||LA77_0==PLUS||LA77_0==QUOTEDSTRING||LA77_0==STAR||LA77_0==TRUE||(LA77_0 >= BAG_VAL && LA77_0 <= BIN_EXPR)||(LA77_0 >= CASE_COND && LA77_0 <= CASE_EXPR)||LA77_0==CAST_EXPR||LA77_0==EXPR_IN_PAREN||LA77_0==FUNC_EVAL||LA77_0==INVOKER_FUNC_EVAL||(LA77_0 >= MAP_VAL && LA77_0 <= NEG)||LA77_0==TUPLE_VAL) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1146:27: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3632);
            	    expr249=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr249.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr249!=null?expr249.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = exprs.size() != conds.size();
                    LogicalExpression elseExpr = hasElse ? exprs.remove(exprs.size()-1)
                                                         : new ConstantExpression(plan, null);
                    Collections.reverse(exprs);
                    Collections.reverse(conds);
                    int numWhenBranches = conds.size();
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            conds.get(i), exprs.get(i),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1169:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT250=null;
        CommonTree INTEGER252=null;
        CommonTree LONGINTEGER253=null;
        LogicalPlanGenerator.rel_return rel251 =null;

        LogicalPlanGenerator.expr_return expr254 =null;


        CommonTree LIMIT250_tree=null;
        CommonTree INTEGER252_tree=null;
        CommonTree LONGINTEGER253_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT250=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3674); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT250_tree = (CommonTree)adaptor.dupNode(LIMIT250);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT250_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3676);
            rel251=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel251.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt78=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA78_1 = input.LA(2);

                if ( (synpred147_LogicalPlanGenerator()) ) {
                    alt78=1;
                }
                else if ( (true) ) {
                    alt78=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA78_2 = input.LA(2);

                if ( (synpred148_LogicalPlanGenerator()) ) {
                    alt78=2;
                }
                else if ( (true) ) {
                    alt78=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt78=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER252=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER252_tree = (CommonTree)adaptor.dupNode(INTEGER252);


                    adaptor.addChild(root_1, INTEGER252_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT250 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER252!=null?INTEGER252.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1180:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER253=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER253_tree = (CommonTree)adaptor.dupNode(LONGINTEGER253);


                    adaptor.addChild(root_1, LONGINTEGER253_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT250 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER253!=null?LONGINTEGER253.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3700);
                    expr254=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr254.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT250 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1193:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE255=null;
        CommonTree DOUBLENUMBER257=null;
        LogicalPlanGenerator.rel_return rel256 =null;

        LogicalPlanGenerator.expr_return expr258 =null;


        CommonTree SAMPLE255_tree=null;
        CommonTree DOUBLENUMBER257_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE255=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3736); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE255_tree = (CommonTree)adaptor.dupNode(SAMPLE255);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE255_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3738);
            rel256=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel256.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==DOUBLENUMBER) ) {
                int LA79_1 = input.LA(2);

                if ( (synpred149_LogicalPlanGenerator()) ) {
                    alt79=1;
                }
                else if ( (true) ) {
                    alt79=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA79_0==BIGDECIMALNUMBER||LA79_0==BIGINTEGERNUMBER||LA79_0==CUBE||LA79_0==DIV||LA79_0==DOLLARVAR||LA79_0==FALSE||LA79_0==FLOATNUMBER||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==INTEGER||LA79_0==LONGINTEGER||LA79_0==MINUS||LA79_0==NULL||LA79_0==PERCENT||LA79_0==PLUS||LA79_0==QUOTEDSTRING||LA79_0==STAR||LA79_0==TRUE||(LA79_0 >= BAG_VAL && LA79_0 <= BIN_EXPR)||(LA79_0 >= CASE_COND && LA79_0 <= CASE_EXPR)||LA79_0==CAST_EXPR||LA79_0==EXPR_IN_PAREN||LA79_0==FUNC_EVAL||LA79_0==INVOKER_FUNC_EVAL||(LA79_0 >= MAP_VAL && LA79_0 <= NEG)||LA79_0==TUPLE_VAL) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER257=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER257_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER257);


                    adaptor.addChild(root_1, DOUBLENUMBER257_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE255 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER257!=null?DOUBLENUMBER257.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER257 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1205:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3752);
                    expr258=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr258.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE255 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr258!=null?expr258.expr:null));
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    protected static class rank_clause_scope {
        LORank rankOp;
    }
    protected Stack rank_clause_stack = new Stack();


    public static class rank_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1213:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
    public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        rank_clause_stack.push(new rank_clause_scope());
        LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK259=null;
        LogicalPlanGenerator.rel_return rel260 =null;

        LogicalPlanGenerator.rank_by_statement_return rank_by_statement261 =null;


        CommonTree RANK259_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createRankOp();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1223:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1223:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK259=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK259_tree = (CommonTree)adaptor.dupNode(RANK259);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK259_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3800);
            rel260=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel260.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1223:16: ( rank_by_statement )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==BY) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1223:16: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3802);
                    rank_by_statement261=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement261.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	SourceLocation loc = new SourceLocation( (PigParserNode) ((CommonTree)retval.start) );

            	List<LogicalExpressionPlan> tempPlans = (rank_by_statement261!=null?rank_by_statement261.plans:null);
            	List<Boolean> tempAscFlags = (rank_by_statement261!=null?rank_by_statement261.ascFlags:null);

            	if(tempPlans == null && tempAscFlags == null) {
            		tempPlans = new ArrayList<LogicalExpressionPlan>();
            		tempAscFlags = new ArrayList<Boolean>();

            		((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsRowNumber( true );
            	}

            	((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsDenseRank( (rank_by_statement261!=null?rank_by_statement261.isDenseRank:null) != null?(rank_by_statement261!=null?rank_by_statement261.isDenseRank:null):false );

            	retval.alias = builder.buildRankOp( loc, (LORank)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, tempPlans, tempAscFlags );
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            rank_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        public Boolean isDenseRank;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1243:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
    public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY262=null;
        CommonTree DENSE264=null;
        LogicalPlanGenerator.rank_by_clause_return rank_by_clause263 =null;


        CommonTree BY262_tree=null;
        CommonTree DENSE264_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();
            retval.isDenseRank = false;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1249:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1249:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY262=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3828); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY262_tree = (CommonTree)adaptor.dupNode(BY262);


            root_1 = (CommonTree)adaptor.becomeRoot(BY262_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3830);
            rank_by_clause263=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause263.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1249:25: ( DENSE )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==DENSE) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1249:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE264=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE264_tree = (CommonTree)adaptor.dupNode(DENSE264);


                    adaptor.addChild(root_1, DENSE264_tree);
                    }


                    if ( state.backtracking==0 ) { retval.isDenseRank =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	retval.plans = (rank_by_clause263!=null?rank_by_clause263.plans:null);
            	retval.ascFlags = (rank_by_clause263!=null?rank_by_clause263.ascFlags:null);
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1256:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR265=null;
        CommonTree ASC266=null;
        CommonTree DESC267=null;
        LogicalPlanGenerator.rank_col_return rank_col268 =null;


        CommonTree STAR265_tree=null;
        CommonTree ASC266_tree=null;
        CommonTree DESC267_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1261:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==STAR) ) {
                alt84=1;
            }
            else if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }
            switch (alt84) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1261:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR265=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR265_tree = (CommonTree)adaptor.dupNode(STAR265);


                    adaptor.addChild(root_0, STAR265_tree);
                    }


                    if ( state.backtracking==0 ) {
                    		LogicalExpressionPlan plan = new LogicalExpressionPlan();
                    		builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR265 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                    		retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1266:4: ( ASC | DESC )?
                    int alt82=3;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==ASC) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==DESC) ) {
                        alt82=2;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1266:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC266=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3872); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC266_tree = (CommonTree)adaptor.dupNode(ASC266);


                            adaptor.addChild(root_0, ASC266_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1266:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC267=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3878); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC267_tree = (CommonTree)adaptor.dupNode(DESC267);


                            adaptor.addChild(root_0, DESC267_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1267:4: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1267:4: ( rank_col )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER||LA83_0==COL_RANGE) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1267:6: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3890);
                    	    rank_col268=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col268.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (rank_col268!=null?rank_col268.plan:null) );
                    	           retval.ascFlags.add( (rank_col268!=null?rank_col268.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt83 >= 1 ) break loop83;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1274:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
        LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC270=null;
        CommonTree DESC271=null;
        CommonTree ASC273=null;
        CommonTree DESC274=null;
        LogicalPlanGenerator.col_range_return col_range269 =null;

        LogicalPlanGenerator.col_ref_return col_ref272 =null;


        CommonTree ASC270_tree=null;
        CommonTree DESC271_tree=null;
        CommonTree ASC273_tree=null;
        CommonTree DESC274_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1279:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==COL_RANGE) ) {
                alt87=1;
            }
            else if ( (LA87_0==CUBE||LA87_0==DOLLARVAR||LA87_0==GROUP||LA87_0==IDENTIFIER) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1279:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3916);
                    col_range269=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range269.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1279:21: ( ASC | DESC )?
                    int alt85=3;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==ASC) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==DESC) ) {
                        alt85=2;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1279:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC270=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3920); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC270_tree = (CommonTree)adaptor.dupNode(ASC270);


                            adaptor.addChild(root_0, ASC270_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1279:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC271=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3924); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC271_tree = (CommonTree)adaptor.dupNode(DESC271);


                            adaptor.addChild(root_0, DESC271_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3934);
                    col_ref272=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref272.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:19: ( ASC | DESC )?
                    int alt86=3;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==ASC) ) {
                        alt86=1;
                    }
                    else if ( (LA86_0==DESC) ) {
                        alt86=2;
                    }
                    switch (alt86) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC273=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3939); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC273_tree = (CommonTree)adaptor.dupNode(ASC273);


                            adaptor.addChild(root_0, ASC273_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC274=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3943); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC274_tree = (CommonTree)adaptor.dupNode(DESC274);


                            adaptor.addChild(root_0, DESC274_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1283:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER275=null;
        LogicalPlanGenerator.rel_return rel276 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause277 =null;

        LogicalPlanGenerator.func_clause_return func_clause278 =null;


        CommonTree ORDER275_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER275=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER275_tree = (CommonTree)adaptor.dupNode(ORDER275);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER275_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3975);
            rel276=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel276.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3977);
            order_by_clause277=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause277.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==FUNC||LA88_0==FUNC_REF) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3979);
                    func_clause278=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause278.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER275 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause277!=null?order_by_clause277.plans:null),
                       (order_by_clause277!=null?order_by_clause277.ascFlags:null), (func_clause278!=null?func_clause278.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1297:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR279=null;
        CommonTree ASC280=null;
        CommonTree DESC281=null;
        LogicalPlanGenerator.order_col_return order_col282 =null;


        CommonTree STAR279_tree=null;
        CommonTree ASC280_tree=null;
        CommonTree DESC281_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1302:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==STAR) ) {
                alt91=1;
            }
            else if ( (LA91_0==CUBE||LA91_0==DOLLARVAR||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==COL_RANGE) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }
            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1302:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR279=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause4006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR279_tree = (CommonTree)adaptor.dupNode(STAR279);


                    adaptor.addChild(root_0, STAR279_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR279 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:4: ( ASC | DESC )?
                    int alt89=3;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==ASC) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==DESC) ) {
                        alt89=2;
                    }
                    switch (alt89) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC280=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause4015); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC280_tree = (CommonTree)adaptor.dupNode(ASC280);


                            adaptor.addChild(root_0, ASC280_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC281=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause4021); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC281_tree = (CommonTree)adaptor.dupNode(DESC281);


                            adaptor.addChild(root_0, DESC281_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1309:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1309:4: ( order_col )+
                    int cnt90=0;
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1309:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause4033);
                    	    order_col282=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col282.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col282!=null?order_col282.plan:null) );
                    	           retval.ascFlags.add( (order_col282!=null?order_col282.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt90 >= 1 ) break loop90;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(90, input);
                                throw eee;
                        }
                        cnt90++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1316:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC284=null;
        CommonTree DESC285=null;
        CommonTree ASC287=null;
        CommonTree DESC288=null;
        LogicalPlanGenerator.col_range_return col_range283 =null;

        LogicalPlanGenerator.col_ref_return col_ref286 =null;


        CommonTree ASC284_tree=null;
        CommonTree DESC285_tree=null;
        CommonTree ASC287_tree=null;
        CommonTree DESC288_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==COL_RANGE) ) {
                alt94=1;
            }
            else if ( (LA94_0==CUBE||LA94_0==DOLLARVAR||LA94_0==GROUP||LA94_0==IDENTIFIER) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col4059);
                    col_range283=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range283.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:21: ( ASC | DESC )?
                    int alt92=3;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==ASC) ) {
                        alt92=1;
                    }
                    else if ( (LA92_0==DESC) ) {
                        alt92=2;
                    }
                    switch (alt92) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC284=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4063); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC284_tree = (CommonTree)adaptor.dupNode(ASC284);


                            adaptor.addChild(root_0, ASC284_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1321:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC285=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4067); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC285_tree = (CommonTree)adaptor.dupNode(DESC285);


                            adaptor.addChild(root_0, DESC285_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1322:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col4077);
                    col_ref286=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref286.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1322:19: ( ASC | DESC )?
                    int alt93=3;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==ASC) ) {
                        alt93=1;
                    }
                    else if ( (LA93_0==DESC) ) {
                        alt93=2;
                    }
                    switch (alt93) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1322:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC287=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4082); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC287_tree = (CommonTree)adaptor.dupNode(ASC287);


                            adaptor.addChild(root_0, ASC287_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1322:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC288=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4086); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC288_tree = (CommonTree)adaptor.dupNode(DESC288);


                            adaptor.addChild(root_0, DESC288_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1325:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT289=null;
        LogicalPlanGenerator.rel_return rel290 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause291 =null;


        CommonTree DISTINCT289_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT289=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause4106); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT289_tree = (CommonTree)adaptor.dupNode(DISTINCT289);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT289_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause4108);
            rel290=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel290.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:20: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause4110);
                    partition_clause291=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause291.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT289 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause291!=null?partition_clause291.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1333:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION292=null;
        LogicalPlanGenerator.func_name_return func_name293 =null;


        CommonTree PARTITION292_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1334:2: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1334:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION292=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause4133); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION292_tree = (CommonTree)adaptor.dupNode(PARTITION292);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION292_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause4135);
            func_name293=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name293.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name293!=null?func_name293.funcName:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1340:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS294=null;
        LogicalPlanGenerator.rel_list_return rel_list295 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause296 =null;


        CommonTree CROSS294_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1341:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1341:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS294=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause4157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS294_tree = (CommonTree)adaptor.dupNode(CROSS294);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause4159);
            rel_list295=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list295.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1341:22: ( partition_clause )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==PARTITION) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1341:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause4161);
                    partition_clause296=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS294 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list295!=null?rel_list295.aliasList:null), (partition_clause296!=null?partition_clause296.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1348:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel297 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:2: ( ( rel )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:4: ( rel )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==ARROBA||LA97_0==ASSERT||LA97_0==COGROUP||(LA97_0 >= CROSS && LA97_0 <= CUBE)||LA97_0==DEFINE||LA97_0==DISTINCT||LA97_0==FILTER||LA97_0==FOREACH||LA97_0==GROUP||LA97_0==IDENTIFIER||LA97_0==JOIN||(LA97_0 >= LIMIT && LA97_0 <= LOAD)||LA97_0==MAPREDUCE||LA97_0==ORDER||LA97_0==RANK||LA97_0==SAMPLE||(LA97_0 >= STORE && LA97_0 <= STREAM)||LA97_0==UNION) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1350:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list4189);
            	    rel297=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel297.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt97 >= 1 ) break loop97;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    protected static class join_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1353:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN298=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause299 =null;

        LogicalPlanGenerator.join_type_return join_type300 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause301 =null;


        CommonTree JOIN298_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN298=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause4228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN298_tree = (CommonTree)adaptor.dupNode(JOIN298);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN298_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause4230);
            join_sub_clause299=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause299.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:28: ( join_type )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==QUOTEDSTRING) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause4232);
                    join_type300=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type300.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:39: ( partition_clause )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==PARTITION) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1371:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause4235);
                    partition_clause301=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause301.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN298 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type300!=null?join_type300.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause301!=null?partition_clause301.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING302=null;

        CommonTree QUOTEDSTRING302_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1381:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1381:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING302=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type4256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING302_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING302);


            adaptor.addChild(root_0, QUOTEDSTRING302_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING302!=null?QUOTEDSTRING302.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING302 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT304=null;
        CommonTree RIGHT305=null;
        CommonTree FULL306=null;
        CommonTree OUTER307=null;
        LogicalPlanGenerator.join_item_return join_item303 =null;

        LogicalPlanGenerator.join_item_return join_item308 =null;

        LogicalPlanGenerator.join_item_return join_item309 =null;


        CommonTree LEFT304_tree=null;
        CommonTree RIGHT305_tree=null;
        CommonTree FULL306_tree=null;
        CommonTree OUTER307_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==JOIN_ITEM) ) {
                int LA103_1 = input.LA(2);

                if ( (synpred179_LogicalPlanGenerator()) ) {
                    alt103=1;
                }
                else if ( (true) ) {
                    alt103=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4271);
                    join_item303=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item303.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:14: ( LEFT | RIGHT | FULL )
                    int alt100=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt100=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt100=2;
                        }
                        break;
                    case FULL:
                        {
                        alt100=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;

                    }

                    switch (alt100) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT304=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause4275); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT304_tree = (CommonTree)adaptor.dupNode(LEFT304);


                            adaptor.addChild(root_0, LEFT304_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1390:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT305=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause4294); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT305_tree = (CommonTree)adaptor.dupNode(RIGHT305);


                            adaptor.addChild(root_0, RIGHT305_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1392:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL306=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause4313); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL306_tree = (CommonTree)adaptor.dupNode(FULL306);


                            adaptor.addChild(root_0, FULL306_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1393:66: ( OUTER )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==OUTER) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1393:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER307=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause4319); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER307_tree = (CommonTree)adaptor.dupNode(OUTER307);


                            adaptor.addChild(root_0, OUTER307_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4322);
                    join_item308=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item308.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1396:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1396:4: ( join_item )+
                    int cnt102=0;
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==JOIN_ITEM) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1396:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause4332);
                    	    join_item309=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item309.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt102 >= 1 ) break loop102;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(102, input);
                                throw eee;
                        }
                        cnt102++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1399:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM310=null;
        LogicalPlanGenerator.rel_return rel311 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause312 =null;


        CommonTree JOIN_ITEM310_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM310=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item4345); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM310_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM310);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM310_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item4347);
            rel311=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel311.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item4349);
            join_group_by_clause312=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause312.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause312!=null?join_group_by_clause312.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1409:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY313=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr314 =null;


        CommonTree BY313_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1413:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1413:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY313=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause4376); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY313_tree = (CommonTree)adaptor.dupNode(BY313);


            root_1 = (CommonTree)adaptor.becomeRoot(BY313_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1413:10: ( join_group_by_expr )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==BIGDECIMALNUMBER||LA104_0==BIGINTEGERNUMBER||LA104_0==CUBE||LA104_0==DIV||LA104_0==DOLLARVAR||LA104_0==DOUBLENUMBER||LA104_0==FALSE||LA104_0==FLOATNUMBER||LA104_0==GROUP||LA104_0==IDENTIFIER||LA104_0==INTEGER||LA104_0==LONGINTEGER||LA104_0==MINUS||LA104_0==NULL||LA104_0==PERCENT||LA104_0==PLUS||LA104_0==QUOTEDSTRING||LA104_0==STAR||LA104_0==TRUE||(LA104_0 >= BAG_VAL && LA104_0 <= BIN_EXPR)||(LA104_0 >= CASE_COND && LA104_0 <= CASE_EXPR)||(LA104_0 >= CAST_EXPR && LA104_0 <= EXPR_IN_PAREN)||LA104_0==FUNC_EVAL||LA104_0==INVOKER_FUNC_EVAL||(LA104_0 >= MAP_VAL && LA104_0 <= NEG)||LA104_0==TUPLE_VAL) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1413:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause4380);
            	    join_group_by_expr314=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr314.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr314!=null?join_group_by_expr314.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1416:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR317=null;
        LogicalPlanGenerator.col_range_return col_range315 =null;

        LogicalPlanGenerator.expr_return expr316 =null;


        CommonTree STAR317_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1420:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt105=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt105=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt105=2;
                }
                break;
            case STAR:
                {
                int LA105_3 = input.LA(2);

                if ( (LA105_3==DOWN) ) {
                    alt105=2;
                }
                else if ( (LA105_3==EOF||LA105_3==UP||LA105_3==BIGDECIMALNUMBER||LA105_3==BIGINTEGERNUMBER||LA105_3==CUBE||LA105_3==DIV||LA105_3==DOLLARVAR||LA105_3==DOUBLENUMBER||LA105_3==FALSE||LA105_3==FLOATNUMBER||LA105_3==GROUP||LA105_3==IDENTIFIER||LA105_3==INTEGER||LA105_3==LONGINTEGER||LA105_3==MINUS||LA105_3==NULL||LA105_3==PERCENT||LA105_3==PLUS||LA105_3==QUOTEDSTRING||LA105_3==STAR||LA105_3==TRUE||(LA105_3 >= BAG_VAL && LA105_3 <= BIN_EXPR)||(LA105_3 >= CASE_COND && LA105_3 <= CASE_EXPR)||(LA105_3 >= CAST_EXPR && LA105_3 <= EXPR_IN_PAREN)||LA105_3==FUNC_EVAL||LA105_3==INVOKER_FUNC_EVAL||(LA105_3 >= MAP_VAL && LA105_3 <= NEG)||LA105_3==TUPLE_VAL) ) {
                    alt105=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }

            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1420:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr4405);
                    col_range315=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range315.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr4411);
                    expr316=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr316.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1422:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR317=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr4417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR317_tree = (CommonTree)adaptor.dupNode(STAR317);


                    adaptor.addChild(root_0, STAR317_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR317 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1429:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION318=null;
        CommonTree ONSCHEMA319=null;
        LogicalPlanGenerator.rel_list_return rel_list320 =null;


        CommonTree UNION318_tree=null;
        CommonTree ONSCHEMA319_tree=null;


            boolean onSchema = false;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1433:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1433:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION318=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause4442); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION318_tree = (CommonTree)adaptor.dupNode(UNION318);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION318_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1433:13: ( ONSCHEMA )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==ONSCHEMA) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1433:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA319=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause4446); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA319_tree = (CommonTree)adaptor.dupNode(ONSCHEMA319);


                    adaptor.addChild(root_1, ONSCHEMA319_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause4453);
            rel_list320=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list320.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION318 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list320!=null?rel_list320.aliasList:null), onSchema );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1440:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH321=null;
        LogicalPlanGenerator.rel_return rel322 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan323 =null;


        CommonTree FOREACH321_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:2: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH321=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH321_tree = (CommonTree)adaptor.dupNode(FOREACH321);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH321_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause4491);
            rel322=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel322.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause4493);
            foreach_plan323=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan323.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH321 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan323!=null?foreach_plan323.plan:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1457:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE324=null;
        CommonTree FOREACH_PLAN_COMPLEX326=null;
        LogicalPlanGenerator.generate_clause_return generate_clause325 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk327 =null;


        CommonTree FOREACH_PLAN_SIMPLE324_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX326_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==FOREACH_PLAN_SIMPLE) ) {
                alt107=1;
            }
            else if ( (LA107_0==FOREACH_PLAN_COMPLEX) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE324=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE324_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE324);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE324_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan4531);
                    generate_clause325=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause325.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1474:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX326=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX326_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX326);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX326_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan4542);
                    nested_blk327=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk327.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command328 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause329 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:12: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:14: ( nested_command )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( ((LA108_0 >= NESTED_CMD && LA108_0 <= NESTED_CMD_ASSI)) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk4553);
            	    nested_command328=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command328.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk4556);
            generate_clause329=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause329.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1480:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD330=null;
        CommonTree IDENTIFIER331=null;
        CommonTree NESTED_CMD_ASSI333=null;
        CommonTree IDENTIFIER334=null;
        LogicalPlanGenerator.nested_op_return nested_op332 =null;

        LogicalPlanGenerator.expr_return expr335 =null;


        CommonTree NESTED_CMD330_tree=null;
        CommonTree IDENTIFIER331_tree=null;
        CommonTree NESTED_CMD_ASSI333_tree=null;
        CommonTree IDENTIFIER334_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1488:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NESTED_CMD) ) {
                alt109=1;
            }
            else if ( (LA109_0==NESTED_CMD_ASSI) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1488:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD330=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD330_tree = (CommonTree)adaptor.dupNode(NESTED_CMD330);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD330_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER331=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER331_tree = (CommonTree)adaptor.dupNode(IDENTIFIER331);


                    adaptor.addChild(root_1, IDENTIFIER331_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command4582);
                    nested_op332=nested_op((IDENTIFIER331!=null?IDENTIFIER331.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op332.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER331!=null?IDENTIFIER331.getText():null), (nested_op332!=null?nested_op332.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER331!=null?IDENTIFIER331.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1494:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI333=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI333_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI333);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI333_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER334=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER334_tree = (CommonTree)adaptor.dupNode(IDENTIFIER334);


                    adaptor.addChild(root_1, IDENTIFIER334_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command4604);
                    expr335=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr335.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER334!=null?IDENTIFIER334.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1500:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj336 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter337 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort338 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct339 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit340 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross341 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach342 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1501:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt110=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt110=1;
                }
                break;
            case FILTER:
                {
                alt110=2;
                }
                break;
            case ORDER:
                {
                alt110=3;
                }
                break;
            case DISTINCT:
                {
                alt110=4;
                }
                break;
            case LIMIT:
                {
                alt110=5;
                }
                break;
            case CROSS:
                {
                alt110=6;
                }
                break;
            case FOREACH:
                {
                alt110=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1501:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op4626);
                    nested_proj336=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj336.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj336!=null?nested_proj336.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1502:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op4634);
                    nested_filter337=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter337.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter337!=null?nested_filter337.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1503:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op4642);
                    nested_sort338=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort338.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort338!=null?nested_sort338.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1504:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4651);
                    nested_distinct339=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct339.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct339!=null?nested_distinct339.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1505:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4659);
                    nested_limit340=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit340.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit340!=null?nested_limit340.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1506:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4667);
                    nested_cross341=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross341.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross341!=null?nested_cross341.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4675);
                    nested_foreach342=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach342.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach342!=null?nested_foreach342.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1510:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ343=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ343_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1515:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ343=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ343_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ343);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4711);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt111=0;
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4726);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt111 >= 1 ) break loop111;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(111, input);
                        throw eee;
                }
                cnt111++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1529:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER344=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input345 =null;

        LogicalPlanGenerator.cond_return cond346 =null;


        CommonTree FILTER344_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1536:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1536:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER344=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4779); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER344_tree = (CommonTree)adaptor.dupNode(FILTER344);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER344_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4781);
            nested_op_input345=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input345.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4783);
            cond346=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond346.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER344 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input345!=null?nested_op_input345.op:null), plan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER347=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input348 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause349 =null;

        LogicalPlanGenerator.func_clause_return func_clause350 =null;


        CommonTree ORDER347_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER347=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER347_tree = (CommonTree)adaptor.dupNode(ORDER347);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER347_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4819);
            nested_op_input348=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input348.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4821);
            order_by_clause349=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause349.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==FUNC||LA112_0==FUNC_REF) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4823);
                    func_clause350=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause350.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER347 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input348!=null?nested_op_input348.op:null),
                       (order_by_clause349!=null?order_by_clause349.plans:null), (order_by_clause349!=null?order_by_clause349.ascFlags:null), (func_clause350!=null?func_clause350.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1559:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT351=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input352 =null;


        CommonTree DISTINCT351_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1563:2: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1563:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT351=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4853); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT351_tree = (CommonTree)adaptor.dupNode(DISTINCT351);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT351_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4855);
            nested_op_input352=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input352.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT351 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input352!=null?nested_op_input352.op:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1570:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT353=null;
        CommonTree INTEGER355=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input354 =null;

        LogicalPlanGenerator.expr_return expr356 =null;


        CommonTree LIMIT353_tree=null;
        CommonTree INTEGER355_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT353=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT353_tree = (CommonTree)adaptor.dupNode(LIMIT353);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT353_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4890);
            nested_op_input354=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input354.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:29: ( INTEGER | expr[exprPlan] )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==INTEGER) ) {
                int LA113_1 = input.LA(2);

                if ( (synpred196_LogicalPlanGenerator()) ) {
                    alt113=1;
                }
                else if ( (true) ) {
                    alt113=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 113, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||LA113_0==CAST_EXPR||LA113_0==EXPR_IN_PAREN||LA113_0==FUNC_EVAL||LA113_0==INVOKER_FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }
            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER355=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER355_tree = (CommonTree)adaptor.dupNode(INTEGER355);


                    adaptor.addChild(root_1, INTEGER355_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT353 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input354!=null?nested_op_input354.op:null),
                               Integer.valueOf( (INTEGER355!=null?INTEGER355.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1583:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4904);
                    expr356=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr356.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT353 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input354!=null?nested_op_input354.op:null), exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1592:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS357=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list358 =null;


        CommonTree CROSS357_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:2: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS357=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS357_tree = (CommonTree)adaptor.dupNode(CROSS357);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS357_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4939);
            nested_op_input_list358=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list358.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS357 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list358!=null?nested_op_input_list358.opList:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1603:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH359=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input360 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause361 =null;


        CommonTree FOREACH359_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1613:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1613:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH359=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH359_tree = (CommonTree)adaptor.dupNode(FOREACH359);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH359_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4973);
            nested_op_input360=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input360.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4975);
            generate_clause361=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause361.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH359 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input360!=null?nested_op_input360.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1621:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE362=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item363 =null;


        CommonTree GENERATE362_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE362=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause5004); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE362_tree = (CommonTree)adaptor.dupNode(GENERATE362);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE362_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:16: ( flatten_generated_item )+
            int cnt114=0;
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==BIGDECIMALNUMBER||LA114_0==BIGINTEGERNUMBER||LA114_0==CUBE||LA114_0==DIV||LA114_0==DOLLARVAR||LA114_0==DOUBLENUMBER||LA114_0==FALSE||LA114_0==FLATTEN||LA114_0==FLOATNUMBER||LA114_0==GROUP||LA114_0==IDENTIFIER||LA114_0==INTEGER||LA114_0==LONGINTEGER||LA114_0==MINUS||LA114_0==NULL||LA114_0==PERCENT||LA114_0==PLUS||LA114_0==QUOTEDSTRING||LA114_0==STAR||LA114_0==TRUE||(LA114_0 >= BAG_VAL && LA114_0 <= BIN_EXPR)||(LA114_0 >= CASE_COND && LA114_0 <= CASE_EXPR)||(LA114_0 >= CAST_EXPR && LA114_0 <= EXPR_IN_PAREN)||LA114_0==FUNC_EVAL||LA114_0==INVOKER_FUNC_EVAL||(LA114_0 >= MAP_VAL && LA114_0 <= NEG)||LA114_0==TUPLE_VAL) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1629:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause5008);
            	    flatten_generated_item363=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item363.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item363!=null?flatten_generated_item363.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item363!=null?flatten_generated_item363.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item363!=null?flatten_generated_item363.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt114 >= 1 ) break loop114;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(114, input);
                        throw eee;
                }
                cnt114++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE362 ),
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, plans, flattenFlags, schemas );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1644:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref364 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj365 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1648:2: ( col_ref[plan] | nested_proj[null] )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER) ) {
                alt115=1;
            }
            else if ( (LA115_0==NESTED_PROJ) ) {
                alt115=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }
            switch (alt115) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1648:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input5074);
                    col_ref364=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref364.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref364!=null?((CommonTree)col_ref364.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref364!=null?col_ref364.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input5085);
                    nested_proj365=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj365.getTree());


                    if ( state.backtracking==0 ) {
                           retval.op = (nested_proj365!=null?nested_proj365.op:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1660:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input366 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:2: ( ( nested_op_input )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:4: ( nested_op_input )+
            int cnt116=0;
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==CUBE||LA116_0==DOLLARVAR||LA116_0==GROUP||LA116_0==IDENTIFIER||LA116_0==NESTED_PROJ) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list5111);
            	    nested_op_input366=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input366.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input366!=null?nested_op_input366.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt116 >= 1 ) break loop116;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(116, input);
                        throw eee;
                }
                cnt116++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1665:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM367=null;
        CommonTree EXECCOMMAND369=null;
        CommonTree IDENTIFIER370=null;
        LogicalPlanGenerator.rel_return rel368 =null;

        LogicalPlanGenerator.as_clause_return as_clause371 =null;


        CommonTree STREAM367_tree=null;
        CommonTree EXECCOMMAND369_tree=null;
        CommonTree IDENTIFIER370_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1670:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1670:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM367=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause5136); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM367_tree = (CommonTree)adaptor.dupNode(STREAM367);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM367_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause5138);
            rel368=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel368.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1670:18: ( EXECCOMMAND | IDENTIFIER )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==EXECCOMMAND) ) {
                alt117=1;
            }
            else if ( (LA117_0==IDENTIFIER) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1670:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND369=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause5142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND369_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND369);


                    adaptor.addChild(root_1, EXECCOMMAND369_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND369!=null?EXECCOMMAND369.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1671:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER370=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause5165); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER370_tree = (CommonTree)adaptor.dupNode(IDENTIFIER370);


                    adaptor.addChild(root_1, IDENTIFIER370_tree);
                    }


                    if ( state.backtracking==0 ) {
                                           cmd = builder.lookupCommand( (IDENTIFIER370!=null?IDENTIFIER370.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER370!=null?IDENTIFIER370.getText():null) + "]";
                                               throw new ParserValidationException( input,
                                                   new SourceLocation( (PigParserNode)IDENTIFIER370 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1680:20: ( as_clause )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==AS) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1680:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause5207);
                    as_clause371=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause371.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause371!=null?as_clause371.logicalSchema:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1687:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE372=null;
        CommonTree QUOTEDSTRING373=null;
        CommonTree EXECCOMMAND377=null;
        LogicalPlanGenerator.path_list_return path_list374 =null;

        LogicalPlanGenerator.store_clause_return store_clause375 =null;

        LogicalPlanGenerator.load_clause_return load_clause376 =null;


        CommonTree MAPREDUCE372_tree=null;
        CommonTree QUOTEDSTRING373_tree=null;
        CommonTree EXECCOMMAND377_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1693:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1693:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE372=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause5235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE372_tree = (CommonTree)adaptor.dupNode(MAPREDUCE372);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE372_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING373=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause5237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING373_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING373);


            adaptor.addChild(root_1, QUOTEDSTRING373_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1693:30: ( path_list[paths] )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==QUOTEDSTRING) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1693:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause5239);
                    path_list374=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list374.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause5250);
            store_clause375=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause375.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause5259);
            load_clause376=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause376.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:6: ( EXECCOMMAND )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==EXECCOMMAND) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND377=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause5266); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND377_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND377);


                    adaptor.addChild(root_1, EXECCOMMAND377_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING373!=null?QUOTEDSTRING373.getText():null) ), builder.unquote( (EXECCOMMAND377!=null?EXECCOMMAND377.getText():null) ),
                       paths, (store_clause375!=null?store_clause375.alias:null), (load_clause376!=null?load_clause376.alias:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1704:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT378=null;
        LogicalPlanGenerator.rel_return rel379 =null;

        LogicalPlanGenerator.split_branch_return split_branch380 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise381 =null;


        CommonTree SPLIT378_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1705:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1705:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT378=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause5286); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT378_tree = (CommonTree)adaptor.dupNode(SPLIT378);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT378_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause5294);
            rel379=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel379.getTree());


            if ( state.backtracking==0 ) {
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT378 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:7: ( split_branch )+
            int cnt121=0;
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==SPLIT_BRANCH) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause5310);
            	    split_branch380=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch380.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt121 >= 1 ) break loop121;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(121, input);
                        throw eee;
                }
                cnt121++;
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:21: ( split_otherwise )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==OTHERWISE) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause5313);
                    split_otherwise381=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise381.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1715:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH382=null;
        LogicalPlanGenerator.alias_return alias383 =null;

        LogicalPlanGenerator.cond_return cond384 =null;


        CommonTree SPLIT_BRANCH382_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH382=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch5342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH382_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH382);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH382_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch5344);
            alias383=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias383.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch5346);
            cond384=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond384.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias383!=null?((CommonTree)alias383.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias383!=null?alias383.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1729:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE385=null;
        LogicalPlanGenerator.alias_return alias386 =null;


        CommonTree OTHERWISE385_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1734:2: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1734:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE385=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise5380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE385_tree = (CommonTree)adaptor.dupNode(OTHERWISE385);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE385_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise5382);
            alias386=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias386.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias386!=null?((CommonTree)alias386.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias386!=null?alias386.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1742:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref387 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref388 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1743:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==CUBE||LA123_0==GROUP||LA123_0==IDENTIFIER) ) {
                alt123=1;
            }
            else if ( (LA123_0==DOLLARVAR) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }
            switch (alt123) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1743:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref5402);
                    alias_col_ref387=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref387.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref387!=null?alias_col_ref387.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1744:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref5410);
                    dollar_col_ref388=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref388.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref388!=null?dollar_col_ref388.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1747:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP389=null;
        CommonTree CUBE390=null;
        CommonTree IDENTIFIER391=null;

        CommonTree GROUP389_tree=null;
        CommonTree CUBE390_tree=null;
        CommonTree IDENTIFIER391_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1748:2: ( GROUP | CUBE | IDENTIFIER )
            int alt124=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt124=1;
                }
                break;
            case CUBE:
                {
                alt124=2;
                }
                break;
            case IDENTIFIER:
                {
                alt124=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1748:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP389=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref5427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP389_tree = (CommonTree)adaptor.dupNode(GROUP389);


                    adaptor.addChild(root_0, GROUP389_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP389 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP389!=null?GROUP389.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1753:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE390=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref5437); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE390_tree = (CommonTree)adaptor.dupNode(CUBE390);


                    adaptor.addChild(root_0, CUBE390_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)CUBE390 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (CUBE390!=null?CUBE390.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1758:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER391=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref5447); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER391_tree = (CommonTree)adaptor.dupNode(IDENTIFIER391);


                    adaptor.addChild(root_0, IDENTIFIER391_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER391 );
                           String alias = (IDENTIFIER391!=null?IDENTIFIER391.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }

                           // PIG-3581
                           // check within foreach scope before looking at outer scope for scalar
                           if( inForeachPlan && (((foreach_plan_scope)foreach_plan_stack.peek()).operators).containsKey(alias)) {
                               retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                   ((foreach_plan_scope)foreach_plan_stack.peek()).operators, ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                           } else {
                               Operator op = builder.lookupOperator( alias );
                               if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                                   retval.expr = new ScalarExpression( plan, op,
                                       inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                                   retval.expr.setLocation( loc );
                               } else if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1796:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR392=null;

        CommonTree DOLLARVAR392_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1797:2: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1797:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR392=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5466); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR392_tree = (CommonTree)adaptor.dupNode(DOLLARVAR392);


            adaptor.addChild(root_0, DOLLARVAR392_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR392!=null?DOLLARVAR392.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR392 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1805:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal393 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1806:2: ( literal )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1806:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr5485);
            literal393=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal393.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal393!=null?literal393.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1813:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar394 =null;

        LogicalPlanGenerator.map_return map395 =null;

        LogicalPlanGenerator.bag_return bag396 =null;

        LogicalPlanGenerator.tuple_return tuple397 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1814:2: ( scalar | map | bag | tuple )
            int alt125=4;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
                {
                alt125=1;
                }
                break;
            case MAP_VAL:
                {
                alt125=2;
                }
                break;
            case BAG_VAL:
                {
                alt125=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt125=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;

            }

            switch (alt125) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1814:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal5503);
                    scalar394=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar394.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar394!=null?scalar394.value:null);
                           retval.type = (scalar394!=null?scalar394.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1819:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal5513);
                    map395=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map395.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map395!=null?map395.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1824:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal5523);
                    bag396=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag396.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag396!=null?bag396.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1829:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal5533);
                    tuple397=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple397.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple397!=null?tuple397.value:null);
                           retval.type = DataType.TUPLE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1836:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING399=null;
        CommonTree NULL400=null;
        CommonTree TRUE401=null;
        CommonTree FALSE402=null;
        LogicalPlanGenerator.num_scalar_return num_scalar398 =null;


        CommonTree QUOTEDSTRING399_tree=null;
        CommonTree NULL400_tree=null;
        CommonTree TRUE401_tree=null;
        CommonTree FALSE402_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1837:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt126=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt126=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt126=2;
                }
                break;
            case NULL:
                {
                alt126=3;
                }
                break;
            case TRUE:
                {
                alt126=4;
                }
                break;
            case FALSE:
                {
                alt126=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;

            }

            switch (alt126) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1837:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar5551);
                    num_scalar398=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar398.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar398!=null?num_scalar398.type:0);
                           retval.value = (num_scalar398!=null?num_scalar398.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1842:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING399=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING399_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING399);


                    adaptor.addChild(root_0, QUOTEDSTRING399_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING399!=null?QUOTEDSTRING399.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1847:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL400=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL400_tree = (CommonTree)adaptor.dupNode(NULL400);


                    adaptor.addChild(root_0, NULL400_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1851:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE401=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE401_tree = (CommonTree)adaptor.dupNode(TRUE401);


                    adaptor.addChild(root_0, TRUE401_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1856:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE402=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE402_tree = (CommonTree)adaptor.dupNode(FALSE402);


                    adaptor.addChild(root_0, FALSE402_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1863:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS403=null;
        CommonTree INTEGER404=null;
        CommonTree LONGINTEGER405=null;
        CommonTree FLOATNUMBER406=null;
        CommonTree DOUBLENUMBER407=null;
        CommonTree BIGINTEGERNUMBER408=null;
        CommonTree BIGDECIMALNUMBER409=null;

        CommonTree MINUS403_tree=null;
        CommonTree INTEGER404_tree=null;
        CommonTree LONGINTEGER405_tree=null;
        CommonTree FLOATNUMBER406_tree=null;
        CommonTree DOUBLENUMBER407_tree=null;
        CommonTree BIGINTEGERNUMBER408_tree=null;
        CommonTree BIGDECIMALNUMBER409_tree=null;


            int sign = 1;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1867:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1867:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1867:4: ( MINUS )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==MINUS) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1867:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS403=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS403_tree = (CommonTree)adaptor.dupNode(MINUS403);


                    adaptor.addChild(root_0, MINUS403_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1868:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt128=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt128=1;
                }
                break;
            case LONGINTEGER:
                {
                alt128=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt128=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt128=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt128=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt128=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;

            }

            switch (alt128) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1868:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER404=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER404_tree = (CommonTree)adaptor.dupNode(INTEGER404);


                    adaptor.addChild(root_0, INTEGER404_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER404!=null?INTEGER404.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1873:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER405=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER405_tree = (CommonTree)adaptor.dupNode(LONGINTEGER405);


                    adaptor.addChild(root_0, LONGINTEGER405_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER405!=null?LONGINTEGER405.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1878:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER406=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER406_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER406);


                    adaptor.addChild(root_0, FLOATNUMBER406_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER406!=null?FLOATNUMBER406.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER407=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER407_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER407);


                    adaptor.addChild(root_0, DOUBLENUMBER407_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER407!=null?DOUBLENUMBER407.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1888:6: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER408=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar5685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER408_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER408);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER408_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGINTEGER;
                             retval.value = builder.parseBigInteger( (BIGINTEGERNUMBER408!=null?BIGINTEGERNUMBER408.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigInteger)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1896:6: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER409=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar5699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER409_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER409);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER409_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGDECIMAL;
                             retval.value = builder.parseBigDecimal( (BIGDECIMALNUMBER409!=null?BIGDECIMALNUMBER409.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigDecimal)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1907:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL410=null;
        LogicalPlanGenerator.keyvalue_return keyvalue411 =null;


        CommonTree MAP_VAL410_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1909:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1909:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL410=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5731); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL410_tree = (CommonTree)adaptor.dupNode(MAP_VAL410);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL410_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1909:15: ( keyvalue )*
                loop129:
                do {
                    int alt129=2;
                    int LA129_0 = input.LA(1);

                    if ( (LA129_0==KEY_VAL_PAIR) ) {
                        alt129=1;
                    }


                    switch (alt129) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1909:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map5735);
                	    keyvalue411=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue411.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue411!=null?keyvalue411.key:null), (keyvalue411!=null?keyvalue411.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop129;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1915:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR412=null;
        LogicalPlanGenerator.map_key_return map_key413 =null;

        LogicalPlanGenerator.literal_return literal414 =null;


        CommonTree KEY_VAL_PAIR412_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR412=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR412_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR412);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR412_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue5764);
            map_key413=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key413.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue5766);
            literal414=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal414.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key413!=null?map_key413.value:null);
                   retval.value = (literal414!=null?literal414.value:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1923:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING415=null;

        CommonTree QUOTEDSTRING415_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING415=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING415_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING415);


            adaptor.addChild(root_0, QUOTEDSTRING415_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING415!=null?QUOTEDSTRING415.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1927:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL416=null;
        LogicalPlanGenerator.tuple_return tuple417 =null;


        CommonTree BAG_VAL416_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1929:2: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1929:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL416=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag5808); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL416_tree = (CommonTree)adaptor.dupNode(BAG_VAL416);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL416_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1929:15: ( tuple )*
                loop130:
                do {
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==TUPLE_VAL) ) {
                        alt130=1;
                    }


                    switch (alt130) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1929:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag5812);
                	    tuple417=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple417.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple417!=null?tuple417.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop130;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1935:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL418=null;
        LogicalPlanGenerator.literal_return literal419 =null;


        CommonTree TUPLE_VAL418_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL418=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple5844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL418_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL418);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL418_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:17: ( literal )*
                loop131:
                do {
                    int alt131=2;
                    int LA131_0 = input.LA(1);

                    if ( (LA131_0==BIGDECIMALNUMBER||LA131_0==BIGINTEGERNUMBER||LA131_0==DOUBLENUMBER||LA131_0==FALSE||LA131_0==FLOATNUMBER||LA131_0==INTEGER||LA131_0==LONGINTEGER||LA131_0==MINUS||LA131_0==NULL||LA131_0==QUOTEDSTRING||LA131_0==TRUE||LA131_0==BAG_VAL||LA131_0==MAP_VAL||LA131_0==TUPLE_VAL) ) {
                        alt131=1;
                    }


                    switch (alt131) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple5848);
                	    literal419=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal419.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal419!=null?literal419.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop131;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1944:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | PIVOT | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT421=null;
        CommonTree RETURNS422=null;
        CommonTree DEFINE423=null;
        CommonTree LOAD424=null;
        CommonTree FILTER425=null;
        CommonTree FOREACH426=null;
        CommonTree MATCHES427=null;
        CommonTree ORDER428=null;
        CommonTree DISTINCT429=null;
        CommonTree COGROUP430=null;
        CommonTree CUBE431=null;
        CommonTree ROLLUP432=null;
        CommonTree PIVOT433=null;
        CommonTree JOIN434=null;
        CommonTree CROSS435=null;
        CommonTree UNION436=null;
        CommonTree SPLIT437=null;
        CommonTree INTO438=null;
        CommonTree IF439=null;
        CommonTree ALL440=null;
        CommonTree AS441=null;
        CommonTree BY442=null;
        CommonTree USING443=null;
        CommonTree INNER444=null;
        CommonTree OUTER445=null;
        CommonTree PARALLEL446=null;
        CommonTree PARTITION447=null;
        CommonTree GROUP448=null;
        CommonTree AND449=null;
        CommonTree OR450=null;
        CommonTree NOT451=null;
        CommonTree GENERATE452=null;
        CommonTree FLATTEN453=null;
        CommonTree EVAL454=null;
        CommonTree ASC455=null;
        CommonTree DESC456=null;
        CommonTree BOOLEAN457=null;
        CommonTree INT458=null;
        CommonTree LONG459=null;
        CommonTree FLOAT460=null;
        CommonTree DOUBLE461=null;
        CommonTree BIGINTEGER462=null;
        CommonTree BIGDECIMAL463=null;
        CommonTree DATETIME464=null;
        CommonTree CHARARRAY465=null;
        CommonTree BYTEARRAY466=null;
        CommonTree BAG467=null;
        CommonTree TUPLE468=null;
        CommonTree MAP469=null;
        CommonTree IS470=null;
        CommonTree NULL471=null;
        CommonTree TRUE472=null;
        CommonTree FALSE473=null;
        CommonTree STREAM474=null;
        CommonTree THROUGH475=null;
        CommonTree STORE476=null;
        CommonTree MAPREDUCE477=null;
        CommonTree SHIP478=null;
        CommonTree CACHE479=null;
        CommonTree INPUT480=null;
        CommonTree OUTPUT481=null;
        CommonTree STDERROR482=null;
        CommonTree STDIN483=null;
        CommonTree STDOUT484=null;
        CommonTree LIMIT485=null;
        CommonTree SAMPLE486=null;
        CommonTree LEFT487=null;
        CommonTree RIGHT488=null;
        CommonTree FULL489=null;
        CommonTree IDENTIFIER490=null;
        CommonTree TOBAG491=null;
        CommonTree TOMAP492=null;
        CommonTree TOTUPLE493=null;
        CommonTree ASSERT494=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op420 =null;


        CommonTree IMPORT421_tree=null;
        CommonTree RETURNS422_tree=null;
        CommonTree DEFINE423_tree=null;
        CommonTree LOAD424_tree=null;
        CommonTree FILTER425_tree=null;
        CommonTree FOREACH426_tree=null;
        CommonTree MATCHES427_tree=null;
        CommonTree ORDER428_tree=null;
        CommonTree DISTINCT429_tree=null;
        CommonTree COGROUP430_tree=null;
        CommonTree CUBE431_tree=null;
        CommonTree ROLLUP432_tree=null;
        CommonTree PIVOT433_tree=null;
        CommonTree JOIN434_tree=null;
        CommonTree CROSS435_tree=null;
        CommonTree UNION436_tree=null;
        CommonTree SPLIT437_tree=null;
        CommonTree INTO438_tree=null;
        CommonTree IF439_tree=null;
        CommonTree ALL440_tree=null;
        CommonTree AS441_tree=null;
        CommonTree BY442_tree=null;
        CommonTree USING443_tree=null;
        CommonTree INNER444_tree=null;
        CommonTree OUTER445_tree=null;
        CommonTree PARALLEL446_tree=null;
        CommonTree PARTITION447_tree=null;
        CommonTree GROUP448_tree=null;
        CommonTree AND449_tree=null;
        CommonTree OR450_tree=null;
        CommonTree NOT451_tree=null;
        CommonTree GENERATE452_tree=null;
        CommonTree FLATTEN453_tree=null;
        CommonTree EVAL454_tree=null;
        CommonTree ASC455_tree=null;
        CommonTree DESC456_tree=null;
        CommonTree BOOLEAN457_tree=null;
        CommonTree INT458_tree=null;
        CommonTree LONG459_tree=null;
        CommonTree FLOAT460_tree=null;
        CommonTree DOUBLE461_tree=null;
        CommonTree BIGINTEGER462_tree=null;
        CommonTree BIGDECIMAL463_tree=null;
        CommonTree DATETIME464_tree=null;
        CommonTree CHARARRAY465_tree=null;
        CommonTree BYTEARRAY466_tree=null;
        CommonTree BAG467_tree=null;
        CommonTree TUPLE468_tree=null;
        CommonTree MAP469_tree=null;
        CommonTree IS470_tree=null;
        CommonTree NULL471_tree=null;
        CommonTree TRUE472_tree=null;
        CommonTree FALSE473_tree=null;
        CommonTree STREAM474_tree=null;
        CommonTree THROUGH475_tree=null;
        CommonTree STORE476_tree=null;
        CommonTree MAPREDUCE477_tree=null;
        CommonTree SHIP478_tree=null;
        CommonTree CACHE479_tree=null;
        CommonTree INPUT480_tree=null;
        CommonTree OUTPUT481_tree=null;
        CommonTree STDERROR482_tree=null;
        CommonTree STDIN483_tree=null;
        CommonTree STDOUT484_tree=null;
        CommonTree LIMIT485_tree=null;
        CommonTree SAMPLE486_tree=null;
        CommonTree LEFT487_tree=null;
        CommonTree RIGHT488_tree=null;
        CommonTree FULL489_tree=null;
        CommonTree IDENTIFIER490_tree=null;
        CommonTree TOBAG491_tree=null;
        CommonTree TOMAP492_tree=null;
        CommonTree TOTUPLE493_tree=null;
        CommonTree ASSERT494_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1944:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | PIVOT | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt132=75;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt132=1;
                }
                break;
            case IMPORT:
                {
                alt132=2;
                }
                break;
            case RETURNS:
                {
                alt132=3;
                }
                break;
            case DEFINE:
                {
                alt132=4;
                }
                break;
            case LOAD:
                {
                alt132=5;
                }
                break;
            case FILTER:
                {
                alt132=6;
                }
                break;
            case FOREACH:
                {
                alt132=7;
                }
                break;
            case MATCHES:
                {
                alt132=8;
                }
                break;
            case ORDER:
                {
                alt132=9;
                }
                break;
            case DISTINCT:
                {
                alt132=10;
                }
                break;
            case COGROUP:
                {
                alt132=11;
                }
                break;
            case CUBE:
                {
                alt132=12;
                }
                break;
            case ROLLUP:
                {
                alt132=13;
                }
                break;
            case PIVOT:
                {
                alt132=14;
                }
                break;
            case JOIN:
                {
                alt132=15;
                }
                break;
            case CROSS:
                {
                alt132=16;
                }
                break;
            case UNION:
                {
                alt132=17;
                }
                break;
            case SPLIT:
                {
                alt132=18;
                }
                break;
            case INTO:
                {
                alt132=19;
                }
                break;
            case IF:
                {
                alt132=20;
                }
                break;
            case ALL:
                {
                alt132=21;
                }
                break;
            case AS:
                {
                alt132=22;
                }
                break;
            case BY:
                {
                alt132=23;
                }
                break;
            case USING:
                {
                alt132=24;
                }
                break;
            case INNER:
                {
                alt132=25;
                }
                break;
            case OUTER:
                {
                alt132=26;
                }
                break;
            case PARALLEL:
                {
                alt132=27;
                }
                break;
            case PARTITION:
                {
                alt132=28;
                }
                break;
            case GROUP:
                {
                alt132=29;
                }
                break;
            case AND:
                {
                alt132=30;
                }
                break;
            case OR:
                {
                alt132=31;
                }
                break;
            case NOT:
                {
                alt132=32;
                }
                break;
            case GENERATE:
                {
                alt132=33;
                }
                break;
            case FLATTEN:
                {
                alt132=34;
                }
                break;
            case EVAL:
                {
                alt132=35;
                }
                break;
            case ASC:
                {
                alt132=36;
                }
                break;
            case DESC:
                {
                alt132=37;
                }
                break;
            case BOOLEAN:
                {
                alt132=38;
                }
                break;
            case INT:
                {
                alt132=39;
                }
                break;
            case LONG:
                {
                alt132=40;
                }
                break;
            case FLOAT:
                {
                alt132=41;
                }
                break;
            case DOUBLE:
                {
                alt132=42;
                }
                break;
            case BIGINTEGER:
                {
                alt132=43;
                }
                break;
            case BIGDECIMAL:
                {
                alt132=44;
                }
                break;
            case DATETIME:
                {
                alt132=45;
                }
                break;
            case CHARARRAY:
                {
                alt132=46;
                }
                break;
            case BYTEARRAY:
                {
                alt132=47;
                }
                break;
            case BAG:
                {
                alt132=48;
                }
                break;
            case TUPLE:
                {
                alt132=49;
                }
                break;
            case MAP:
                {
                alt132=50;
                }
                break;
            case IS:
                {
                alt132=51;
                }
                break;
            case NULL:
                {
                alt132=52;
                }
                break;
            case TRUE:
                {
                alt132=53;
                }
                break;
            case FALSE:
                {
                alt132=54;
                }
                break;
            case STREAM:
                {
                alt132=55;
                }
                break;
            case THROUGH:
                {
                alt132=56;
                }
                break;
            case STORE:
                {
                alt132=57;
                }
                break;
            case MAPREDUCE:
                {
                alt132=58;
                }
                break;
            case SHIP:
                {
                alt132=59;
                }
                break;
            case CACHE:
                {
                alt132=60;
                }
                break;
            case INPUT:
                {
                alt132=61;
                }
                break;
            case OUTPUT:
                {
                alt132=62;
                }
                break;
            case STDERROR:
                {
                alt132=63;
                }
                break;
            case STDIN:
                {
                alt132=64;
                }
                break;
            case STDOUT:
                {
                alt132=65;
                }
                break;
            case LIMIT:
                {
                alt132=66;
                }
                break;
            case SAMPLE:
                {
                alt132=67;
                }
                break;
            case LEFT:
                {
                alt132=68;
                }
                break;
            case RIGHT:
                {
                alt132=69;
                }
                break;
            case FULL:
                {
                alt132=70;
                }
                break;
            case IDENTIFIER:
                {
                alt132=71;
                }
                break;
            case TOBAG:
                {
                alt132=72;
                }
                break;
            case TOMAP:
                {
                alt132=73;
                }
                break;
            case TOTUPLE:
                {
                alt132=74;
                }
                break;
            case ASSERT:
                {
                alt132=75;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;

            }

            switch (alt132) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1944:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid5873);
                    rel_str_op420=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op420.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op420!=null?rel_str_op420.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT421=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT421_tree = (CommonTree)adaptor.dupNode(IMPORT421);


                    adaptor.addChild(root_0, IMPORT421_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT421!=null?IMPORT421.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1946:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS422=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS422_tree = (CommonTree)adaptor.dupNode(RETURNS422);


                    adaptor.addChild(root_0, RETURNS422_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS422!=null?RETURNS422.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1947:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE423=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5903); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE423_tree = (CommonTree)adaptor.dupNode(DEFINE423);


                    adaptor.addChild(root_0, DEFINE423_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE423!=null?DEFINE423.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1948:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD424=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD424_tree = (CommonTree)adaptor.dupNode(LOAD424);


                    adaptor.addChild(root_0, LOAD424_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD424!=null?LOAD424.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1949:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER425=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5923); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER425_tree = (CommonTree)adaptor.dupNode(FILTER425);


                    adaptor.addChild(root_0, FILTER425_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER425!=null?FILTER425.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1950:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH426=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5933); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH426_tree = (CommonTree)adaptor.dupNode(FOREACH426);


                    adaptor.addChild(root_0, FOREACH426_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH426!=null?FOREACH426.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1951:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES427=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES427_tree = (CommonTree)adaptor.dupNode(MATCHES427);


                    adaptor.addChild(root_0, MATCHES427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES427!=null?MATCHES427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1952:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER428=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER428_tree = (CommonTree)adaptor.dupNode(ORDER428);


                    adaptor.addChild(root_0, ORDER428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER428!=null?ORDER428.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT429=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT429_tree = (CommonTree)adaptor.dupNode(DISTINCT429);


                    adaptor.addChild(root_0, DISTINCT429_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT429!=null?DISTINCT429.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1954:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP430=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5973); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP430_tree = (CommonTree)adaptor.dupNode(COGROUP430);


                    adaptor.addChild(root_0, COGROUP430_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP430!=null?COGROUP430.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1955:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE431=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE431_tree = (CommonTree)adaptor.dupNode(CUBE431);


                    adaptor.addChild(root_0, CUBE431_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CUBE431!=null?CUBE431.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1956:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP432=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5993); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP432_tree = (CommonTree)adaptor.dupNode(ROLLUP432);


                    adaptor.addChild(root_0, ROLLUP432_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ROLLUP432!=null?ROLLUP432.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1957:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT433=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid6003); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT433_tree = (CommonTree)adaptor.dupNode(PIVOT433);


                    adaptor.addChild(root_0, PIVOT433_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PIVOT433!=null?PIVOT433.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1958:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN434=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid6013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN434_tree = (CommonTree)adaptor.dupNode(JOIN434);


                    adaptor.addChild(root_0, JOIN434_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN434!=null?JOIN434.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1959:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS435=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid6023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS435_tree = (CommonTree)adaptor.dupNode(CROSS435);


                    adaptor.addChild(root_0, CROSS435_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS435!=null?CROSS435.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION436=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid6033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION436_tree = (CommonTree)adaptor.dupNode(UNION436);


                    adaptor.addChild(root_0, UNION436_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION436!=null?UNION436.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1961:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT437=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid6043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT437_tree = (CommonTree)adaptor.dupNode(SPLIT437);


                    adaptor.addChild(root_0, SPLIT437_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT437!=null?SPLIT437.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1962:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO438=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid6053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO438_tree = (CommonTree)adaptor.dupNode(INTO438);


                    adaptor.addChild(root_0, INTO438_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO438!=null?INTO438.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1963:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF439=(CommonTree)match(input,IF,FOLLOW_IF_in_eid6063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF439_tree = (CommonTree)adaptor.dupNode(IF439);


                    adaptor.addChild(root_0, IF439_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF439!=null?IF439.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1964:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL440=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid6073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL440_tree = (CommonTree)adaptor.dupNode(ALL440);


                    adaptor.addChild(root_0, ALL440_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL440!=null?ALL440.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1965:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS441=(CommonTree)match(input,AS,FOLLOW_AS_in_eid6083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS441_tree = (CommonTree)adaptor.dupNode(AS441);


                    adaptor.addChild(root_0, AS441_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS441!=null?AS441.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1966:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY442=(CommonTree)match(input,BY,FOLLOW_BY_in_eid6093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY442_tree = (CommonTree)adaptor.dupNode(BY442);


                    adaptor.addChild(root_0, BY442_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY442!=null?BY442.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1967:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING443=(CommonTree)match(input,USING,FOLLOW_USING_in_eid6103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING443_tree = (CommonTree)adaptor.dupNode(USING443);


                    adaptor.addChild(root_0, USING443_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING443!=null?USING443.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1968:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER444=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid6113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER444_tree = (CommonTree)adaptor.dupNode(INNER444);


                    adaptor.addChild(root_0, INNER444_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER444!=null?INNER444.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1969:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER445=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid6123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER445_tree = (CommonTree)adaptor.dupNode(OUTER445);


                    adaptor.addChild(root_0, OUTER445_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER445!=null?OUTER445.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1970:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL446=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid6133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL446_tree = (CommonTree)adaptor.dupNode(PARALLEL446);


                    adaptor.addChild(root_0, PARALLEL446_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL446!=null?PARALLEL446.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1971:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION447=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid6143); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION447_tree = (CommonTree)adaptor.dupNode(PARTITION447);


                    adaptor.addChild(root_0, PARTITION447_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION447!=null?PARTITION447.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1972:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP448=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid6153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP448_tree = (CommonTree)adaptor.dupNode(GROUP448);


                    adaptor.addChild(root_0, GROUP448_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP448!=null?GROUP448.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1973:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND449=(CommonTree)match(input,AND,FOLLOW_AND_in_eid6163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND449_tree = (CommonTree)adaptor.dupNode(AND449);


                    adaptor.addChild(root_0, AND449_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND449!=null?AND449.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1974:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR450=(CommonTree)match(input,OR,FOLLOW_OR_in_eid6173); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR450_tree = (CommonTree)adaptor.dupNode(OR450);


                    adaptor.addChild(root_0, OR450_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR450!=null?OR450.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1975:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT451=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid6183); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT451_tree = (CommonTree)adaptor.dupNode(NOT451);


                    adaptor.addChild(root_0, NOT451_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT451!=null?NOT451.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1976:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE452=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid6193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE452_tree = (CommonTree)adaptor.dupNode(GENERATE452);


                    adaptor.addChild(root_0, GENERATE452_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE452!=null?GENERATE452.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1977:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN453=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid6203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN453_tree = (CommonTree)adaptor.dupNode(FLATTEN453);


                    adaptor.addChild(root_0, FLATTEN453_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN453!=null?FLATTEN453.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1978:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL454=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid6213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL454_tree = (CommonTree)adaptor.dupNode(EVAL454);


                    adaptor.addChild(root_0, EVAL454_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL454!=null?EVAL454.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1979:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC455=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid6223); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC455_tree = (CommonTree)adaptor.dupNode(ASC455);


                    adaptor.addChild(root_0, ASC455_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC455!=null?ASC455.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1980:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC456=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid6233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC456_tree = (CommonTree)adaptor.dupNode(DESC456);


                    adaptor.addChild(root_0, DESC456_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC456!=null?DESC456.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1981:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN457=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid6243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN457_tree = (CommonTree)adaptor.dupNode(BOOLEAN457);


                    adaptor.addChild(root_0, BOOLEAN457_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN457!=null?BOOLEAN457.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1982:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT458=(CommonTree)match(input,INT,FOLLOW_INT_in_eid6253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT458_tree = (CommonTree)adaptor.dupNode(INT458);


                    adaptor.addChild(root_0, INT458_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT458!=null?INT458.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG459=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid6263); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG459_tree = (CommonTree)adaptor.dupNode(LONG459);


                    adaptor.addChild(root_0, LONG459_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG459!=null?LONG459.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1984:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT460=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid6273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT460_tree = (CommonTree)adaptor.dupNode(FLOAT460);


                    adaptor.addChild(root_0, FLOAT460_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT460!=null?FLOAT460.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1985:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE461=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid6283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE461_tree = (CommonTree)adaptor.dupNode(DOUBLE461);


                    adaptor.addChild(root_0, DOUBLE461_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE461!=null?DOUBLE461.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1986:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER462=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid6293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER462_tree = (CommonTree)adaptor.dupNode(BIGINTEGER462);


                    adaptor.addChild(root_0, BIGINTEGER462_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGINTEGER462!=null?BIGINTEGER462.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1987:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL463=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid6303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL463_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL463);


                    adaptor.addChild(root_0, BIGDECIMAL463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGDECIMAL463!=null?BIGDECIMAL463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1988:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME464=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid6313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME464_tree = (CommonTree)adaptor.dupNode(DATETIME464);


                    adaptor.addChild(root_0, DATETIME464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DATETIME464!=null?DATETIME464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1989:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY465=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid6323); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY465_tree = (CommonTree)adaptor.dupNode(CHARARRAY465);


                    adaptor.addChild(root_0, CHARARRAY465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY465!=null?CHARARRAY465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1990:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY466=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid6333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY466_tree = (CommonTree)adaptor.dupNode(BYTEARRAY466);


                    adaptor.addChild(root_0, BYTEARRAY466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY466!=null?BYTEARRAY466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1991:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG467=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid6343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG467_tree = (CommonTree)adaptor.dupNode(BAG467);


                    adaptor.addChild(root_0, BAG467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG467!=null?BAG467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1992:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE468=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid6353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE468_tree = (CommonTree)adaptor.dupNode(TUPLE468);


                    adaptor.addChild(root_0, TUPLE468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE468!=null?TUPLE468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1993:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP469=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid6363); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP469_tree = (CommonTree)adaptor.dupNode(MAP469);


                    adaptor.addChild(root_0, MAP469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP469!=null?MAP469.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1994:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS470=(CommonTree)match(input,IS,FOLLOW_IS_in_eid6373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS470_tree = (CommonTree)adaptor.dupNode(IS470);


                    adaptor.addChild(root_0, IS470_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS470!=null?IS470.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1995:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL471=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid6383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL471_tree = (CommonTree)adaptor.dupNode(NULL471);


                    adaptor.addChild(root_0, NULL471_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL471!=null?NULL471.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1996:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE472=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid6393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE472_tree = (CommonTree)adaptor.dupNode(TRUE472);


                    adaptor.addChild(root_0, TRUE472_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE472!=null?TRUE472.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1997:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE473=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid6403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE473_tree = (CommonTree)adaptor.dupNode(FALSE473);


                    adaptor.addChild(root_0, FALSE473_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE473!=null?FALSE473.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1998:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM474=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid6413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM474_tree = (CommonTree)adaptor.dupNode(STREAM474);


                    adaptor.addChild(root_0, STREAM474_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM474!=null?STREAM474.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1999:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH475=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid6423); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH475_tree = (CommonTree)adaptor.dupNode(THROUGH475);


                    adaptor.addChild(root_0, THROUGH475_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH475!=null?THROUGH475.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2000:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE476=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid6433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE476_tree = (CommonTree)adaptor.dupNode(STORE476);


                    adaptor.addChild(root_0, STORE476_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE476!=null?STORE476.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2001:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE477=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid6443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE477_tree = (CommonTree)adaptor.dupNode(MAPREDUCE477);


                    adaptor.addChild(root_0, MAPREDUCE477_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE477!=null?MAPREDUCE477.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2002:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP478=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid6453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP478_tree = (CommonTree)adaptor.dupNode(SHIP478);


                    adaptor.addChild(root_0, SHIP478_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP478!=null?SHIP478.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2003:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE479=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid6463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE479_tree = (CommonTree)adaptor.dupNode(CACHE479);


                    adaptor.addChild(root_0, CACHE479_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE479!=null?CACHE479.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2004:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT480=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid6473); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT480_tree = (CommonTree)adaptor.dupNode(INPUT480);


                    adaptor.addChild(root_0, INPUT480_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT480!=null?INPUT480.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2005:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT481=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid6483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT481_tree = (CommonTree)adaptor.dupNode(OUTPUT481);


                    adaptor.addChild(root_0, OUTPUT481_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT481!=null?OUTPUT481.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2006:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR482=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid6493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR482_tree = (CommonTree)adaptor.dupNode(STDERROR482);


                    adaptor.addChild(root_0, STDERROR482_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR482!=null?STDERROR482.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2007:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN483=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid6503); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN483_tree = (CommonTree)adaptor.dupNode(STDIN483);


                    adaptor.addChild(root_0, STDIN483_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN483!=null?STDIN483.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2008:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT484=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT484_tree = (CommonTree)adaptor.dupNode(STDOUT484);


                    adaptor.addChild(root_0, STDOUT484_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT484!=null?STDOUT484.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2009:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT485=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT485_tree = (CommonTree)adaptor.dupNode(LIMIT485);


                    adaptor.addChild(root_0, LIMIT485_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT485!=null?LIMIT485.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2010:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE486=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6533); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE486_tree = (CommonTree)adaptor.dupNode(SAMPLE486);


                    adaptor.addChild(root_0, SAMPLE486_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE486!=null?SAMPLE486.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2011:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT487=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT487_tree = (CommonTree)adaptor.dupNode(LEFT487);


                    adaptor.addChild(root_0, LEFT487_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT487!=null?LEFT487.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2012:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT488=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT488_tree = (CommonTree)adaptor.dupNode(RIGHT488);


                    adaptor.addChild(root_0, RIGHT488_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT488!=null?RIGHT488.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2013:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL489=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL489_tree = (CommonTree)adaptor.dupNode(FULL489);


                    adaptor.addChild(root_0, FULL489_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL489!=null?FULL489.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2014:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER490=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER490_tree = (CommonTree)adaptor.dupNode(IDENTIFIER490);


                    adaptor.addChild(root_0, IDENTIFIER490_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER490!=null?IDENTIFIER490.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2015:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG491=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG491_tree = (CommonTree)adaptor.dupNode(TOBAG491);


                    adaptor.addChild(root_0, TOBAG491_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2016:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP492=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP492_tree = (CommonTree)adaptor.dupNode(TOMAP492);


                    adaptor.addChild(root_0, TOMAP492_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2017:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE493=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6603); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE493_tree = (CommonTree)adaptor.dupNode(TOTUPLE493);


                    adaptor.addChild(root_0, TOTUPLE493_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2018:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT494=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid6613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT494_tree = (CommonTree)adaptor.dupNode(ASSERT494);


                    adaptor.addChild(root_0, ASSERT494_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "ASSERT"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2022:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES501=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq495 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne496 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt497 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte498 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt499 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte500 =null;


        CommonTree STR_OP_MATCHES501_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2022:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt133=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt133=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt133=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt133=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt133=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt133=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt133=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt133=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }

            switch (alt133) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2022:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6626);
                    rel_op_eq495=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq495.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2023:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6637);
                    rel_op_ne496=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne496.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2024:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6648);
                    rel_op_gt497=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt497.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2025:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6659);
                    rel_op_gte498=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte498.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2026:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6670);
                    rel_op_lt499=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt499.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2027:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6681);
                    rel_op_lte500=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte500.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2028:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES501=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES501_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES501);


                    adaptor.addChild(root_0, STR_OP_MATCHES501_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2031:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set502=null;

        CommonTree set502_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2031:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set502=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set502_tree = (CommonTree)adaptor.dupNode(set502);


                adaptor.addChild(root_0, set502_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2034:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set503=null;

        CommonTree set503_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2034:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set503=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set503_tree = (CommonTree)adaptor.dupNode(set503);


                adaptor.addChild(root_0, set503_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2037:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set504=null;

        CommonTree set504_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2037:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set504=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set504_tree = (CommonTree)adaptor.dupNode(set504);


                adaptor.addChild(root_0, set504_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set505=null;

        CommonTree set505_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set505=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set505_tree = (CommonTree)adaptor.dupNode(set505);


                adaptor.addChild(root_0, set505_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2043:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set506=null;

        CommonTree set506_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2043:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set506=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set506_tree = (CommonTree)adaptor.dupNode(set506);


                adaptor.addChild(root_0, set506_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2046:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set507=null;

        CommonTree set507_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2046:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set507=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set507_tree = (CommonTree)adaptor.dupNode(set507);


                adaptor.addChild(root_0, set507_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2049:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ508=null;
        CommonTree STR_OP_NE509=null;
        CommonTree STR_OP_GT510=null;
        CommonTree STR_OP_LT511=null;
        CommonTree STR_OP_GTE512=null;
        CommonTree STR_OP_LTE513=null;
        CommonTree STR_OP_MATCHES514=null;

        CommonTree STR_OP_EQ508_tree=null;
        CommonTree STR_OP_NE509_tree=null;
        CommonTree STR_OP_GT510_tree=null;
        CommonTree STR_OP_LT511_tree=null;
        CommonTree STR_OP_GTE512_tree=null;
        CommonTree STR_OP_LTE513_tree=null;
        CommonTree STR_OP_MATCHES514_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2050:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt134=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt134=1;
                }
                break;
            case STR_OP_NE:
                {
                alt134=2;
                }
                break;
            case STR_OP_GT:
                {
                alt134=3;
                }
                break;
            case STR_OP_LT:
                {
                alt134=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt134=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt134=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt134=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;

            }

            switch (alt134) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2050:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ508=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ508_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ508);


                    adaptor.addChild(root_0, STR_OP_EQ508_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ508!=null?STR_OP_EQ508.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2051:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE509=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE509_tree = (CommonTree)adaptor.dupNode(STR_OP_NE509);


                    adaptor.addChild(root_0, STR_OP_NE509_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE509!=null?STR_OP_NE509.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2052:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT510=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT510_tree = (CommonTree)adaptor.dupNode(STR_OP_GT510);


                    adaptor.addChild(root_0, STR_OP_GT510_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT510!=null?STR_OP_GT510.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2053:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT511=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT511_tree = (CommonTree)adaptor.dupNode(STR_OP_LT511);


                    adaptor.addChild(root_0, STR_OP_LT511_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT511!=null?STR_OP_LT511.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2054:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE512=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6811); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE512_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE512);


                    adaptor.addChild(root_0, STR_OP_GTE512_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE512!=null?STR_OP_GTE512.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2055:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE513=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE513_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE513);


                    adaptor.addChild(root_0, STR_OP_LTE513_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE513!=null?STR_OP_LTE513.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:2056:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES514=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6825); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES514_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES514);


                    adaptor.addChild(root_0, STR_OP_MATCHES514_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES514!=null?STR_OP_MATCHES514.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred147_LogicalPlanGenerator
    public final void synpred147_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:20: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1175:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred147_LogicalPlanGenerator3680); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred147_LogicalPlanGenerator

    // $ANTLR start synpred148_LogicalPlanGenerator
    public final void synpred148_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1180:4: ( LONGINTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1180:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred148_LogicalPlanGenerator3690); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_LogicalPlanGenerator

    // $ANTLR start synpred149_LogicalPlanGenerator
    public final void synpred149_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:20: ( DOUBLENUMBER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1199:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred149_LogicalPlanGenerator3742); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_LogicalPlanGenerator

    // $ANTLR start synpred179_LogicalPlanGenerator
    public final void synpred179_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4271);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1393:66: ( OUTER )?
        int alt149=2;
        int LA149_0 = input.LA(1);

        if ( (LA149_0==OUTER) ) {
            alt149=1;
        }
        switch (alt149) {
            case 1 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1393:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred179_LogicalPlanGenerator4319); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4322);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred179_LogicalPlanGenerator

    // $ANTLR start synpred196_LogicalPlanGenerator
    public final void synpred196_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:31: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/LogicalPlanGenerator.g:1577:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred196_LogicalPlanGenerator4894); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred196_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred196_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred196_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred147_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred179_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred179_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query89 = new BitSet(new long[]{0x0000000000000408L,0x0040040000000000L,0x0024000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement169 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement171 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_USING_in_register_statement174 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement176 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement178 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement203 = new BitSet(new long[]{0x0048400226400400L,0x1802020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_op_clause_in_general_statement214 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause235 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause588 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_define_clause609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd642 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd647 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd652 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd656 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd660 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list702 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause749 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause881 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause919 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause994 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause996 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause998 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause1002 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1071 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200040000004000L});
    public static final BitSet FOLLOW_type_in_field_def1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1098 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_simple_type_in_type1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1327 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1329 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1386 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1404 = new BitSet(new long[]{0x0000000000000008L,0x0000010000020000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1436 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1450 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFF4B1813D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1456 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFF4B1813D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_eid_in_func_name1472 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1501 = new BitSet(new long[]{0x0000000000000002L,0x0000010000020000L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511 = new BitSet(new long[]{0x0000000000000002L,0x0000010000020000L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1596 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1652 = new BitSet(new long[]{0x0000000004000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1684 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1698 = new BitSet(new long[]{0x0000000000000008L,0x0000001000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1702 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1727 = new BitSet(new long[]{0x814410540400A002L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1803 = new BitSet(new long[]{0x0148400226400488L,0x1802030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_type_in_group_clause1808 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1830 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1832 = new BitSet(new long[]{0x0148400226400488L,0x1802030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_type_in_group_clause1837 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1844 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1885 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1889 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1913 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1937 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op2040 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item2068 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item2078 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item2086 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item2094 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2153 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2155 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause2191 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause2193 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_assert_clause2195 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause2198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2248 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_filter_clause2250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2280 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_cond2287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2308 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_cond2315 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2353 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond2356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond2371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2377 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2384 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond2399 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2405 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond2427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2433 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2440 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2461 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2489 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2496 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2511 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2517 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2545 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond2552 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2595 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2701 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2705 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2729 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2733 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2737 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2741 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_expr_in_real_arg2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2820 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr2827 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2842 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2848 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr2855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2876 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr2883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2898 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2904 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr2911 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2926 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2932 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr2939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2982 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2997 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2999 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr3005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr3021 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr3027 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast3069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3104 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast3108 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast3137 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr3164 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr3174 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr3188 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj3288 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj3292 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range3381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range3388 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3393 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range3400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj3426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj3436 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3456 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr3458 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr3465 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr3472 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr3501 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr3509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr3546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3552 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3600 = new BitSet(new long[]{0x0800000000000048L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_THEN_in_case_cond3628 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3632 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3676 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3690 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3738 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3800 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3830 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3834 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3863 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3890 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3916 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3934 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3975 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3977 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3979 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause4006 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause4033 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_order_col4059 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col4077 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause4106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause4108 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause4110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause4133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause4135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause4157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause4159 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause4161 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list4189 = new BitSet(new long[]{0x0148400226400482L,0x1802020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_JOIN_in_join_clause4228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause4230 = new BitSet(new long[]{0x0000000000000008L,0x0000010200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause4232 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause4235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type4256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4271 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause4275 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause4294 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause4313 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause4319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4332 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item4345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item4347 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item4349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause4376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause4380 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause4442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause4446 = new BitSet(new long[]{0x0148400226400480L,0x1802020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_rel_list_in_union_clause4453 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause4489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause4491 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4493 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan4531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan4542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk4553 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4580 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000800000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command4582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4602 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_nested_command4604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4711 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4726 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4781 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_nested_filter4783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4819 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4821 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4888 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4890 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4894 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4904 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4973 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4975 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause5004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause5008 = new BitSet(new long[]{0x814490540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input5074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input5085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list5111 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause5136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause5138 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause5142 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause5165 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause5207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause5235 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause5237 = new BitSet(new long[]{0x0000000000000000L,0x0800010000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause5239 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause5250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause5259 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause5266 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause5286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause5294 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause5310 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause5313 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch5342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch5344 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_split_branch5346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise5380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise5382 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref5410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref5437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref5447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal5503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal5523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal5533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar5571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar5591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar5616 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar5685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map5731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map5735 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue5764 = new BitSet(new long[]{0x800410400000A000L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_literal_in_keyvalue5766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag5808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag5812 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple5848 = new BitSet(new long[]{0x800410400000A008L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_rel_str_op_in_eid5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid5893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid6013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid6023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid6043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid6083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid6103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid6123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid6163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid6173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid6193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid6203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid6213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid6233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid6253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid6263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid6273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid6283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid6293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid6313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid6333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid6343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid6373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid6393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid6403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid6413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid6423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid6463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid6483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid6493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid6503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid6543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid6553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid6563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid6573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid6583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid6593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid6613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred147_LogicalPlanGenerator3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred148_LogicalPlanGenerator3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred149_LogicalPlanGenerator3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4271 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_synpred179_LogicalPlanGenerator4273 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred179_LogicalPlanGenerator4319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred196_LogicalPlanGenerator4894 = new BitSet(new long[]{0x0000000000000002L});

}