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
 * 1. dbcoon extends ���� @Repository ���·� ��ȯ
 *
 */
@Repository
public class CgvMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; //root-context���� ������� sqlSession ��ü����
	/**
	 * totalCount : ��ü �ο�� ���
	 */
	public int totalCount() {
		
		
		return sqlSession.selectOne("mapper.member.total_count");
	}
	
	/**
	 * idCheck : ���̵� �ߺ�üũ
	 */
	public int idCheck(String id) {
		
		return sqlSession.selectOne("mapper.member.idcheck",id);
	}
	
	/**
	 * selectContent : ȸ�� �� ����
	 */
	public CgvMemberVO selectContent(String id) {
		
		return sqlSession.selectOne("mapper.member.content",id);
	}
	
	/**
	 * selectAll : ȸ�� ��ü ����Ʈ
	 */
	public ArrayList<CgvMemberVO> selectAll(int startCount, int endCount){
		//map Ÿ���� ��ü�� �����ϰ� start,end ��� Ű�̸����� �Ķ���͸� �ѱ��.
		
		Map<String,Integer> param = new HashMap<String,Integer>();
		param.put("start",startCount);
		param.put("end",endCount);
		List<CgvMemberVO> list = sqlSession.selectList("mapper.member.listAll",param);
		return (ArrayList<CgvMemberVO>)list;
	}
	
	/**
	 * select : �α���
	 */
	public int select(CgvMemberVO vo) {
		
		return sqlSession.selectOne("mapper.member.login", vo);
	}
	
	
	
	/**
	 * insert : ȸ������ 
	 */
	public int insert(CgvMemberVO vo) {
		//sqlSession ��ü�� �޼ҵ带 ȣ���Ͽ� �������� ������
		return sqlSession.insert("mapper.member.join", vo);
		
		//int result = 0;
		//result = sqlSession.insert("mapper.member.join", vo);
		//				sql�� ������ �ִ� ������ namespace+id,�����͸� ������ �ִ� �Ķ���� ��ü
		
		
		/*	>>cgv_member_mapper���� ó��
		 * String sql = "insert into cgv_member " +
		 * " values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		 */
		/* >> root-context���� ������� sqlSession�� ó��
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
