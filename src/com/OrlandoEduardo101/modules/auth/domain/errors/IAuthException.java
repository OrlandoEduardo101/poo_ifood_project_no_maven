package com.OrlandoEduardo101.modules.auth.domain.errors;

public abstract class IAuthException extends Exception {
    public IAuthException(String errorMessage) {
        super(errorMessage);
    }
}

