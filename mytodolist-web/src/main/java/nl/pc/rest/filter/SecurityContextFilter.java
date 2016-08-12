package nl.pc.rest.filter;

import nl.pc.rest.security.DefaultSecurityContext;
import nl.pc.rest.security.OnlineUser;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
@PreMatching
public class SecurityContextFilter implements ContainerRequestFilter {

    //   https://simplapi.wordpress.com/2015/09/19/jersey-jax-rs-securitycontext-in-action/ for elaborated example
    private static final String HEADER_USERNAME = "UserName";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String userName = requestContext.getHeaderString(HEADER_USERNAME);
        OnlineUser user = new OnlineUser(userName);
        String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
        requestContext.setSecurityContext(new DefaultSecurityContext(user, scheme));
    }
}
