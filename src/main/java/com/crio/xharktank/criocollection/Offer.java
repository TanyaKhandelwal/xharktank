package com.crio.xharktank.criocollection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "offer")
public class Offer {
	
	@Transient
	public static final String SEQUENCE_NAME = "offer_sequence";
	@Id 
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@NotNull @NotEmpty
	private String investor;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private float amount;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private float equity;
	@NotNull @NotEmpty
	private String comment;
	
	@JsonIgnore
	private String pitch;
	
	public Offer() {}
	
	public Offer(String investor, float amount, float equity, String comment,String pitch) {
		this.investor = investor;
		this.amount = amount;
		this.equity = equity;
		this.comment = comment;
		this.pitch = pitch;
	}
	
	
	public String getInvestor() {
		return investor;
	}
	public void setInvestor(String investor) {
		this.investor = investor;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getEquity() {
		return equity;
	}
	public void setEquity(float equity) {
		this.equity = equity;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPitch() {
		return pitch;
	}

	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	
}
