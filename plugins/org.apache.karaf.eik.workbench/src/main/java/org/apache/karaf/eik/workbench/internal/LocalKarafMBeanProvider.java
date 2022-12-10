/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.karaf.eik.workbench.internal;

import org.apache.karaf.eik.core.KarafPlatformModel;
import org.apache.karaf.eik.workbench.jmx.JMXServiceDescriptor;

import java.io.IOException;

import javax.management.remote.JMXConnector;

public class LocalKarafMBeanProvider extends KarafMBeanProvider {

    private final KarafPlatformModel platformModel;

    public LocalKarafMBeanProvider(final JMXServiceDescriptor jmxServiceDescriptor, final JMXConnector connector, final KarafPlatformModel platforModel) throws IOException {
        super(jmxServiceDescriptor, connector);

        this.platformModel = platforModel;
    }

    @Override
    public Object getAdapter(final @SuppressWarnings("rawtypes") Class adapter) {
        if (KarafPlatformModel.class.equals(adapter)) {
            return platformModel;
        } else {
            return super.getAdapter(adapter);
        }
    }

}
