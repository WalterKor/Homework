package BoardCopy.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoardCopy.MyUtils;


@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO vo = BoardDAO.selBoard(MyUtils.getParamInt("iboard", request));
		
		if(vo.getIuser() != MyUtils.getLoginUserPk(request)) {
			response.sendRedirect("/board/list");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO data = BoardDAO.selBoard(iboard);
		request.setAttribute("data", data);
		
		
		MyUtils.openJSP("/board/boardMod", request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		
		BoardDAO.update(vo);
		response.sendRedirect("/board/detail?iboard="+iboard);
		
		
		
		
	}

}
