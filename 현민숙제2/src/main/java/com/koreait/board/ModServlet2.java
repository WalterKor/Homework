package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod2")
public class ModServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		
		BoardVO2 data = BoardDAO.selBoard(Integer.parseInt(iboard));
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/view/mod2.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int INTIBOARD = Integer.parseInt(iboard);
		
		BoardVO2 bo = new BoardVO2();
		
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		bo.setIboard(INTIBOARD);
		
		BoardDAO.UpdateBoard(bo);
		
		response.sendRedirect("/detail2?iboard=" + iboard);
		
		
		
		
	}

}
