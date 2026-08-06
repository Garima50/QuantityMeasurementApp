package com.apps.operationservice.client;

public class TokenValidationResponse {

    private boolean valid;
    private String email;

    public TokenValidationResponse() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
