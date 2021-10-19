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
@WebServlet("/Course/CategoryPage.do")
public class CategoryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//傳入挑選的選項去搜尋
		ClassService classService = new ClassServiceImpl();
		VideoDao videoDao = new VideoDaoImpl__Hibernate();
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		//搜課程分類
		String partOfBody = request.getParameter("body");
		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		
		String hql =  videoDao.getBypartOfBodyHql(part);
		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
		
		request.setAttribute("pageBean", pageBean);
			
		RequestDispatcher rd = request.getRequestDispatcher("/course/noCheckCourseList.jsp");
		
		rd.forward(request, response);
		return;

	}

}
