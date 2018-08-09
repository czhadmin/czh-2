package com.accp.qqemail.entity;

public class Mailinfo {
private int	mailId;
private String	title;
private String	recContent;
private String	senEmail;
private String	normalEmail;
private String	copyEmail;
private String	secretEmail;
private int	isdraft;
private int	recFlag;
private String	createTime;
public int getMailId() {
	return mailId;
}
public void setMailId(int mailId) {
	this.mailId = mailId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getRecContent() {
	return recContent;
}
public void setRecContent(String recContent) {
	this.recContent = recContent;
}
public String getSenEmail() {
	return senEmail;
}
public void setSenEmail(String senEmail) {
	this.senEmail = senEmail;
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
public String getSecretEmail() {
	return secretEmail;
}
public void setSecretEmail(String secretEmail) {
	this.secretEmail = secretEmail;
}
public int getIsdraft() {
	return isdraft;
}
public void setIsdraft(int isdraft) {
	this.isdraft = isdraft;
}
public int getRecFlag() {
	return recFlag;
}
public void setRecFlag(int recFlag) {
	this.recFlag = recFlag;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}

public Mailinfo() {
	super();
}
public Mailinfo(String title, String recContent, String senEmail, String normalEmail, String copyEmail,
		String secretEmail, int isdraft, int recFlag, String createTime) {
	super();
	this.title = title;
	this.recContent = recContent;
	this.senEmail = senEmail;
	this.normalEmail = normalEmail;
	this.copyEmail = copyEmail;
	this.secretEmail = secretEmail;
	this.isdraft = isdraft;
	this.recFlag = recFlag;
	this.createTime = createTime;
}
public Mailinfo(int mailId, String title, String recContent, String senEmail, String normalEmail, String copyEmail,
		String secretEmail, int isdraft, int recFlag, String createTime) {
	super();
	this.mailId = mailId;
	this.title = title;
	this.recContent = recContent;
	this.senEmail = senEmail;
	this.normalEmail = normalEmail;
	this.copyEmail = copyEmail;
	this.secretEmail = secretEmail;
	this.isdraft = isdraft;
	this.recFlag = recFlag;
	this.createTime = createTime;
}


}
