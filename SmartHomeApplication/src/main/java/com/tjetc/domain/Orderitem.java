package com.tjetc.domain;

public class Orderitem {
    private Integer id;

    private Integer count;

    private Double subtotal;

    private Integer productId;

    private String orderId;

    private Product product;
    
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", count=" + count + ", subtotal=" + subtotal + ", productId=" + productId
				+ ", orderId=" + orderId + ", product=" + product + "]";
	}
    
}