package com.Koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Koreait.board4.MyUtils;


@WebServlet("/board/mod")
public class modServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVo vo = new BoardVo(); 
		int iboard = MyUtils.getParamInt("iboard", request);
		vo.setIboard(iboard);
		
		vo = BoardDAO.pickboard(vo);
		
		if(vo.getIuser() != MyUtils.getLoginUserPk(request)) {
			response.sendRedirect("/board/list");
			return;
		}
		
		
		BoardVo data = BoardDAO.pickboard(vo);
		request.setAttribute("data", data);
		
		MyUtils.openJSP("board/mod", request, response);
		
		
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		
		BoardDAO.updateBoard(vo);
		response.sendRedirect("/board/detail?iboard="+iboard);
		
		
	}

}
