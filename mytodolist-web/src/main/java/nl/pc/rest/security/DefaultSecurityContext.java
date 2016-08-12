package nl.pc.rest.security;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;


public class DefaultSecurityContext implements SecurityContext {

    private OnlineUser onlineUser;
    private String scheme;

    public DefaultSecurityContext(OnlineUser onlineUser, String scheme) {
        this.onlineUser = onlineUser;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {
        return onlineUser;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}
