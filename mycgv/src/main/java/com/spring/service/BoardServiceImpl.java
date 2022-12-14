package com.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv.dao.CgvBoardDAO;
import com.mycgv.vo.CgvBoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private CgvBoardDAO boardDao;
	/**
	 * 삭제 처리
	 */
	@Override
	public int getDelete(String bid) {
		return boardDao.delete(bid);
	}
	
	/**
	 * 수정처리
	 */
	@Override
	public int getUpdate(CgvBoardVO vo) {
		return boardDao.update(vo);
	}
	
	/**
	 * 조회수 업데이트
	 */
	@Override
	public void getUpdateHits(String bid) {
		
		boardDao.updateHits(bid);
	}
	
	/**
	 * 게시글 쓰기
	 */
	@Override
	public int getWriteResult(CgvBoardVO vo) {
		return boardDao.insert(vo);
	}
	
	/**
	 * 게시글 상세보기
	 */
	@Override
	public CgvBoardVO getContent(String bid) {
		return boardDao.select(bid);
	}		
	
	/**
	 * 게시글 전체 로우
	 */
	@Override
	public int getTotalCount() {
		return boardDao.totalCount();
	}
	
	/**
	 * 게시글 전체 리스트
	 */
	@Override
	public ArrayList<CgvBoardVO> getList(int startCount, int endCount){
		ArrayList<CgvBoardVO> list = boardDao.selectAll(startCount, endCount);
		return list;
	}

}
