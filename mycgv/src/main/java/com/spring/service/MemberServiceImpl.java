package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycgv.dao.CgvMemberDAO;
import com.mycgv.vo.CgvMemberVO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private CgvMemberDAO memberDao;
	
	/**
	 * 회원 상세 정보
	 */
	@Override
	public CgvMemberVO getMemberContent(String id) {
		return memberDao.selectContent(id);
		
	}
	
	/**
	 * 회원 전체수
	 */
	@Override
	public int getTotalCount() {
		
		return  memberDao.totalCount();
	}
	
	/**
	 * 회원 전체 리스트
	 */
	@Override
	public ArrayList<CgvMemberVO> getMemberList(int startCount, int endCount){	
		ArrayList<CgvMemberVO> list = memberDao.selectAll(startCount, endCount);
		
		return list;
	}
	
	/** 
	 * 회원가입 처리
	 */
	@Override
	public int getJoinResult(CgvMemberVO vo) {	
		//CgvMemberDAO dao = new CgvMemberDAO();
		return memberDao.insert(vo);
	}
	
	/**
	 * 로그인 처리
	 */
	@Override
	public int getLoginResult(CgvMemberVO vo) {	
		return memberDao.select(vo);
	}

	@Override
	public int getidCheck(String id) {
		return memberDao.idCheck(id);
	}
}
