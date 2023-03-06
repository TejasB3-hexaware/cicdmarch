package com.springmsholi.entity;

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
@Table(name = "Holi")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Holi {

	@Id
	private Long id;
    private String name;
    private int color;

    public Holi(){}

	public Holi(Long id, 
        String name, 
        int color
    ){
    this.id = id;
	this.name = name;
	this.color = color;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return this.color;
    }

    public String toString(){
        return "[id = " + this.id +
                "name = " + this.name +
                "color = " + this.color +
            "]";
    }

}
