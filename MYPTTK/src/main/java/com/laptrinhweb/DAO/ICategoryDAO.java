package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
	List<CategoryModel> findAll();

	CategoryModel findOne(long id);

	CategoryModel findOneByCode(String code);
}
