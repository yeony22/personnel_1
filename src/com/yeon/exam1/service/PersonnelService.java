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

	public int insertPersonnel(PersonnelDTO p) {
		Connection con = getConnection();
		int result = pdao.insertPersonnel(con, p);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		return result;
	}
	public int updatePersonnel(PersonnelDTO p) {
		
		Connection con = getConnection();
		int result = pdao.updatePersonnel(con, p);
		
		if(result > 0)
			commit(con);
		else 
			rollback(con);
		
		return result;
	}
				
		

	public int deletePersonnel(PersonnelDTO p) {
		Connection con = getConnection();
		int result = pdao.deletePersonnel(con, p);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		return result;
	}

}
