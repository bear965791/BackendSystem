package Course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.model.PageBean;
import Course.model.VideoBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;

@WebServlet("/Course/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassService classService = new ClassServiceImpl();
		//輸入字串
		String inputValue = request.getParameter("inputValue");
		String textValue = new String(inputValue.getBytes("ISO-8859-1"), "utf-8");
		List<VideoBean> text = classService.search(textValue);
		PageBean textBean =  new PageBean();
		textBean.setVideoBean(text);
		request.setAttribute("pageBean", textBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/course/noCheckCourseList.jsp");
		
		rd.forward(request, response);
		return;
	}

}
