package com.OrlandoEduardo101.modules.auth.infra.repositories;
import com.OrlandoEduardo101.modules.auth.domain.errors.IAuthException;
import com.OrlandoEduardo101.modules.auth.domain.errors.LoginUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.errors.RegisterUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.models.AuthParam;
import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;
import com.OrlandoEduardo101.modules.auth.domain.repository.IAuthRepository;
import com.OrlandoEduardo101.modules.auth.infra.datasources.IAuthDatasource;

public class AuthRepository implements IAuthRepository {
    private IAuthDatasource _datasource;
    private static IAuthRepository instance;

    private AuthRepository(IAuthDatasource datasource) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this._datasource = datasource;
    }

    public static AuthRepository getInstance(IAuthDatasource datasource) {
        if (instance == null) {
            instance = new AuthRepository(datasource);
        }
        return (AuthRepository) instance;
    }

    @Override
    public UserModel registerUser(UserModel userModel) throws IAuthException {
        try{
            return _datasource.registerUser(userModel);
        } catch (Exception e) {
            throw new RegisterUserFailure(e.getMessage());
        }
    }

    @Override
    public UserModel loginUser(AuthParam authParam) throws IAuthException {
        try{
            return _datasource.loginUser(authParam);
        } catch (Exception e) {
            throw new LoginUserFailure(e.getMessage());
        }
    }
}
