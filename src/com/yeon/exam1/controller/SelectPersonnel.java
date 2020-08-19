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
 * Servlet implementation class SelectPersonnel
 */

@WebServlet("/selectEmployee.do")
public class SelectPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectPersonnel() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filter = request.getParameter("filter");

		String keyword = null;
		String deptName = null;

		if (filter.equals("id")) {
			keyword = request.getParameter("keyword");
		} else {
			deptName = request.getParameter("deptName");
		}

		PersonnelService pService = new PersonnelService();
		ArrayList<PersonnelDTO> list = pService.selectPersonnel(filter, keyword, deptName);

		request.setAttribute("list", list);

		request.getRequestDispatcher("views/selectPageEnd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
