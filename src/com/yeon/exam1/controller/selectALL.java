package com.yeon.exam1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeon.exam1.dto.PersonnelDTO;
import com.yeon.exam1.service.PersonnelService;

/**
 * Servlet implementation class selectALL
 */
@WebServlet("/selectALL")
public class selectALL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectALL() {
        super();
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PersonnelService pService = new PersonnelService();
		ArrayList<PersonnelDTO> list = pService.selectALL();
		
		request.setAttribute("list", list);
		
		String html ="";
		
		//html += list.get("ID");
		
		request.getRequestDispatcher("views/selectPageEnd.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
