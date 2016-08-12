package nl.pc.rest.security;

import java.security.Principal;

public class OnlineUser implements Principal {

    private final String userName;


    public OnlineUser(String userName) {
        this.userName = userName;
    }

    @Override
    public String getName() {
        return this.userName;
    }

}