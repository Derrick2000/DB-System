package com.cy.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class JsonResult implements Serializable{
	
	private static final long serialVersionUID = -8389587237488952536L;
	private int state = 1;//1 means success
	private String message="ok";
	private Object data;
	
	
	
	public JsonResult() {
		super();
	}
	public JsonResult(Object data) {
		super();
		this.data = data;
	}
	public JsonResult(String message) {
		super();
		this.message = message;
	}
	public JsonResult(int state) {
		super();
		this.state = state;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
