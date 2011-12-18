/**
 * Copyright (C) 2011 Gabriel Ciuloaica (gciuloaica@gmail.com)
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */
package com.devsprint.jersey.api.netty.container.test;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;

/**
 * Provide a TestContainerFactory implementation for Netty.
 * 
 * @author gciuloaica
 * 
 */
public class NettyTestContainerFactory implements TestContainerFactory {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(NettyTestContainerFactory.class.getName());

	/**
	 * @see com.sun.jersey.test.framework.spi.container.TestContainerFactory#supports()
	 */
	@SuppressWarnings("unchecked")
	public Class<LowLevelAppDescriptor> supports() {
		return LowLevelAppDescriptor.class;
	}

	/**
	 * Create a new Netty based Test Container instance.
	 * 
	 * @see com.sun.jersey.test.framework.spi.container.TestContainerFactory#create(java.net.URI,
	 *      com.sun.jersey.test.framework.AppDescriptor)
	 */
	public TestContainer create(final URI baseUri,
			final AppDescriptor appDescriptor) throws IllegalArgumentException {
		LOGGER.debug("Base uri for testing is: {}", baseUri);
		if (!(appDescriptor instanceof LowLevelAppDescriptor)) {
			throw new IllegalArgumentException(
					"The application descriptor must be an instance of LowLevelAppDescriptor");
		}

		return new NettyTestContainer(baseUri,
				(LowLevelAppDescriptor) appDescriptor);
	}

}
