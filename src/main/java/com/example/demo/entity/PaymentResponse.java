package com.example.demo.entity;

public class PaymentResponse {
	private String message;
    private boolean success;
    private String transactionId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public PaymentResponse(String message, boolean success, String transactionId) {
		super();
		this.message = message;
		this.success = success;
		this.transactionId = transactionId;
	}
	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
