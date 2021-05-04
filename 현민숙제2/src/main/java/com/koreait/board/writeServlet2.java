package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write2")
public class writeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "WEB-INF/view/write2.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO2 bo = new BoardVO2();
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		
		BoardDAO.insert(bo);
		
		response.sendRedirect("/list2");
		
		
	}

}
