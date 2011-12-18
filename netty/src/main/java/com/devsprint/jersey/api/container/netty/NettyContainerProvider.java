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
class NettyContainerProvider implements ContainerProvider<JerseyHandler> {

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
