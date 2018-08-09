package com.accp.qqemail.entity;

public class Enclosure {
private int	encId;
private int	mailId;
private String	encAdress;
public int getEncId() {
	return encId;
}
public void setEncId(int encId) {
	this.encId = encId;
}
public int getMailId() {
	return mailId;
}
public void setMailId(int mailId) {
	this.mailId = mailId;
}
public String getEncAdress() {
	return encAdress;
}
public void setEncAdress(String encAdress) {
	this.encAdress = encAdress;
}
public Enclosure(int mailId, String encAdress) {
	super();
	this.mailId = mailId;
	this.encAdress = encAdress;
}
public Enclosure(int encId, int mailId, String encAdress) {
	super();
	this.encId = encId;
	this.mailId = mailId;
	this.encAdress = encAdress;
}

}
