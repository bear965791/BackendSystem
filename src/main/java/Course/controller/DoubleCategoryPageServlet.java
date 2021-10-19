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


//查詢功能
@WebServlet("/Course/DoubleCategoryPage.do")
public class DoubleCategoryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//傳入挑選的選項去搜尋
		ClassService classService = new ClassServiceImpl();	

		String status = request.getParameter("status");
		int num = Integer.parseInt(status);
		String partOfBody = request.getParameter("partOfBody");
		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		List<VideoBean> partOfBodyList = classService.findByPassAndPartOfBody(part,num);
		PageBean pageBean =  new PageBean();
		pageBean.setVideoBean(partOfBodyList);
//		
//		List<Object> passList = classService.findByPassAndPartOfBody(part,status);
//		PageBean pageBean =  new PageBean();
//		pageBean.setVideoBean(passList);
		
		request.setAttribute("pageBean", pageBean);
		
		
		//輸入字串
//		String partOfBody = request.getParameter("partOfBody");
		
		RequestDispatcher rd = request.getRequestDispatcher("/course/courseList.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("/backStage/checkedCoursePage");
		rd.forward(request, response);
		return;

	}

}
