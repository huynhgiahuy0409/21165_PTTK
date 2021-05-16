package com.laptrinhweb.paging;

import com.laptrinhweb.controller.sort.Sorter;

public interface Pageble {
	Integer getOffset();
	Integer getLimit();
	Integer getPage();
	Sorter getSorter();
}
