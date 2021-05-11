package com.Koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.mindrot.jbcrypt.BCrypt;

import com.Koreait.board4.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("user/join", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserVO vo = new UserVO();
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
				
		vo.setUid(uid);
		vo.setUpw(hashedUpw);
		vo.setUnm(unm);
		vo.setGender(MyUtils.getParamInt("gender", request));
//		int gender = MyUtils.getParamInt("gender", request);
//		vo.setGender(gender);
		 	
		 
		UserDAO.joinUser(vo);
		
		System.out.println("userId : "+vo.getUid());
		System.out.println("userPw : "+vo.getUpw());
		System.out.println("userNm : "+vo.getUnm());
		System.out.println("userGender :"	  +vo.getGender());
	
		response.sendRedirect("login");
	}

}
