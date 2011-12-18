/**
 * 
 */
package com.devsprint.jersey.api.netty.container.test;

import java.net.URI;

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
		if (!(appDescriptor instanceof LowLevelAppDescriptor)) {
			throw new IllegalArgumentException(
					"The application descriptor must be an instance of LowLevelAppDescriptor");
		}

		return new NettyTestContainer(baseUri,
				(LowLevelAppDescriptor) appDescriptor);
	}

}
