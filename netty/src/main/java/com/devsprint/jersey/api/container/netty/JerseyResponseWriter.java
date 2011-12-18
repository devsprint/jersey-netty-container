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
class JerseyResponseWriter implements ContainerResponseWriter {

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
