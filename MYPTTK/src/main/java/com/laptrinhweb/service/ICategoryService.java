package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
}
