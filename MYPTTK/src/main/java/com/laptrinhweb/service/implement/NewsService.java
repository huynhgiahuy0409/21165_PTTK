package com.laptrinhweb.service.implement;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.ICategoryDAO;
import com.laptrinhweb.DAO.INewDAO;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewDAO newDAO;
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findByCategoryID(Long categoryID) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryID);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalITem() {
		// TODO Auto-generated method stub
		return newDAO.getTotalItem();
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id : ids) {
			// 1.delete comment (khoa ngoai new_id)
			// 2.delete news
			newDAO.delete(id);
		}
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public NewModel findOne(Long id) {
		// TODO Auto-generated method stub
		NewModel newModel = newDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
}
