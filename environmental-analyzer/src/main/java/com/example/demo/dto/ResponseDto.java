package com.example.demo.dto;

public class ResponseDto {

    //DTO para la respuesta de los servicios, para saber como es el comportamiento de la respuesta
    private String message;
    private Object data;
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
	public ResponseDto(String message, Object data) {
		this.message = message;
		this.data = data;
	}
    
    
}
