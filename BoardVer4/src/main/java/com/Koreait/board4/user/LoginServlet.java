package com.Koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Koreait.board4.MyUtils;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		switch (result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		default:
			//doGet(request,response); //로그인페이지로 다시 이동하는거 
			//response.sendRedirect("login");//로그인페이지로 다시 이동하는거 2 그냥 주소값이동 		
			break;
		}
	}

}
