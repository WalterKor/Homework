package com.Koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Koreait.board4.MyUtils;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//홍준이한테 질문하
		//로그인이 되어있는 상태인지 아닌지 확인하고 
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		
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
		
		if(result == 1 ) {
			
			HttpSession hs = request.getSession();
			
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo); 
		 
			//vo가 가리키는 UserVO객체는 (iuser, uid, unm값만 담고 있다.)
			
			response.sendRedirect("/board/list");
			return;
		}
		String errmsg  = null;
		switch (result) {
		case 0:
			errmsg = "에러가 발생했습니다.";
			break;
		case 2:
			errmsg = "아이디를 확인해주세요";
			break;
		case 3:
			errmsg = "비밀번호를 확인해주세요";
			break;					
		}
		request.setAttribute("errMsg", errmsg);
			doGet(request,response); //로그인페이지로 다시 이동하는거 
			
			//response.sendRedirect("login");//로그인페이지로 다시 이동하는거 2 그냥 주소값이동 		
			
	}
	
	

}
