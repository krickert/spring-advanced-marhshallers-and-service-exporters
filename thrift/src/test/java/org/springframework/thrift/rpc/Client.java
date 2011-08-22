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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.remoting.thrift.ThriftProxyFactoryBean;
import org.springframework.thrift.crm.Crm;
import org.springframework.thrift.crm.Customer;
import org.springframework.util.ClassUtils;

public class Client {
	static public void main(String args[]) throws Throwable {
		ThriftProxyFactoryBean client = new ThriftProxyFactoryBean();
		client.setBeanClassLoader(ClassUtils.getDefaultClassLoader());
		client.setServiceInterface(Crm.class);
		client.afterPropertiesSet();
		Object proxy = client.getObject();
		Crm.Iface clientProxy = (Crm.Iface) proxy;
		Customer customer = clientProxy.createCustomer("josh", "Long", "josh.long@email.com");
		System.out.println(ToStringBuilder.reflectionToString(customer));
	}
}
