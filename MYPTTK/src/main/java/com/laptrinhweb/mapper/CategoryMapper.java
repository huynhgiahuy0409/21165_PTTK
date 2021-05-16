package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		CategoryModel cm = new CategoryModel();
		try {
			cm.setId(rs.getLong("id"));
			cm.setName(rs.getString("name"));
			cm.setCode(rs.getString("code"));
			return cm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
