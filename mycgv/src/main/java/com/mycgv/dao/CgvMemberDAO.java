package com.mycgv.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv.vo.CgvMemberVO;

/**
 * 1. dbcoon extends 삭제 @Repository 형태로 변환
 *
 */
@Repository
public class CgvMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; //root-context에서 만들어진 sqlSession 객체생성
	/**
	 * totalCount : 전체 로우수 출력
	 */
	public int totalCount() {
		
		
		return sqlSession.selectOne("mapper.member.total_count");
	}
	
	/**
	 * idCheck : 아이디 중복체크
	 */
	public int idCheck(String id) {
		
		return sqlSession.selectOne("mapper.member.idcheck",id);
	}
	
	/**
	 * selectContent : 회원 상세 정보
	 */
	public CgvMemberVO selectContent(String id) {
		
		return sqlSession.selectOne("mapper.member.content",id);
	}
	
	/**
	 * selectAll : 회원 전체 리스트
	 */
	public ArrayList<CgvMemberVO> selectAll(int startCount, int endCount){
		//map 타입의 객체를 생성하고 start,end 라는 키이름으로 파라미터를 넘긴다.
		
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start",startCount);
		param.put("end",endCount);
		List<CgvMemberVO> list = sqlSession.selectList("mapper.member.listAll",param);
		return (ArrayList<CgvMemberVO>)list;
	}
	
	/**
	 * select : 로그인
	 */
	public int select(CgvMemberVO vo) {
		
		return sqlSession.selectOne("mapper.member.login", vo);
	}
	
	
	
	/**
	 * insert : 회원가입 
	 */
	public int insert(CgvMemberVO vo) {
		//sqlSession 객체의 메소드를 호출하여 실행결과를 가져옴
		return sqlSession.insert("mapper.member.join", vo);
		
		//int result = 0;
		//result = sqlSession.insert("mapper.member.join", vo);
		//				sql을 가지고 있는 매퍼의 namespace+id,데이터를 가지고 있는 파라미터 객체
		
		
		/*	>>cgv_member_mapper에서 처리
		 * String sql = "insert into cgv_member " +
		 * " values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		 */
		/* >> root-context에서 만들어진 sqlSession이 처리
		 * try { getPreparedStatement(sql); pstmt.setString(1, vo.getId());
		 * pstmt.setString(2, vo.getPass()); pstmt.setString(3, vo.getName());
		 * pstmt.setString(4, vo.getGender()); pstmt.setString(5, vo.getEmail());
		 * pstmt.setString(6, vo.getZonecode()); pstmt.setString(7, vo.getAddr1());
		 * pstmt.setString(8, vo.getAddr2()); pstmt.setString(9, vo.getHp());
		 * pstmt.setString(10, vo.getPnumber()); pstmt.setString(11, vo.getHobbylist());
		 * pstmt.setString(12, vo.getIntro());
		 * 
		 * result = pstmt.executeUpdate();
		 * 
		 * close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		
	}
}
