package com.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.app.models.Transation;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TransationDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String clientId;
	private String puncharseId;
	private Integer value;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	private String cardNumber;
	
	public TransationDTO() {
	}

	public TransationDTO(Transation obj) {
		this.clientId = obj.getClientId();
		this.puncharseId = obj.getId();
		this.value = obj.getTotalToPay();
		this.date = obj.getDate();
		this.cardNumber = obj.getCreditCard().getCardNumber();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPuncharseId() {
		return puncharseId;
	}

	public void setPuncharseId(String puncharseId) {
		this.puncharseId = puncharseId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
