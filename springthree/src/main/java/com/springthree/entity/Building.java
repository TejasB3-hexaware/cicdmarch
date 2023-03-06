package com.springthree.entity;

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
@Table(name = "building")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Building {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String name;
    
    private int floor;
    
    private boolean sold;

    public Building(){}

	public Building(Long id, 
        String name, 
        int floor, 
        boolean sold
    ){
    this.id = id;
	this.name = name;
	this.floor = floor;
	this.sold = sold;
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
    public void setFloor(int floor){
        this.floor = floor;
    }

    public int getFloor(){
        return this.floor;
    }
    public void setSold(boolean sold){
        this.sold = sold;
    }

    public boolean getSold(){
        return this.sold;
    }

    public String toString(){
        return "[id = " + this.id +
                "name = " + this.name +
                "floor = " + this.floor +
                "sold = " + this.sold +
            "]";
    }

}
