package com.crio.xharktank.criocollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonInclude;



@Document(collection = "pitch")
public class Pitch {
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id 
	private String id;
	@NotNull @NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String entrepreneur;
	@NotNull @NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String pitchTitle;
	@NotNull @NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String pitchIdea;
	@NotNull 
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private float askAmount;
	@NotNull @Max(value=100) @Min(value=0)
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private float equity;
//    private Date updatedOn;
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonIgnore
    private Date createdOn = new Date();
	
//	@DBRef(db="offer")
	private List<?> offers = new ArrayList<>();
    public Pitch() {
	}
	
	public Pitch(String entrepreneur, String pitchTitle, String pitchIdea, float askAmount, float equity) {
		this.entrepreneur = entrepreneur;
		this.pitchTitle = pitchTitle;
		this.pitchIdea = pitchIdea;
		this.askAmount = askAmount;
		this.equity = equity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	public String getEntrepreneur() {
		return entrepreneur;
	}
	public void setEntrepreneur(String entrepreneur) {
		this.entrepreneur = entrepreneur;
	}
	public String getPitchTitle() {
		return pitchTitle;
	}
	public void setPitchTitle(String pitchTitle) {
		this.pitchTitle = pitchTitle;
	}
	public String getPitchIdea() {
		return pitchIdea;
	}
	public void setPitchIdea(String pitchIdea) {
		this.pitchIdea = pitchIdea;
	}
	public float getAskAmount() {
		return askAmount;
	}
	public void setAskAmount(float askAmount) {
		this.askAmount = askAmount;
	}
	public float getEquity() {
		return equity;
	}
	public void setEquity(float equity) {
		this.equity = equity;
	}
	
	public Date getCreatedOn() {
        return createdOn;
    }
 
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

	public List<?> getOffers() {
		return offers;
	}

	public void setOffers(List<?> offers) {
		this.offers = offers;
	}

    
  

	
}
