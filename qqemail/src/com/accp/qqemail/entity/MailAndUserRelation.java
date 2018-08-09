package com.accp.qqemail.entity;

public class MailAndUserRelation {
	private int	relId;
	private int	userId;
	private int	mailId;
	private int	mailModel;
	private int	readState;
	private int	deleteState;
	private int foId;
	private int	isRec;
	private String	createTime;
	public int getRelId() {
		return relId;
	}
	public void setRelId(int relId) {
		this.relId = relId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	public int getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
	public int getFoId() {
		return foId;
	}
	public void setFoId(int foId) {
		this.foId = foId;
	}
	public int getIsRec() {
		return isRec;
	}
	public void setIsRec(int isRec) {
		this.isRec = isRec;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public MailAndUserRelation() {
		super();
	}
	public MailAndUserRelation(int userId, int mailId, int mailModel, int readState, int deleteState, int foId,
			int isRec, String createTime) {
		super();
		this.userId = userId;
		this.mailId = mailId;
		this.mailModel = mailModel;
		this.readState = readState;
		this.deleteState = deleteState;
		this.foId = foId;
		this.isRec = isRec;
		this.createTime = createTime;
	}
	public MailAndUserRelation(int relId, int userId, int mailId, int mailModel, int readState, int deleteState,
			int foId, int isRec, String createTime) {
		super();
		this.relId = relId;
		this.userId = userId;
		this.mailId = mailId;
		this.mailModel = mailModel;
		this.readState = readState;
		this.deleteState = deleteState;
		this.foId = foId;
		this.isRec = isRec;
		this.createTime = createTime;
	}

}
