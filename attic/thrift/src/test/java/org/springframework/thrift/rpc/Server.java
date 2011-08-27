/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.thrift.rpc;

import org.springframework.remoting.thrift.ThriftExporter;
import org.springframework.thrift.crm.Crm;
import org.springframework.util.ClassUtils;

/**
 * Simple example demonstrating how to expose a regular POJO using Thrift
 *
 * @author Josh Long
 */
public class Server {
	public static void main(String args[]) throws Throwable {

		CustomCrmService crmService = new CustomCrmService();
		ThriftExporter exporter = new ThriftExporter();
		exporter.setService(crmService);
		exporter.setServiceInterface(Crm.class);
		exporter.setBeanClassLoader(ClassUtils.getDefaultClassLoader());
		exporter.afterPropertiesSet();
		exporter.start();
	}
}