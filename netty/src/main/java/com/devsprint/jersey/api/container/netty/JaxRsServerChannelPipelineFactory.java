package com.devsprint.jersey.api.container.netty;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import static org.jboss.netty.channel.Channels.pipeline;

/**
 * Build server pipeline factory.
 * 
 * @author gciuloaica
 * 
 */
public class JaxRsServerChannelPipelineFactory implements
		ChannelPipelineFactory {

	private final transient JerseyHandler jerseyHandler;

	public JaxRsServerChannelPipelineFactory(final JerseyHandler jerseyHandler) {
		this.jerseyHandler = jerseyHandler;
	}

	/**
	 * Retrieve the channel pipeline factory.
	 * 
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	public ChannelPipeline getPipeline() {
		final ChannelPipeline pipeline = pipeline();
		pipeline.addLast("decoder", new HttpRequestDecoder());
		pipeline.addLast("encoder", new HttpResponseEncoder());
		pipeline.addLast("jerseyHandler", jerseyHandler);
		return pipeline;
	}

}
