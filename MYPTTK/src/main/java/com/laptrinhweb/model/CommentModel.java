package com.laptrinhweb.model;

import java.sql.Timestamp;

public class CommentModel extends abstractModel<CommentModel> {

	private String content;
	private Long newsID;
	private Long userID;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getNewsID() {
		return newsID;
	}

	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

}
