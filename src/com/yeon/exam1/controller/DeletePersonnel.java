package com.yeon.exam1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeon.exam1.dto.PersonnelDTO;
import com.yeon.exam1.service.PersonnelService;

/**
 * Servlet implementation class DeletePersonnel
 */
@WebServlet("/deleteEmployee.do")
public class DeletePersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonnel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		PersonnelDTO p = new PersonnelDTO(id, name);
		
		PersonnelService pService = new PersonnelService();
		int result = pService.deletePersonnel(p);
		
		if (result > 0) {
			System.out.println("데이터 삭제 성공" + "(id=" + id + ", name=" + name + ")");
			response.sendRedirect("index.jsp");
		}
		else {
			System.out.println("데이터 삭제 실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
