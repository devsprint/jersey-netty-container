package com.devsprint.jersey.api.netty.container.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.devsprint.jersey.api.netty.container.test.NettyTestContainerFactory;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;

public class JerseyNettyContainerTest extends JerseyTest {

	private static ClientConfig clientConfig;

	static {
		clientConfig = new DefaultClientConfig(ProbeResource.class);

	}

	public JerseyNettyContainerTest() {
		super(new NettyTestContainerFactory());
	}

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder(
				"com.devsprint.jersey.api.netty.container.test")
				.clientConfig(clientConfig).build();
	}

	@Test
	public void testProperContainerLoader() throws Exception {
		TestContainerFactory factory = getTestContainerFactory();
		assertTrue(factory instanceof NettyTestContainerFactory);
	}

}
