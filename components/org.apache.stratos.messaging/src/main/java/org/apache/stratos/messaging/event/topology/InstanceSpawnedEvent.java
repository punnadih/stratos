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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.stratos.messaging.event.topology;


import java.io.Serializable;


/**
 * This event is fired by Cloud Controller when a member is spawned by the IaaS in a given cluster.
 */
public class InstanceSpawnedEvent extends TopologyEvent implements Serializable {
    private static final long serialVersionUID = 2672909702971355178L;
    private String serviceName;
    private String clusterId;
    private String memberId;
    private String partitionId;


    public InstanceSpawnedEvent(String serviceName, String clusterId, String memberId, String iaasNodeId) {
        this.serviceName = serviceName;
        this.clusterId = clusterId;
        this.memberId = memberId;
        this.partitionId = iaasNodeId;
    }
    
    public String getPartitionId() {
        return partitionId;
    }
    
    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getClusterId() {
        return clusterId;
    }

    public String getMemberId() {
        return memberId;
    }

}
