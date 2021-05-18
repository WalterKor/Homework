package com.Koreait.board4.cmt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Koreait.board4.MyUtils;
import com.Koreait.board4.board.BoardVo;


@WebServlet("/board/cmt")

public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//삭제       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		CmtDAO.delCmt(param);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

	//글등록, 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO param = new CmtVO();
		param.setIboard(iboard);
		param.setIuser(iuser);
		param.setCmt(cmt);
		
		CmtDAO.insCmt(param);
		
	
		response.sendRedirect("detail?iboard=" +iboard);
	}

}
