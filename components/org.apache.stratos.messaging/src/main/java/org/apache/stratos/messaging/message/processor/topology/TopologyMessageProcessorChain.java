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

package org.apache.stratos.messaging.message.processor.topology;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.stratos.messaging.listener.EventListener;
import org.apache.stratos.messaging.listener.topology.*;
import org.apache.stratos.messaging.message.processor.MessageProcessorChain;

/**
 * Defines default topology message processor chain.
 */
// Grouping
public class TopologyMessageProcessorChain extends MessageProcessorChain {
    private static final Log log = LogFactory.getLog(TopologyMessageProcessorChain.class);

    private CompleteTopologyMessageProcessor completeTopologyMessageProcessor;
    private ServiceCreatedMessageProcessor serviceCreatedMessageProcessor;
    private ServiceRemovedMessageProcessor serviceRemovedMessageProcessor;
    private ClusterCreatedMessageProcessor clusterCreatedMessageProcessor;
    private ClusterActivatedProcessor clusterActivatedProcessor;
    private ClusterRemovedMessageProcessor clusterRemovedMessageProcessor;
    private InstanceSpawnedMessageProcessor instanceSpawnedMessageProcessor;
    private MemberStartedMessageProcessor memberStartedMessageProcessor;
    private MemberActivatedMessageProcessor memberActivatedMessageProcessor;
    private MemberReadyToShutdownMessageProcessor memberReadyToShutdownProcessor;
    private MemberMaintenanceModeProcessor memberMaintenanceModeProcessor;
    private MemberSuspendedMessageProcessor memberSuspendedMessageProcessor;
    private MemberTerminatedMessageProcessor memberTerminatedMessageProcessor;
    private GroupActivatedProcessor groupActivatedProcessor;
    //private CompositeApplicationRemovedMessageProcessor compositeApplicationRemovedMessageProcessor;
    private ApplicationCreatedMessageProcessor applicationCreatedMessageProcessor;
    private ApplicationUndeployedMessageProcessor applicationUndeployedMessageProcessor;
    private ApplicationRemovedMessageProcessor applicationRemovedMessageProcessor;
    private ApplicationActivatedMessageProcessor applicationActivatedMessageProcessor;

    public void initialize() {
        // Add topology event processors
        completeTopologyMessageProcessor = new CompleteTopologyMessageProcessor();
        add(completeTopologyMessageProcessor);

        serviceCreatedMessageProcessor = new ServiceCreatedMessageProcessor();
        add(serviceCreatedMessageProcessor);

        serviceRemovedMessageProcessor = new ServiceRemovedMessageProcessor();
        add(serviceRemovedMessageProcessor);

        clusterCreatedMessageProcessor = new ClusterCreatedMessageProcessor();
        add(clusterCreatedMessageProcessor);

        clusterActivatedProcessor = new ClusterActivatedProcessor();
        add(clusterActivatedProcessor);

        clusterRemovedMessageProcessor = new ClusterRemovedMessageProcessor();
        add(clusterRemovedMessageProcessor);

        instanceSpawnedMessageProcessor = new InstanceSpawnedMessageProcessor();
        add(instanceSpawnedMessageProcessor);

        memberStartedMessageProcessor = new MemberStartedMessageProcessor();
        add(memberStartedMessageProcessor);

        memberActivatedMessageProcessor = new MemberActivatedMessageProcessor();
        add(memberActivatedMessageProcessor);

        memberReadyToShutdownProcessor = new MemberReadyToShutdownMessageProcessor();
        add(memberReadyToShutdownProcessor);

        memberMaintenanceModeProcessor = new MemberMaintenanceModeProcessor();
        add(memberMaintenanceModeProcessor);

        memberSuspendedMessageProcessor = new MemberSuspendedMessageProcessor();
        add(memberSuspendedMessageProcessor);

        memberTerminatedMessageProcessor = new MemberTerminatedMessageProcessor();
        add(memberTerminatedMessageProcessor);

        groupActivatedProcessor = new GroupActivatedProcessor();
        add(groupActivatedProcessor);

        applicationCreatedMessageProcessor = new ApplicationCreatedMessageProcessor();
        add(applicationCreatedMessageProcessor);

        applicationUndeployedMessageProcessor = new ApplicationUndeployedMessageProcessor();
        add(applicationUndeployedMessageProcessor);

        applicationRemovedMessageProcessor = new ApplicationRemovedMessageProcessor();
        add(applicationRemovedMessageProcessor);

        applicationActivatedMessageProcessor = new ApplicationActivatedMessageProcessor();
        add(applicationActivatedMessageProcessor);

        if (log.isDebugEnabled()) {
            log.debug("Topology message processor chain initialized X1");
        }
    }

    public void addEventListener(EventListener eventListener) {
        if (eventListener instanceof CompleteTopologyEventListener) {
            completeTopologyMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ClusterCreatedEventListener) {
            clusterCreatedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ClusterActivatedEventListener) {
            clusterActivatedProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ClusterRemovedEventListener) {
            clusterRemovedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof InstanceSpawnedEventListener) {
            instanceSpawnedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof MemberActivatedEventListener) {
            memberActivatedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof MemberStartedEventListener) {
            memberStartedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof MemberReadyToShutdownEventListener) {
            memberReadyToShutdownProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof MemberSuspendedEventListener) {
            memberSuspendedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof MemberTerminatedEventListener) {
            memberTerminatedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ServiceCreatedEventListener) {
            serviceCreatedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ServiceRemovedEventListener) {
            serviceRemovedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof  MemberMaintenanceListener) {
            memberMaintenanceModeProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof GroupActivatedEventListener) {
            groupActivatedProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ApplicationCreatedEventListener) {
            applicationCreatedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ApplicationUndeployedEventListener) {
            applicationUndeployedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ApplicationRemovedEventListener) {
            applicationRemovedMessageProcessor.addEventListener(eventListener);
        } else if (eventListener instanceof ApplicationActivatedEventListener) {
            applicationActivatedMessageProcessor.addEventListener(eventListener);
        } else {
            throw new RuntimeException("Unknown event listener");
        }
    }
}
