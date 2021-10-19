package Course.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.dao.VideoDao;
import Course.dao.Impl.VideoDaoImpl__Hibernate;
import Course.model.PageBean;
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
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		//傳入挑選的選項去搜尋
		ClassService classService = new ClassServiceImpl();	
		VideoDao videoDao = new VideoDaoImpl__Hibernate();
		

		String status = request.getParameter("status");
		String partOfBody = request.getParameter("partOfBody");
		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		String hql =  videoDao.getSelectHql(part, status);
		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
		
//		
//		List<VideoBean> partOfBodyList = classService.findByPassAndPartOfBody(part,num);
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
