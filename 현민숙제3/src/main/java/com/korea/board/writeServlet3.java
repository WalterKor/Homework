package com.korea.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write3")
public class writeServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String jsp = "/WEB-INF/view/write3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO3 bo = new BoardVO3();
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		
		BoardDAO.insertBoard(bo);
		response.sendRedirect("/list3");
		
	}

}
