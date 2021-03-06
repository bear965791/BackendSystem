package Course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.model.PageBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;

@WebServlet("/backStage/notCheckCoursePage")
public class NotCheckPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		String hql = "From VideoBean v WHERE v.checked = 0";
		String curpage = request.getParameter("pageNo");
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		ClassService classService = new ClassServiceImpl();
		// 根據頁面資訊查找商品
		PageBean pageBean = classService.findCourseByPage(currentpage, pagesize, hql);
		// 將商品儲存到request
		request.setAttribute("pageBean", pageBean);
		// 轉發頁面到商品瀏覽頁面
		request.getRequestDispatcher("/course/noCheckCourseList.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
