package com.laptrinhweb.paging;

import com.laptrinhweb.controller.sort.Sorter;

public class PageRequest implements Pageble {
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;

	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		// TODO Auto-generated constructor stub
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
//		(model.getPage() - 1) * model.getMaxPageItem();
		if (this.page != null && this.maxPageItem != null) {
			return (this.page - 1) * this.maxPageItem;
		} else {
			return null;
		}
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Sorter getSorter() {
		// TODO Auto-generated method stub
		return this.sorter;
	}

}
