package com.shop.entity;

import java.util.Date;

public class Account {

	private Integer accountId;
	private String  accountTitle;
	private String  accountImage;
	private Date accountTime;
	private Double accountPrice;
	private Integer accountNum;
	private Integer accountContentId;
	
	public Integer getAccountContentId() {
		return accountContentId;
	}
	public void setAccountContentId(Integer accountContentId) {
		this.accountContentId = accountContentId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountTitle() {
		return accountTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public String getAccountImage() {
		return accountImage;
	}
	public void setAccountImage(String accountImage) {
		this.accountImage = accountImage;
	}
	public Date getAccountTime() {
		return accountTime;
	}
	public void setAccountTime(Date accountTime) {
		this.accountTime = accountTime;
	}
	public Double getAccountPrice() {
		return accountPrice;
	}
	public void setAccountPrice(Double accountPrice) {
		this.accountPrice = accountPrice;
	}
	public Integer getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountTitle=" + accountTitle + ", accountImage=" + accountImage
				+ ", accountTime=" + accountTime + ", accountPrice=" + accountPrice + ", accountNum=" + accountNum
				+ ", accountContentId=" + accountContentId + "]";
	}
	
	
}
