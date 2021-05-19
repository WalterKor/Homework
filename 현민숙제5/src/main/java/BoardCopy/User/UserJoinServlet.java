package BoardCopy.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import BoardCopy.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		MyUtils.openJSP("/user/userjoin", request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		String password = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		UserVo vo = new UserVo();
		vo.setUid(uid);
		vo.setUnm(unm);
		vo.setUpw(password);
		vo.setGender(gender);
		
		UserDAO.join(vo);
		
		response.sendRedirect("/user/login");
		
	}

}
