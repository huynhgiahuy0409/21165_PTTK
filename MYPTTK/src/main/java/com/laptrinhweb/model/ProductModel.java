package com.laptrinhweb.model;

import java.util.Map;

public class ProductModel extends abstractModel<NewModel>{
	private String produceName;
	private String SKU;
	private String shortDescription;
	private String thumnail;
	private Long supplierId;
	private String supplierCode;
	private Long cagoryID;
	private String suppilerCode;
	private Float unitPrice;
	private Float comparePrice;
	private Float importPrice;
	private Long unitsInStock;
	private Long unitsInOrder;
	private Integer discount;
	private Map<SizeModel, Integer> listSize;
}
