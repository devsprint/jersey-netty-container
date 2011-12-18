/**
 * 
 */
package com.devsprint.jersey.api.container.netty;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.jboss.netty.channel.ChannelPipelineFactory;

import com.sun.jersey.api.container.ContainerFactory;
import com.sun.jersey.api.core.ResourceConfig;

/**
 * Create NettyServer instances.
 * 
 * @author gciuloaica
 * 
 */
public final class NettyServerFactory {
	
	private NettyServerFactory(){
		
	}

	public static NettyServer create(final ResourceConfig resourceConfig,final URI baseUri) {
		final JerseyHandler jerseyHandler = ContainerFactory.createContainer(
				JerseyHandler.class, resourceConfig);

		return new NettyServer(getPipelineFactory(jerseyHandler),
				getLocalSocket(baseUri));
	}

	private static SocketAddress getLocalSocket(final URI baseUri) {
		return new InetSocketAddress(baseUri.getHost(), baseUri.getPort());
	}

	private static ChannelPipelineFactory getPipelineFactory(
			final JerseyHandler jerseyHandler) {
		return new JaxRsServerChannelPipelineFactory(jerseyHandler);

	}

}
