package com.yeon.exam1.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.yeon.exam1.dao.PersonnelDAO;
import com.yeon.exam1.dto.PersonnelDTO;
import static com.yeon.exam1.common.JDBCTemplate.*;

public class PersonnelService {
	
	PersonnelDAO pdao;
	
	public PersonnelService() {
		pdao = new PersonnelDAO();
	}
	public ArrayList<PersonnelDTO> selectPersonnel(String filter, String keyword, String deptName) {
		
		Connection con = getConnection();
		ArrayList<PersonnelDTO> list = pdao.selectList(con, filter, keyword, deptName);
		
		close(con);
		
		return list;
	}
	
	public ArrayList<PersonnelDTO> selectID(String keyword) {
		
		Connection con = getConnection();
		ArrayList<PersonnelDTO> list = pdao.selectID(con, keyword);
		
		close(con);
		
		return list;
	}
	
	public ArrayList<PersonnelDTO> selectALL() {
		Connection con = getConnection();
		ArrayList<PersonnelDTO> list = pdao.selectALL(con);
		
		return list;
	}
}
