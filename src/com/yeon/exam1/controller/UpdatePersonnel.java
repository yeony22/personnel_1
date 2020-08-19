package com.yeon.exam1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeon.exam1.dto.PersonnelDTO;
import com.yeon.exam1.service.PersonnelService;

@WebServlet("/updateEmployee.do")
public class UpdatePersonnel extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public UpdatePersonnel() {
		super();
	}
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String duty = request.getParameter("duty");
		String phone = request.getParameter("phone");
		
		PersonnelDTO p = new PersonnelDTO(id, name, dept, position,duty, phone);
		PersonnelService pService =  new PersonnelService();
		
		int result = pService.updatePersonnel(p);
		
		if(result > 0) {
			System.out.println("데이터 변경 성공");
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("변경 실패");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
