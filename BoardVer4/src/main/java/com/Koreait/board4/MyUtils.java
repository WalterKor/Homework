package com.Koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String fileNe,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String jsp = "/WEB-INF/view/"+fileNe+".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
	
	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String strVal = req.getParameter(key);
		
		int intVal = parseStringToInt(strVal);
		return intVal;
	}
	
}
