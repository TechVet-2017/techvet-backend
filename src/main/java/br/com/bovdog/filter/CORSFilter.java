package br.com.bovdog.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

// class that allows communication between api rest and front-end servers.
@Provider
public class CORSFilter implements ContainerResponseFilter {

	// provides proper permissions for inter-server communications.
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add("X-Total-Count", "100");
        response.getHeaders().add("Access-Control-Expose-Headers", "X-Total-Count");
    }

}
