package com.accp.qqemail.entity;

public class LianJie3 {
		private int mailId;
		private int mailModel;
		private int readState;
		private int foId;
		private String createTime;
		private int relId;
		private int isRec;
		private String Title;
		private String senEmail;
		private String recContent;
		private String normalEmail;
		private String copyEmail;
		private String encAdress;
		public int getMailId() {
			return mailId;
		}
		public void setMailId(int mailId) {
			this.mailId = mailId;
		}
		public int getMailModel() {
			return mailModel;
		}
		public void setMailModel(int mailModel) {
			this.mailModel = mailModel;
		}
		public int getReadState() {
			return readState;
		}
		public void setReadState(int readState) {
			this.readState = readState;
		}
		public int getFoId() {
			return foId;
		}
		public void setFoId(int foId) {
			this.foId = foId;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public int getRelId() {
			return relId;
		}
		public void setRelId(int relId) {
			this.relId = relId;
		}
		public int getIsRec() {
			return isRec;
		}
		public void setIsRec(int isRec) {
			this.isRec = isRec;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getSenEmail() {
			return senEmail;
		}
		public void setSenEmail(String senEmail) {
			this.senEmail = senEmail;
		}
		public String getRecContent() {
			return recContent;
		}
		public void setRecContent(String recContent) {
			this.recContent = recContent;
		}
		public String getNormalEmail() {
			return normalEmail;
		}
		public void setNormalEmail(String normalEmail) {
			this.normalEmail = normalEmail;
		}
		public String getCopyEmail() {
			return copyEmail;
		}
		public void setCopyEmail(String copyEmail) {
			this.copyEmail = copyEmail;
		}
		public String getEncAdress() {
			return encAdress;
		}
		public void setEncAdress(String encAdress) {
			this.encAdress = encAdress;
		}
		public LianJie3() {
			super();
		}
		public LianJie3(int mailId, int mailModel, int readState, int foId, String createTime, int relId, int isRec,
				String title, String senEmail, String recContent, String normalEmail, String copyEmail,
				String encAdress) {
			super();
			this.mailId = mailId;
			this.mailModel = mailModel;
			this.readState = readState;
			this.foId = foId;
			this.createTime = createTime;
			this.relId = relId;
			this.isRec = isRec;
			Title = title;
			this.senEmail = senEmail;
			this.recContent = recContent;
			this.normalEmail = normalEmail;
			this.copyEmail = copyEmail;
			this.encAdress = encAdress;
		}
		
}
