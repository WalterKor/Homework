package BoardCopy.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import BoardCopy.MyUtils;
import BoardCopy.Cmt.CmtDAO;
import BoardCopy.User.UserVo;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVo loginUser = (UserVo) hs.getAttribute("loginUser");
		
		 if(loginUser == null) {//로그아웃상태면 로그인페이지로 이동한다.
			 response.sendRedirect("/user/login");
			 return;
		 }
		
		List<BoardVO> list = BoardDAO.AllselList();	
		int iboard =MyUtils.getParamInt("iboard", request);
		
		
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.getIboard());
		}
		request.setAttribute("list", list);
		
		MyUtils.openJSP("/board/boardList", request, response);
		
	}




}
