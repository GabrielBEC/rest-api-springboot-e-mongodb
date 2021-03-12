package com.app.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "transation")
public class Transation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String clientId;
	private String clientName;
	private Integer totalToPay;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date = LocalDate.now();
	
	private CreditCard creditCard;

	public Transation() {
	}

	public Transation(String id, String clientId, String clientName, Integer totalToPay, LocalDate date,
			CreditCard creditCard) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientName = clientName;
		this.totalToPay = totalToPay;
		this.date = date;
		this.creditCard = creditCard;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Integer getTotalToPay() {
		return totalToPay;
	}

	public void setTotalToPay(Integer totalToPay) {
		this.totalToPay = totalToPay;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	

}
