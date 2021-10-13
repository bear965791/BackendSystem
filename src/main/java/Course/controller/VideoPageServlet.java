package Course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.model.VideoBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;


@WebServlet("/backStage/CoursePage")
public class VideoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ClassService classService = new ClassServiceImpl();
		
		List<VideoBean> videoList = classService.getPageCourse();
	
		request.setAttribute("product_video", videoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/course/notcheckList.jsp");
		
		rd.forward(request, response);
		return;
	
	}
	



}