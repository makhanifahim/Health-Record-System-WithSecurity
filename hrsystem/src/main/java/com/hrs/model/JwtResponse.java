package com.hrs.model;

public class JwtResponse {
    private Credential credential;
    private String jwtToken;

    public JwtResponse(Credential credential, String jwtToken) {
        this.credential = credential;
        this.jwtToken = jwtToken;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
