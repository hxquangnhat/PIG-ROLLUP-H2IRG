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

package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.partitioners;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.io.PigNullableWritable;

/**
 * This class provides a partitioner when the RollupOptimizer is activated.
 * The map output key space is partitioned by the dimension which the pivot
 * position is assigned to.
 * For example, we have a tuple (year, month, day, payload) and the pivot is 
 * 2, so the map output space will be partitioned by month, which means that
 * there will be one reducer per month.
 */
public class RollupH2IRGPartitioner extends HashPartitioner<PigNullableWritable, Writable> implements
		Configurable {
	
	protected MessageDigest m = null;
	protected int pivot = 0;
	protected int choosen = 0;
	protected int i;
	protected Tuple t;
	protected Byte kt;
	protected PigNullableWritable realKey;
	protected int rollup_position = 0;
	protected int rollup_start_position = 0;
	protected boolean pivotZero = false;
	protected int length = 0;
	protected int iSpecial = -1;
	
	public RollupH2IRGPartitioner() throws NoSuchAlgorithmException{
		m = MessageDigest.getInstance("MD5");
	}

	public void setPivot(int pvt)
	{
		pivot = pvt;
	}
	
	public int getPartition(PigNullableWritable key, Writable value, int numPartitions) {		
		try {
			t = (Tuple) key.getValueAsPigType();
			if(pivotZero){//We use IRG --> only one reducer.
				return 0;
			}
			else{
				if(t.get(pivot-1) == null)//We transfer them to the determined reducer.
					if(t.size() > length) {//Check if it is a special tuple
						int len_t = t.size();
						//Send it to the reducer which has been decided before
						//by the addition dimension we added in the cleanup phase
						//of each map.
						return (Integer)t.get(len_t - 1);
					}
					else
						return choosen % numPartitions;
				else {
					m.reset();
					for(i = rollup_position; i < pivot; i++) {
						int tmp = (Integer)t.get(i);
						m.update(ByteBuffer.allocate(4).putInt(tmp).array());
					}
		            return (m.digest()[15] & Integer.MAX_VALUE) % numPartitions;
				}
			}
		} catch (ExecException e) {
			throw new RuntimeException(e);
		}
	}

	public Configuration getConf() {
		throw new UnsupportedOperationException();
	}

	public void setConf(Configuration conf) {
		pivot = Integer.parseInt(conf.get("rollup.h2irg.pivot"));
		rollup_position = Integer.parseInt(conf.get("rollup.h2irg.rollup_position"));
		rollup_start_position = Integer.parseInt(conf.get("rollup.h2irg.rollup_start_position"));
		length = Integer.parseInt(conf.get("rollup.h2irg.dimension_size"));
		if(pivot == 0)
			pivotZero = true;
		
		if(rollup_position!=0)
			pivot = pivot + rollup_position;
	}
}