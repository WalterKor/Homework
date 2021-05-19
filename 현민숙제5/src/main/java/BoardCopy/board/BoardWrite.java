package BoardCopy.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoardCopy.MyUtils;

@WebServlet("/board/wirte")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	
    
    	MyUtils.openJSP("/board/boardwrite", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		System.out.println("title : " +title);
		System.out.println("ctnt : " +ctnt);
		
		BoardVO bo = new BoardVO();
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		bo.setIuser(iuser);
		
		BoardDAO.insboard(bo);
		
		response.sendRedirect("/board/list");
	}

}
