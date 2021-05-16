package com.laptrinhweb.DAO.implement;

import java.util.List;

import com.laptrinhweb.DAO.IGenericDAO;
import com.laptrinhweb.DAO.IUserDAO;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.mapper.NewMapper;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.UserModel;

public class UserDAO extends abstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r on r.id = u.roleid");
		sql.append(" WHERE userName = ? AND password=? AND status=?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}
//	@Override
//	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
//		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
//		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
//		sql.append(" WHERE username = ? AND password = ? AND status = ?");
//		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
//		return users.isEmpty() ? null : users.get(0);
//	}
}
