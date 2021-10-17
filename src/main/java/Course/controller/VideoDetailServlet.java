package Course.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.model.VideoBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;


@WebServlet("/course/CheckingVideoDetail.do")
public class VideoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String videoId = request.getParameter("videoId");
		int id= Integer.parseInt(videoId.trim());
		
		ClassService classService = new ClassServiceImpl();
		VideoBean videoBean = classService.findById(id);
	
		request.setAttribute("VideoBean",videoBean);
		
		if(videoBean.getChecked() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/course/checkingCourseDetail.jsp");	
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/course/checkedCourseDetail.jsp");
			rd.forward(request, response);
		}
		return;
	
	}

}
