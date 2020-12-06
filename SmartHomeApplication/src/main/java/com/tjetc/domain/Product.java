package com.tjetc.domain;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private Integer isHot;

    private Integer scid;

    private Long marketPrice;

    private Long shopPrice;

    private String description;

    private String image;

    private Date time;
    
    private Secondcategory secondcategory;

    public Secondcategory getSecondcategory() {
		return secondcategory;
	}

	public void setSecondcategory(Secondcategory secondcategory) {
		this.secondcategory = secondcategory;
	}

	public Product(Integer id, String name, Integer isHot, Integer scid, Long marketPrice, Long shopPrice,
			String description, String image, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.isHot = isHot;
		this.scid = scid;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.description = description;
		this.image = image;
		this.time = time;
	}

	public Product(String name, Integer isHot, Integer scid, Long marketPrice, Long shopPrice,
			String description, String image, Date time) {
		super();
		this.name = name;
		this.isHot = isHot;
		this.scid = scid;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.description = description;
		this.image = image;
		this.time = time;
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

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Long shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}