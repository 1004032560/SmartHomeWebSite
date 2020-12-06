package com.tjetc.domain;

import java.util.List;

public class Category {
    private Integer id;

    private String name;
    
    private List<Secondcategory> secondCategories;

	public List<Secondcategory> getSecondCategories() {
		return secondCategories;
	}

	public void setSecondCategories(List<Secondcategory> secondCategories) {
		this.secondCategories = secondCategories;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}