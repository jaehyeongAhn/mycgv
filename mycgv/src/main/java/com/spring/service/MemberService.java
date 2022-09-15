package com.spring.service;

import java.util.ArrayList;

import com.mycgv.vo.CgvMemberVO;

public interface MemberService {	
	int getLoginResult(CgvMemberVO vo);  //�α��� ó�� �޼ҵ�
	int getJoinResult(CgvMemberVO vo);	 //ȸ������ ó�� �޼ҵ�
	int getTotalCount();	//��ü ȸ���� 
	ArrayList<CgvMemberVO> getMemberList(int startCount, int endCount);  //ȸ�� ��ü ����Ʈ
	CgvMemberVO getMemberContent(String id);	//ȸ�� ������
	int getidCheck(String id); //idcechk
}
