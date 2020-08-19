package com.yeon.exam1.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.yeon.exam1.dto.PersonnelDTO;

import static com.yeon.exam1.common.JDBCTemplate.*;

public class PersonnelDAO {
	private Properties prop;
	
	public PersonnelDAO() {
		prop = new Properties();
		
		String filePath = PersonnelDAO.class.getResource("/config/personnel-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PersonnelDTO> selectList(Connection con, String filter, String keyword, String deptName) {
		ArrayList<PersonnelDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기 위한 객체
		ResultSet rset = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			if(filter.equals("id")) { // id로 검색했다면
				pstmt.setString(1, keyword);
				pstmt.setString(2, "");
		
			} else { 					// 부서명으로 검색했다면
				pstmt.setString(1, "0");
				pstmt.setString(2, deptName);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				PersonnelDTO p = new PersonnelDTO();
				
				p.setId(rset.getString("ID"));
				p.setName(rset.getString("NAME"));
				p.setDept(rset.getString("DEPT"));
				p.setPosition(rset.getString("POSITION"));
				p.setDuty(rset.getString("DUTY"));
				p.setPhone(rset.getString("PHONE"));
				
				list.add(p);
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertPersonnel(Connection con, PersonnelDTO p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getDept());
			pstmt.setString(4, p.getPosition());
			pstmt.setString(5, p.getDuty());
			pstmt.setString(6, p.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		
		}
		return result;
	}

	public int updatePersonnel(Connection con, PersonnelDTO p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(6, p.getId());
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDept());
			pstmt.setString(3, p.getPosition());
			pstmt.setString(4, p.getDuty());
			pstmt.setString(5, p.getPhone());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			
			//out.println(e.getMessage());

			e.printStackTrace();
		} finally {
			
			close(pstmt);
					
		}
		
		return result;
		
	}
}




