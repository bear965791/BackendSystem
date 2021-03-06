package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.model.PageBean;
import member.dao.MemberDao;
import member.dao.Impl.MemberDaoImpl_Hibernate;
import member.service.MemberService;
import member.service.Impl.MemberServiceImpl;

@WebServlet("/Member/SearchPageServlet")
public class SearchPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberDao memberDao = new MemberDaoImpl_Hibernate();
		MemberService memberService = new MemberServiceImpl();
		
		int currentpage = 1;// 默認的當前頁
		int pagesize = 5;// 每頁顯示的商品數
		
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
		
		String curpage = request.getParameter("pageNo");
		// 為當前頁賦值
		if (!"".equals(curpage) && curpage != null) {
			currentpage = Integer.parseInt(curpage);
		}
		
		String inputValue = request.getParameter("inputValue");
		String checked = request.getParameter("checked");
		
		if(checked.equals("1")){
			String hql =  memberDao.getByInputValueHql(inputValue);
			PageBean pageBean = memberService.findMemberByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberBackend.jsp");
			rd.forward(request, response);
			
		}else {
			String hql =  memberDao.getByInputValueHql(inputValue);
			PageBean pageBean = memberService.findMemberByPage(currentpage, pagesize, hql);
			request.setAttribute("pageBean", pageBean);
			RequestDispatcher rd = request.getRequestDispatcher("/member/checkingCoachingList.jsp");
			rd.forward(request, response);
		}
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
