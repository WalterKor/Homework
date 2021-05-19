package BoardCopy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import BoardCopy.User.UserVo;



public class MyUtils {
	
	public  static void gotoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVo loginUser = (UserVo)hs.getAttribute("loginUser");
		if(loginUser != null) { //로그인 상태 
			response.sendRedirect("/user/login");
			return;
		}
	}
	
	
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
	
	
	public static  UserVo getLoginUser(HttpServletRequest req) {
	
		if(req == null) {return null;}
		HttpSession hs = req.getSession();
		return (UserVo)hs.getAttribute("loginUser");
		
	}

	public static int getLoginUserPk(HttpServletRequest request) {
		
		if(request == null) {return 0;}
		return getLoginUser(request).getIuser();
	}
	
	
}
