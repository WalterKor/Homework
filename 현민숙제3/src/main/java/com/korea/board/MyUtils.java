package com.korea.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyUtils {
			
	public static int parseStringToInt(String num) {
		try {return Integer.parseInt(num);}
		catch (Exception e) {}
		return 0;
		
	}
	
	
	public static void openJsp(String fileNm,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
	request.getRequestDispatcher(jsp).forward(request, response);
	
	}


	public static int getParamInt(String key, HttpServletRequest request) {
		
		String strVal = request.getParameter(key);
		
		int intVal = parseStringToInt(strVal);
		return intVal;
	}
	
}
