package com.accp.qqemail.entity;

public class MailFolder {
private int	foId;
private int	userId;
private String	FolderName;
public int getFoId() {
	return foId;
}
public void setFoId(int foId) {
	this.foId = foId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFolderName() {
	return FolderName;
}
public void setFolderName(String folderName) {
	FolderName = folderName;
}
public MailFolder(int userId, String folderName) {
	super();
	this.userId = userId;
	FolderName = folderName;
}
public MailFolder(int foId, int userId, String folderName) {
	super();
	this.foId = foId;
	this.userId = userId;
	FolderName = folderName;
}

}
