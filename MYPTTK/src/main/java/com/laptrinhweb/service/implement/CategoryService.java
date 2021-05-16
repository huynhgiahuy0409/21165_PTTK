package com.laptrinhweb.service.implement;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.ICategoryDAO;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDAO categoryDAO;

//	public CategoryService() {
//		super();
//		this.categoryDAO = new CategoryDAO();
//	}

	
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return this.categoryDAO.findAll();
	}

	@Override
	public CategoryModel findOne(Long id) {
		// TODO Auto-generated method stub
		return this.categoryDAO.findOne(id);
	}
}
