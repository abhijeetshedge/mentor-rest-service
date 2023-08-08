package com.mentor.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Category")
public class Category {
	
	private int categoryId;
	private String category;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
