package member.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.CoachService;
import member.service.Impl.CoachServiceImpl;


@WebServlet("/Member/checkingCoachDetal")
public class PassOrNotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checked = "1";
		String pass = request.getParameter("passOrNot");
		int id = Integer.parseInt(request.getParameter("coachId"));
		Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        CoachService coachService = new CoachServiceImpl();
        coachService.passOrNot(pass, checked, id, timestamp);
	
		
		response.sendRedirect("/Myhibernate/Member/CoachListPage");
		
		
		return;
		
	}

}
