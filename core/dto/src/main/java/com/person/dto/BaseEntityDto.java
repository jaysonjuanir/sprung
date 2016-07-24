package com.person.dto;

import java.io.Serializable;
public abstract class BaseEntityDto implements Serializable{
    
	protected int id;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
