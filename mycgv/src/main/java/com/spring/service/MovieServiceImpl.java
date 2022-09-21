package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv.dao.CgvMovieDAO;
import com.mycgv.vo.CgvMovieVO;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private CgvMovieDAO moviedao;
	/**
	 * ��ȭ ��ü �ο��
	 */
	@Override
	public int getTotalCount() {
		return moviedao.totalCount();
	}
	
	/**
	 * ��ȭ ��ü ����Ʈ
	 */
	@Override
	public ArrayList<CgvMovieVO> getList(int startCount, int endCount){
		ArrayList<CgvMovieVO> list = moviedao.select(startCount, endCount);
		return list;
	}
	
	/**
	 * ��ȭ ���
	 */
	@Override
	public int getInsert(CgvMovieVO vo) {
		return moviedao.insert(vo);
	}
	
	/**
	 * ��ȭ ��� �� mid ��������
	 */
	@Override
	public String getMid() {
		return moviedao.selectMid();
	}
	
	/**
	 * ��ȭ ���� ���
	 */
	@Override
	public int getInsertFile(CgvMovieVO vo) {
		return moviedao.insert_file(vo);
	}
	
	/**
	 * ��ȭ �󼼺���
	 */
	@Override
	public CgvMovieVO getContent(String mid) {
		return moviedao.select(mid);
	}

}









