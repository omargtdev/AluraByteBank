package com.omargtdev.alurabytebank.security;

public class InternalSystem {

    private final static String GENERIC_PASSWORD = "holi123";

    public boolean authenticate(Authentication authentication) {
        boolean wasAuthenticated = authentication.signIn(GENERIC_PASSWORD);

        if (wasAuthenticated)
            System.out.println("Successful authentication.");
        else
            System.out.println("Failed authentication.");

        return wasAuthenticated;
    }

}
