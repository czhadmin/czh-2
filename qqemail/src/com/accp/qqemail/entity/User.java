package com.accp.qqemail.entity;

public class User {
		private int userId;
		private String email;
		private String password;
		private String nickName;
		private String registerTime;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getRegisterTime() {
			return registerTime;
		}
		public void setRegisterTime(String registerTime) {
			this.registerTime = registerTime;
		}
		public User() {
			super();
		}
		public User(String email, String password, String nickName, String registerTime) {
			super();
			this.email = email;
			this.password = password;
			this.nickName = nickName;
			this.registerTime = registerTime;
		}
		public User(int userId, String email, String password, String nickName, String registerTime) {
			super();
			this.userId = userId;
			this.email = email;
			this.password = password;
			this.nickName = nickName;
			this.registerTime = registerTime;
		}

}
