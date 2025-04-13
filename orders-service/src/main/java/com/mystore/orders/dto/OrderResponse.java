package com.mystore.orders.dto;

public class OrderResponse {

    private Long orderId;
    private Integer productId;
    private Integer qty;
    private String productName;
    private Double totalPrice;

    public OrderResponse(Long orderId, Integer productId, Integer qty, String productName, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.qty = qty;
		this.productName = productName;
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}