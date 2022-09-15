package com.mycgv.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv.vo.CgvNoticeVO;

@Repository
public class CgvNoticeDAO{
	@Autowired SqlSessionTemplate sqlSession;
	/**
	 * totalCount : 전체 로우수 출력
	 */
	public int totalCount() {
		
		return sqlSession.selectOne("mapper.notice.totalCount");
	}
	
	/**
	 * delete : 공지사항 삭제 
	 */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
	}
	/**
	 * update : 공지사항 업데이트 
	 */
	public int update(CgvNoticeVO vo) {
		return sqlSession.update("mapper.notice.update",vo);
	}
	
	/**
	 * updateHits : 조회수 업데이트 
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updatehits", nid);
		
	}
	
	/**
	 * select : 공지사항 상세보기
	 */
	public CgvNoticeVO select(String nid) {
		return sqlSession.selectOne("mapper.notice.select",nid);
	}
	
	/**
	 * select : 전체 공지사항 리스트
	 */
	public ArrayList<CgvNoticeVO> select(int startCount, int endCount){
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start",startCount);
		param.put("end",endCount);
		
		List<CgvNoticeVO> list = sqlSession.selectList("mapper.notice.listAll",param);
		return (ArrayList<CgvNoticeVO>)list;
	}
	
	
	/**
	 * insert : 공지사항 등록
	 */
	public int insert(CgvNoticeVO vo) {
		
		return sqlSession.insert("mapper.notice.insert", vo);
	}
}
