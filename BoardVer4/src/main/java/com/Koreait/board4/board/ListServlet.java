package com.Koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;

import com.Koreait.board4.MyUtils;
import com.Koreait.board4.user.UserVO;


@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 HttpSession hs = request.getSession();
	 UserVO loginUser =(UserVO)hs.getAttribute("loginUser");
	 //로그인을 했으면 board/list.jsp응답
	 
	 if(loginUser == null) {
		 response.sendRedirect("/user/login");
		 return;
	 }
	 
	 List<BoardVo> list = BoardDAO.selboard();
	 request.setAttribute("list", list);
	 
	 //로그인이 안되어 있으면 로그인 화면으로 이동해라 
	 MyUtils.openJSP("board/list", request, response);
	 
	}


}


/*	
		HttpSession hs = request.getSession();
		
		Boolean loginSucess = (Boolean)hs.getAttribute("loginSucess");
		
		if(loginSucess == null || loginSucess == false) {
			 
			System.out.println("loginSucess : " + loginSucess);
			response.sendRedirect("/user/login");
			return;			
		}
		MyUtils.openJSP("board/list", request, response);
		
 */