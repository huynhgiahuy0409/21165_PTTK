package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
//		private Long id;
//		private Timestamp createdDate;
//		private Timestamp modifiedDate;
//		private String createdBy;
//		private String modifiedBy;
//		private String title;
//		private String thumbnail;
//		private String shortDescription;
//		private String content;
//		private Long categoryId;

		try {
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreatedDate(rs.getTimestamp("createddate"));
			news.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate")!=null) {
				news.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				news.setModifiedBy(rs.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
}
