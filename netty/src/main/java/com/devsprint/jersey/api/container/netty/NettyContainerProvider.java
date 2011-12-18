/**
 * 
 */
package com.devsprint.jersey.api.container.netty;

import com.sun.jersey.api.container.ContainerException;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.ContainerProvider;
import com.sun.jersey.spi.container.WebApplication;

/**
 * Service provider, such that Jersey could load it.
 * 
 * @author gciuloaica
 * 
 */
public class NettyContainerProvider implements ContainerProvider<JerseyHandler> {

	public JerseyHandler createContainer(final Class<JerseyHandler> type,
			final ResourceConfig resourceConfig,
			final WebApplication application) throws ContainerException {
		JerseyHandler handler = null;
		if (type == JerseyHandler.class) {
			handler = new JerseyHandler(application, resourceConfig);
		}

		return handler;
	}

}
