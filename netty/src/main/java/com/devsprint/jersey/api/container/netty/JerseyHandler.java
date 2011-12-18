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
import java.net.URI;
import java.net.URISyntaxException;

import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.WebApplication;

/**
 * Handle a client request.
 * 
 * @author gciuloaica
 * 
 */
class JerseyHandler extends SimpleChannelUpstreamHandler {

	private final transient WebApplication application;
	private final transient String baseUri;

	public JerseyHandler(final WebApplication application,
			final ResourceConfig resourceConfig) {
		super();
		this.application = application;
		this.baseUri = (String) resourceConfig
				.getProperty(NettyServer.PROPERTY_BASE_URI);
	}

	@Override
	public void messageReceived(final ChannelHandlerContext context,
			final MessageEvent messageEvent) throws URISyntaxException,
			IOException {
		final HttpRequest request = (HttpRequest) messageEvent.getMessage();

		final String base = getBaseUri(request);
		final URI baseUri = new URI(base);
		final URI requestUri = new URI(base.substring(0, base.length() - 1)
				+ request.getUri());

		final ContainerRequest cRequest = new ContainerRequest(application,
				request.getMethod().getName(), baseUri, requestUri,
				getHeaders(request), new ChannelBufferInputStream(
						request.getContent()));

		application.handleRequest(cRequest, new JerseyResponseWriter(
				messageEvent.getChannel()));
	}

	private InBoundHeaders getHeaders(final HttpRequest request) {
		final InBoundHeaders headers = new InBoundHeaders();

		for (String name : request.getHeaderNames()) {
			headers.put(name, request.getHeaders(name));
		}

		return headers;
	}

	private String getBaseUri(final HttpRequest request) {
		String baseUri = this.baseUri;
		if (baseUri != null) {
			baseUri = "http://" + request.getHeader(HttpHeaders.Names.HOST)
					+ "/";
		}
		return baseUri;

	}

}
