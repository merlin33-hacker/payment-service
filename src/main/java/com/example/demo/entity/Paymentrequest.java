package com.example.demo.entity;

public class Paymentrequest {

	private Long orderId;
    private Double amount;
    private String paymentMethod;
	public Paymentrequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paymentrequest(Long orderId, Double amount, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod() {
		this.paymentMethod = paymentMethod;
	}
    
}
