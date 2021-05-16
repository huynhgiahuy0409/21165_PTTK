package com.laptrinhweb.DAO.implement;

import java.util.List;

import com.laptrinhweb.DAO.ICategoryDAO;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.mapper.NewMapper;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewModel;

public class CategoryDAO extends abstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categorys = query(sql, new CategoryMapper(), id);
		return categorys.isEmpty() ? null : categorys.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> categorys = query(sql, new CategoryMapper(), code);
		return categorys.isEmpty() ? null : categorys.get(0);
	}




}
