package com.koreaboard.project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail1")
public class DetailServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " +iboard);
		
		BoardVO1 vo = BoardDAO1.selBoard(Integer.parseInt(iboard));
		request.setAttribute("data", vo);
		
		String jsp ="/WEB-INF/jsp/detail1.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	

}
