package com.OrlandoEduardo101.modules.home.domain.errors;

public abstract class IHomeException extends Exception {
    public IHomeException(String errorMessage) {
        super(errorMessage);
    }
}

