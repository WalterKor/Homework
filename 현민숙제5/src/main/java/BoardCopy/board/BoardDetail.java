package BoardCopy.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BoardCopy.MyUtils;

@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int iuser = MyUtils.getLoginUserPk(request);
		int iboard = MyUtils.getParamInt("iboard", request);
		
		System.out.println("iboard : "+iboard);
		System.out.println("iuser : "+iuser);
		
		
		BoardVO data = BoardDAO.selBoard(iboard);
		
		
		request.setAttribute("data", data);
		MyUtils.openJSP("/board/boardDetail", request, response);
		
		
	}

}
