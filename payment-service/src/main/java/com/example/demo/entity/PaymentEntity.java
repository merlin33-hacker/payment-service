package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paymentservice")
public class PaymentEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private long orderid;
private Double amount;
private String paymentMethod;
private boolean success;
private String transactionId;
private LocalDateTime paitAt=LocalDateTime.now();
public PaymentEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public PaymentEntity(long id, long orderid, Double amount, String paymentMethod, boolean success, String transactionId,
		LocalDateTime paitAt) {
	super();
	this.id = id;
	this.orderid = orderid;
	this.amount = amount;
	this.paymentMethod = paymentMethod;
	this.success = success;
	this.transactionId = transactionId;
	this.paitAt = paitAt;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getOrderid() {
	return orderid;
}
public void setOrderid(long orderid) {
	this.orderid = orderid;
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
public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
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
public LocalDateTime getPaitAt() {
	return paitAt;
}
public void setPaitAt(LocalDateTime paitAt) {
	this.paitAt = paitAt;
}

}