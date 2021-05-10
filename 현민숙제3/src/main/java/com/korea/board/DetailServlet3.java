package com.korea.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class DetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO3 data = BoardDAO.selBoard(iboard);
		
		request.setAttribute("data", data);
		
		MyUtils.openJsp("detail3", request, response);
		
	}


	
}
