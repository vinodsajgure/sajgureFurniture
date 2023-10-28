package com.sajgure.furniture.dto;

import com.sajgure.furniture.constant.Status;

public class CarouselDto {
	private int id;
	private String image;
	private String text;
	private String fileName;
	private String type;
	private Status status;

	public CarouselDto(int id, String image, String text, String fileName, String type, Status status) {
		super();
		this.id = id;
		this.image = image;
		this.text = text;
		this.fileName = fileName;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
