package com.spring.service;

import java.util.ArrayList;

import com.mycgv.dao.CgvMovieDAO;
import com.mycgv.vo.CgvMovieVO;

public class MovieServiceImpl implements MovieService{
	/**
	 * ��ȭ ��ü �ο��
	 */
	@Override
	public int getTotalCount() {
		CgvMovieDAO dao = new CgvMovieDAO();
		int dbCount = dao.totalCount();
		return dbCount;
	}
	
	/**
	 * ��ȭ ��ü ����Ʈ
	 */
	@Override
	public ArrayList<CgvMovieVO> getList(int startCount, int endCount){
		CgvMovieDAO dao = new CgvMovieDAO();
		ArrayList<CgvMovieVO> list = dao.select(startCount, endCount);
		return list;
	}
	
	/**
	 * ��ȭ ���
	 */
	@Override
	public int getInsert(CgvMovieVO vo) {
		CgvMovieDAO dao = new CgvMovieDAO();		
		int result = dao.insert(vo);
		return result;
	}
	
	/**
	 * ��ȭ ��� �� mid ��������
	 */
	@Override
	public String getMid() {
		CgvMovieDAO dao = new CgvMovieDAO();
		String mid = dao.selectMid();
		return mid;
	}
	
	/**
	 * ��ȭ ���� ���
	 */
	@Override
	public int getInsertFile(CgvMovieVO vo) {
		CgvMovieDAO dao = new CgvMovieDAO();
		int result2 = dao.insert_file(vo);
		return result2;
	}
	
	/**
	 * ��ȭ �󼼺���
	 */
	@Override
	public CgvMovieVO getContent(String mid) {
		CgvMovieDAO dao = new CgvMovieDAO();
		CgvMovieVO vo = dao.select(mid);
		return vo;
	}

}









