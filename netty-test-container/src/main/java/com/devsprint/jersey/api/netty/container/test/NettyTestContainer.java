/**
 * 
 */
package com.devsprint.jersey.api.netty.container.test;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devsprint.jersey.api.container.netty.NettyServer;
import com.devsprint.jersey.api.container.netty.NettyServerFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;

/**
 * Test container implementation based on Netty.
 * 
 * @author gciuloaica
 * 
 */
public class NettyTestContainer implements TestContainer {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(NettyTestContainer.class.getName());

	private final URI baseUri;

	private final NettyServer nettyServer;

	/**
	 * Create a new Netty based test container instance.
	 * 
	 * @param baseUri
	 *            - base URI
	 * @param appDescriptor
	 *            - application descriptor
	 */
	public NettyTestContainer(final URI baseUri,
			final LowLevelAppDescriptor appDescriptor) {
		this.baseUri = baseUri;
		LOGGER.info("Creating low level http container configured at the base URI "
				+ this.baseUri);
		final ResourceConfig resourceConfig = appDescriptor.getResourceConfig();
		nettyServer = NettyServerFactory.create(resourceConfig, this.baseUri);
	}

	/**
	 * @see com.sun.jersey.test.framework.spi.container.TestContainer#getClient()
	 */
	public Client getClient() {
		return null;
	}

	/**
	 * @see com.sun.jersey.test.framework.spi.container.TestContainer#getBaseUri()
	 */
	public URI getBaseUri() {
		return this.baseUri;
	}

	/**
	 * @see com.sun.jersey.test.framework.spi.container.TestContainer#start()
	 */
	public void start() {
		nettyServer.startServer();

	}

	/**
	 * @see com.sun.jersey.test.framework.spi.container.TestContainer#stop()
	 */
	public void stop() {
		nettyServer.stopServer();

	}

}
