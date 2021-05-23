package com.OrlandoEduardo101.modules.auth.domain.usecases;

import com.OrlandoEduardo101.modules.auth.domain.errors.IAuthException;
import com.OrlandoEduardo101.modules.auth.domain.errors.LoginUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.models.AuthParam;
import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;
import com.OrlandoEduardo101.modules.auth.domain.repository.IAuthRepository;

interface ILoginUserUsecase {
    UserModel loginUser(AuthParam authParam) throws IAuthException;
}

public class LoginUserUsecase implements ILoginUserUsecase {
    private IAuthRepository _repository;
    private static LoginUserUsecase instance;

    private LoginUserUsecase(IAuthRepository repository) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._repository = repository;
    }

    public static LoginUserUsecase getInstance(IAuthRepository repository) {
        if (instance == null) {
            instance = new LoginUserUsecase(repository);
        }
        return instance;
    }

   /* public LoginUserUsecase(IAuthRepository repository){
        this._repository = repository;
    }*/

    @Override
    public UserModel loginUser(AuthParam authParam) throws IAuthException {
        try {
            return _repository.loginUser(authParam);
        } catch (Exception e) {
            throw new LoginUserFailure(e.getMessage());
        }
    }
}
