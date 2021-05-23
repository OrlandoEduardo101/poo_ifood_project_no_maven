package com.OrlandoEduardo101.modules.auth.domain.repository;
import com.OrlandoEduardo101.modules.auth.domain.errors.IAuthException;
import com.OrlandoEduardo101.modules.auth.domain.errors.LoginUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.errors.RegisterUserFailure;
import com.OrlandoEduardo101.modules.auth.domain.models.AuthParam;
import com.OrlandoEduardo101.modules.auth.domain.models.UserModel;

public interface IAuthRepository {
    UserModel registerUser(UserModel userModel) throws RegisterUserFailure, IAuthException;
    UserModel loginUser(AuthParam authParam) throws LoginUserFailure, IAuthException;
}
