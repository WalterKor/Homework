package com.korea.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class modServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		
		BoardVO3 data = BoardDAO.selBoard(Integer.parseInt(iboard));
		request.setAttribute("data", data);
	
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String iboard = request.getParameter("iboard");
		String ctnt = request.getParameter("ctnt");
		
		int INTIBOARD = Integer.parseInt(iboard);
		
		BoardVO3 vo = new BoardVO3();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(INTIBOARD);
		
		BoardDAO.Upload(vo);
		
		response.sendRedirect("/detail3?iboard=" +iboard);
		
	}

}
