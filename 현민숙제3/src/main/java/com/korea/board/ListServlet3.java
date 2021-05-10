package com.korea.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list3") 
public class ListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BoardVO3> list = BoardDAO.AllSelect();
		request.setAttribute("list", list);
				
		MyUtils.openJsp("list3", request, response);
		
		
		
		
		//request.getRequestDispatcher(jsp).forward(request, response);
		
	}


}
