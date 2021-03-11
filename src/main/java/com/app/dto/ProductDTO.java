package com.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.app.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String title;
	private Double price;
	private String zipcode;
	private String seller;
	private String thumbnailHd;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	public ProductDTO() {
	}
	
	public ProductDTO(Product obj) {
		title = obj.getTitle();
		price = obj.getPrice();
		zipcode = obj.getZipcode();
		seller = obj.getSeller();
		thumbnailHd = obj.getThumbnailHd();
		date = obj.getDate();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getThumbnailHd() {
		return thumbnailHd;
	}

	public void setThumbnailHd(String thumbnailHd) {
		this.thumbnailHd = thumbnailHd;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
