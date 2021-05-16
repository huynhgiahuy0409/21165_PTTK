package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.paging.Pageble;

public interface INewsService {
	List<NewModel> findByCategoryID(Long categoryID);

	List<NewModel> findAll(Pageble pageble);

	int getTotalITem();

	NewModel save(NewModel news);

	void delete(long[] ids);

	NewModel update(NewModel updateNew);

	NewModel findOne(Long id);
}
