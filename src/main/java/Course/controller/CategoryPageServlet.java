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
//		
//		//搜審核狀態
//		String status = request.getParameter("status");
//		int num = Integer.parseInt(status.trim());
//		List<VideoBean> passList = classService.findByPass(num);
//		request.setAttribute("product_video", passList);
////		
		//搜課程分類
		String partOfBody = request.getParameter("partOfBody");
		String part = new String(partOfBody.getBytes("ISO-8859-1"), "utf-8");
		System.out.println(part);
		List<VideoBean> partOfBodyList = classService.findBypartOfBody(part);
		request.setAttribute("product_video", partOfBodyList);
	
		RequestDispatcher rd = request.getRequestDispatcher("/course/noCheckCourseList.jsp");
		
		rd.forward(request, response);
		return;

		//跟資料庫的選項對比
		//顯示對比相同的資料
	}

}
