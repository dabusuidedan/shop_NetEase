package com.shop.entity;

public class User {
	 private Integer userId;
	    private String userName;
	    private String userPassword;
	    private Integer userFlag;
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public Integer getUserFlag() {
			return userFlag;
		}
		public void setUserFlag(Integer userFlag) {
			this.userFlag = userFlag;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
					+ ", userFlag=" + userFlag + "]";
		}

	   
}
