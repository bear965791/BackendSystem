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
//		doPost(request, response);
		ClassService classService = new ClassServiceImpl();
		VideoDao videoDao = new VideoDaoImpl__Hibernate();
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);

		
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		//搜課程分類
		String partOfBody = request.getParameter("partOfBody");
//		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		
		String hql =  videoDao.getBypartOfBodyHql(partOfBody);
		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
		
		request.setAttribute("pageBean", pageBean);
			
		RequestDispatcher rd = request.getRequestDispatcher("/course/noCheckCourseList.jsp");
//		System.out.println(part + " , "+ partOfBody);
		rd.forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);

	}

}
