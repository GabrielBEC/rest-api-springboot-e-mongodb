package com.app.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private Double price;
	private String zipcode;
	private String seller;
	private String thumbnailHd;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	public Product() {
	}

	public Product(String id, String title, Double price, String zipcode, String seller, String thumbnailHd,
			LocalDate date) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.zipcode = zipcode;
		this.seller = seller;
		this.thumbnailHd = thumbnailHd;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
