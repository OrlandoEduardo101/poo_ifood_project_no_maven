package com.OrlandoEduardo101.modules.auth.infra.datasources;
import com.OrlandoEduardo101.modules.auth.domain.errors.LoginUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.errors.RegisterUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.models.AuthParam;
import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;

public interface IAuthDatasource {
    UserModel registerUser(UserModel userModel) throws RegisterUserFailure;
    UserModel loginUser(AuthParam authParam) throws LoginUserFailure;
}
