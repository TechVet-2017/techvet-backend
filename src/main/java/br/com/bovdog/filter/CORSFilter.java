package br.com.bovdog.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

// class that allows communication between api rest and front-end servers.
@Provider
public class CORSFilter implements ContainerResponseFilter {

<<<<<<< HEAD
	// provides proper permissions for inter-server communications.
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE");
    }

}
=======
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE");
	}
}
>>>>>>> development
