package com.accp.qqemail.dao;

import java.util.List;

import com.accp.qqemail.entity.MailAndUserRelation;

public interface MailAndUserRelationDao {
	
		int insert(MailAndUserRelation mailAndUserRelation);
		
		int updatesc(int deleteState,int relId);
		
		//����ɾ��
		int cdsc(int relId);
		
		//�ƶ���
		int ydd(int foId,int relId);
		
		//���Ϊ�Ѷ�
		int bjiyd(int readState,int relId);
		
		//��ѯδ��
		int queryweidu(int userId);
		
		//��ѯ�ռ�
		int querysj(int userId);
}
