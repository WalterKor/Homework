package com.koreaboard.project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

@WebServlet("/del1")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iboard = request.getParameter("iboard");
		int IntIboard = Integer.parseInt(iboard);
		
		BoardVO1 vo = new BoardVO1();
		vo.setIboard(IntIboard);
		
		BoardDAO1.del(vo);
		response.sendRedirect("/list1");
	}


}
