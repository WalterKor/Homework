package com.koreaboard.project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod1")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		int INTIBOARD = Integer.parseInt(iboard);
		
		BoardVO1 vo = BoardDAO1.selBoard(INTIBOARD);
		request.setAttribute("data", vo);
		
		String jsp = "/WEB-INF/jsp/mod1.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int INTIBOARD = Integer.parseInt(iboard);
		
		BoardVO1 vo = new BoardVO1();
		vo.setCtnt(ctnt);
		vo.setIboard(INTIBOARD);
		vo.setTitle(title);
		
		BoardDAO1.UPDATE(vo);
		response.sendRedirect("/detail?iboard=" +iboard);
	}

}
