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
	 * 영화 전체 로우수
	 */
	@Override
	public int getTotalCount() {
		return moviedao.totalCount();
	}
	
	/**
	 * 영화 전체 리스트
	 */
	@Override
	public ArrayList<CgvMovieVO> getList(int startCount, int endCount){
		ArrayList<CgvMovieVO> list = moviedao.select(startCount, endCount);
		return list;
	}
	
	/**
	 * 영화 등록
	 */
	@Override
	public int getInsert(CgvMovieVO vo) {
		return moviedao.insert(vo);
	}
	
	/**
	 * 영화 등록 후 mid 가져오기
	 */
	@Override
	public String getMid() {
		return moviedao.selectMid();
	}
	
	/**
	 * 영화 파일 등록
	 */
	@Override
	public int getInsertFile(CgvMovieVO vo) {
		return moviedao.insert_file(vo);
	}
	
	/**
	 * 영화 상세보기
	 */
	@Override
	public CgvMovieVO getContent(String mid) {
		return moviedao.select(mid);
	}

}









