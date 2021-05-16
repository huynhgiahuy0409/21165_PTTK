package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.paging.Pageble;
import com.opensymphony.module.sitemesh.Page;

public interface INewDAO extends IGenericDAO<NewModel> {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
