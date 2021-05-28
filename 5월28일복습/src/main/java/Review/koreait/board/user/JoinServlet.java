package Review.koreait.board.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Review.koreait.board.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/join", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		String chkupw = request.getParameter("chkupw");
		int gender = MyUtils.getParamInt("gender", request);
		
		UserEntitiy vo =  new UserEntitiy();
		
		vo.setUid(uid);
		vo.setUpw(chkupw);
		vo.setUnm(chkupw);
		vo.setGender(gender);
		
		UserDAO.join(vo);
		
		response.sendRedirect("/user/login");
		
		
		
		
		 
		
	}

}
