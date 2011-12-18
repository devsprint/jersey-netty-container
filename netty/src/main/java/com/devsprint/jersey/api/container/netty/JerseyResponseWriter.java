package com.devsprint.jersey.api.container.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;

import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseWriter;

/**
 * Write the response to the channel.
 * 
 * @author gciuloaica
 * 
 */
public class JerseyResponseWriter implements ContainerResponseWriter {

	private final transient Channel channel;
	private transient HttpResponse response;

	public JerseyResponseWriter(final Channel channel) {
		this.channel = channel;
	}

	public OutputStream writeStatusAndHeaders(final long contentLength,
			final ContainerResponse containerResponse) throws IOException {
		response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,
				HttpResponseStatus.valueOf(containerResponse.getStatus()));
		final List<String> values = new ArrayList<String>();
		for (Map.Entry<String, List<Object>> header : containerResponse
				.getHttpHeaders().entrySet()) {

			for (Object value : header.getValue()) {
				values.add(ContainerResponse.getHeaderValue(value));
			}
			response.setHeader(header.getKey(), values);
			values.clear();
		}

		final ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
		response.setContent(buffer);
		return new ChannelBufferOutputStream(buffer);

	}

	public void finish() throws IOException {
		channel.write(response).addListener(ChannelFutureListener.CLOSE);
	}

}
