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
@WebServlet("/Course/CategoryPage.do")
public class CategoryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//傳入挑選的選項去搜尋
		ClassService classService = new ClassServiceImpl();
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		//搜課程分類
		String partOfBody = request.getParameter("body");
		
		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		List<VideoBean> partOfBodyList = classService.findBypartOfBody(part);
		
		
		PageBean pageBean =  new PageBean();
		pageBean.setVideoBean(partOfBodyList);
		
//		List<Object> partOfBodyList = classService.findBypartOfBody(part);
//		String hql = (String) partOfBodyList.get(0);
//		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
//		
		request.setAttribute("pageBean", pageBean);
			
		RequestDispatcher rd = request.getRequestDispatcher("/course/noCheckCourseList.jsp");
		
		rd.forward(request, response);
		return;

	}

}
