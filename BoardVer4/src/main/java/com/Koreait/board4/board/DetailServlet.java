package com.Koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Koreait.board4.MyUtils;
import com.Koreait.board4.cmt.CmtDAO;



@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	BoardVo vo = new BoardVo();
	int iboard = MyUtils.getParamInt("iboard", request);
	int iuser = MyUtils.getLoginUserPk(request);
	
	vo.setIboard(iboard);
	vo.setIuser(iuser);
	
	BoardVo data = BoardDAO.pickboard(vo);
	
	request.setAttribute("data", data);//글의정보
	request.setAttribute("cmtList", CmtDAO.selCmtList(iboard));//댓글의 정보
	
	MyUtils.openJSP("board/detail", request, response);
	
	}
	
}
