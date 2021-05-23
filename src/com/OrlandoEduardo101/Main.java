package com.OrlandoEduardo101;
import com.OrlandoEduardo101.di.StartModule;
import com.OrlandoEduardo101.modules.auth.presenter.Auth;
import com.OrlandoEduardo101.modules.home.domain.errors.IHomeException;

public class Main {

    public static void main(String[] args) throws IHomeException {
        StartModule startModule = StartModule.getInstance();
        startModule.initInjection();

        Auth auth = new Auth();
        auth.loginOrResgister();

    }
}
