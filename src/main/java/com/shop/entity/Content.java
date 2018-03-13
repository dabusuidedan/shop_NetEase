package com.shop.entity;

public class Content {
 
private Integer contentId;
private String contentTitle;
private String contentImage;
private Double contentPrice;
private String contentAbstract;
private String contentBody;
private Integer contentFlag;
public Integer getContentFlag() {
	return contentFlag;
}
public void setContentFlag(Integer contentFlag) {
	this.contentFlag = contentFlag;
}
public Integer getContentId() {
	return contentId;
}
public void setContentId(Integer contentId) {
	this.contentId = contentId;
}
public String getContentTitle() {
	return contentTitle;
}
public void setContentTitle(String contentTitle) {
	this.contentTitle = contentTitle;
}
public String getContentImage() {
	return contentImage;
}
public void setContentImage(String contentImage) {
	this.contentImage = contentImage;
}
public Double getContentPrice() {
	return contentPrice;
}
public void setContentPrice(Double contentPrice) {
	this.contentPrice = contentPrice;
}
public String getContentAbstract() {
	return contentAbstract;
}
public void setContentAbstract(String contentAbstract) {
	this.contentAbstract = contentAbstract;
}
public String getContentBody() {
	return contentBody;
}
public void setContentBody(String contentBody) {
	this.contentBody = contentBody;
}
@Override
public String toString() {
	return "Content [contentId=" + contentId + ", contentTitle=" + contentTitle + ", contentImage=" + contentImage
			+ ", contentPrice=" + contentPrice + ", contentAbstract=" + contentAbstract + ", contentBody=" + contentBody
			+ ", contentFlag=" + contentFlag + "]";
}


	
}
