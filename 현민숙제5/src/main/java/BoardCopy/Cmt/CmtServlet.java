package BoardCopy.Cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoardCopy.MyUtils;


@WebServlet("/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	//글등록 , 삭제
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int icmt = MyUtils.getParamInt("icmt", request);
		
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVo c = new CmtVo();
		c.setCmt(cmt);
		c.setIuser(iuser);
		
		if(icmt != 0) {
			
			c.setIcmt(icmt);
			CmtDAO.updCmt(c);
			
		}else {
			c.setIboard(iboard);
			CmtDAO.insertCmt(c);
		}
		
	}

}
