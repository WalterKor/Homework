package BoardCopy.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import BoardCopy.MyUtils;


@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("/user/userlogin", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println("uid : " +uid);
		System.out.println("upw : " +upw);
		 	

		UserVo vo = new UserVo();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		
		int result = UserDAO.login(vo);
		System.out.println("result : " + result);
		//로그인에 성공하면
		if(result ==1) {
			//로그인한 세션을 얻어오고
			HttpSession hs = request.getSession();
			//보안상으로 패스워드를 null값으로 바꾸고 
			vo.setUpw(null);
			//그러한 세션을 loginUser라고 저장한다.
			hs.setAttribute("loginUser", vo);
			
			response.sendRedirect("/board/list");
			//MyUtils.openJSP("/board/boardList", request, response);
			return;
						
		}
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생했습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		//다시로그인페이지로 가는거
		doGet(request, response);
		
		
		
	}

}
