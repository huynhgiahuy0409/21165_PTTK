package com.laptrinhweb.service.implement;

import javax.inject.Inject;

import com.laptrinhweb.DAO.IUserDAO;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		// TODO Auto-generated method stub
		return this.userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
