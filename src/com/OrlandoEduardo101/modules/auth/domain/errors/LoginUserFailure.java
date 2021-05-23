package com.OrlandoEduardo101.modules.auth.domain.errors;

public class LoginUserFailure extends IAuthException {
    public LoginUserFailure(String errorMessage) {
        super(errorMessage);
    }
}