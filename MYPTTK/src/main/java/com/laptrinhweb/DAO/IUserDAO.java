package com.laptrinhweb.DAO;

import com.laptrinhweb.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
