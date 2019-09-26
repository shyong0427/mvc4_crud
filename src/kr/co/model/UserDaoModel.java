package kr.co.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.controller.UserForm;

public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public UserDaoModel() {	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		SqlSession session = factory.openSession();
		
		try {
			dto = session.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return dto;
	}
	
	public ArrayList<UserDto> getUserAll() {
		List<UserDto> list = null;
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserAll err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return (ArrayList<UserDto>)list;
	}
	
	public int insertData(UserForm userForm) {
		int re = 0;
		SqlSession session = factory.openSession();
		
		try {
			re = session.insert("inserData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			session.rollback();
		} finally {
			if(session != null) session.close();
		}
		
		return re;
	}
	
	public int updateData(UserForm userForm) {
		int re = 0;
		SqlSession session = factory.openSession();
		
		try {
			re = session.update("updateData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			session.rollback();
		} finally {
			if(session != null) session.close();
		}
		
		return re;
	}
	
	public int deleteData(UserForm userForm) {
		int re = 0;
		SqlSession session = factory.openSession();
		
		try {
			re = session.update("deleteData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			session.rollback();
		} finally {
			if(session != null) session.close();
		}
		
		return re;
	}
}