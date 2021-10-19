package Course.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;


@WebServlet("/backStage/notCheckCoursePage/checking")
public class PassOrNotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int checked = 1;
		int pass = Integer.parseInt(request.getParameter("passOrNot"));
		int pk = Integer.parseInt(request.getParameter("videoId"));
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		ClassService classService = new ClassServiceImpl();
		classService.passOrNot(pass, checked, pk, sqlDate);
	
		
		response.sendRedirect("/Myhibernate/backStage/checkedCoursePage");
		
		
		return;
		
	}

}
