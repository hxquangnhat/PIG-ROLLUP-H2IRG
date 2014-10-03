/**
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

register $zebraJar;
fs -rmr $outputDir

a1 = LOAD '$inputDir/$unsorted1' USING org.apache.hadoop.zebra.pig.TableLoader('m1');
--limitedVals = LIMIT a1 10;
--dump limitedVals;

store a1 into '$outputDir/store1' using org.apache.hadoop.zebra.pig.TableStorer('[m1]');    

a2 = LOAD '$outputDir/store1' USING org.apache.hadoop.zebra.pig.TableLoader('m1');
--limitedVals = LIMIT a2 10;
--dump limitedVals;


store a2 into '$outputDir/store2' using org.apache.hadoop.zebra.pig.TableStorer('[m1]');    

                
