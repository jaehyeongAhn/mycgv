package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycgv.dao.CgvMemberDAO;
import com.mycgv.vo.CgvMemberVO;
import com.mycgv.vo.SessionVO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private CgvMemberDAO memberDao;
	
	/**
	 * ȸ�� �� ����
	 */
	@Override
	public CgvMemberVO getMemberContent(String id) {
		return memberDao.selectContent(id);
		
	}
	
	/**
	 * ȸ�� ��ü��
	 */
	@Override
	public int getTotalCount() {
		
		return  memberDao.totalCount();
	}
	
	/**
	 * ȸ�� ��ü ����Ʈ
	 */
	@Override
	public ArrayList<CgvMemberVO> getMemberList(int startCount, int endCount){	
		ArrayList<CgvMemberVO> list = memberDao.selectAll(startCount, endCount);
		
		return list;
	}
	
	/** 
	 * ȸ������ ó��
	 */
	@Override
	public int getJoinResult(CgvMemberVO vo) {	
		//CgvMemberDAO dao = new CgvMemberDAO();
		return memberDao.insert(vo);
	}
	
	/**
	 * �α��� ó��
	 */
	@Override
	public SessionVO getLoginResult(CgvMemberVO vo) {	
		return memberDao.select(vo);
	}

	@Override
	public int getidCheck(String id) {
		return memberDao.idCheck(id);
	}
}
