/**
 * 
 */
package com.devsprint.jersey.api.netty.container.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Probe for testing container initialization
 * 
 * @author gciuloaica
 * 
 */
@Path("/probes")
public class ProbeResource {

	@GET
	@Produces("text/plain")
	public String getSomeText() {
		return "Test";
	}

}
