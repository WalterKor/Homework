package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;


@WebServlet("/detail2")
public class DetailServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iboard = request.getParameter("iboard");
		
		BoardVO2 data = BoardDAO.selBoard(Integer.parseInt(iboard));
		request.setAttribute("data", data);
		
		String jsp = "WEB-INF/view/detail2.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}


	
}
