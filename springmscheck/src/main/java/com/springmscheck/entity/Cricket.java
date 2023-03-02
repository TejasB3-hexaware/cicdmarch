package com.springmscheck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Cricket")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Cricket {

	@Id
	private Long id;
    private String bat;
    private String ball;

    public Cricket(){}

	public Cricket(Long id, 
        String bat, 
        String ball
    ){
    this.id = id;
	this.bat = bat;
	this.ball = ball;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public void setBat(String bat){
        this.bat = bat;
    }

    public String getBat(){
        return this.bat;
    }
    public void setBall(String ball){
        this.ball = ball;
    }

    public String getBall(){
        return this.ball;
    }

    public String toString(){
        return "[id = " + this.id +
                "bat = " + this.bat +
                "ball = " + this.ball +
            "]";
    }

}
