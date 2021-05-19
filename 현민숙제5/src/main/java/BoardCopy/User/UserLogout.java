package BoardCopy.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BoardCopy.MyUtils;


@WebServlet("/user/logout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		//세션을 지우는 메서드
		hs.invalidate();
		
		MyUtils.openJSP("/user/userlogin", request, response);
	}



}
