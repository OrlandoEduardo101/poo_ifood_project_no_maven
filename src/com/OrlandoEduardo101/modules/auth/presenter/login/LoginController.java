package com.OrlandoEduardo101.modules.auth.presenter.login;

import com.OrlandoEduardo101.AuthStore.AuthStore;
import com.OrlandoEduardo101.modules.auth.domain.errors.IAuthException;
import com.OrlandoEduardo101.modules.auth.domain.models.AuthParam;
import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;
import com.OrlandoEduardo101.modules.auth.domain.usecases.LoginUserUsecase;

public class LoginController {
    AuthParam authParam = new AuthParam();
    UserModel userModel;
    private LoginUserUsecase _loginUserUsecase;
    private AuthStore _authStore;

    public LoginController(LoginUserUsecase loginUserUsecase, AuthStore authStore){
        this._loginUserUsecase = loginUserUsecase;
        this._authStore = authStore;
    }

    public void setEmail(String email){
        authParam.setEmail(email);
    }

    public void setPassword(String password) throws IAuthException {
        authParam.setPassword(password);
        userModel = _loginUserUsecase.loginUser(authParam);
        _authStore.setLoggedUser(userModel);
    }
}
