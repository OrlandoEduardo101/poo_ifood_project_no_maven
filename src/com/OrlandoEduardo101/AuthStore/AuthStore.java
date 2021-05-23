package com.OrlandoEduardo101.AuthStore;

import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;

public class AuthStore {

    private static AuthStore instance;

    private AuthStore() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static AuthStore getInstance(){
        if (instance == null) {
            instance = new AuthStore();
        }
        return (AuthStore) instance;
    }


    public UserModel getLoggedUser() {
        return _userLogged;
    }

    public void setLoggedUser(UserModel userModel) {
        this._userLogged = userModel;
    }

    private UserModel _userLogged = new UserModel();
}
