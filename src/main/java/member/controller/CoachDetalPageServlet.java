package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.CoachBean;
import member.service.MemberService;
import member.service.Impl.MemberServiceImpl;


@WebServlet("/CoachDetalPageServlet")
public class CoachDetalPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService memberService = new MemberServiceImpl();
		
		String memberId = request.getParameter("memberId");
		
		CoachBean coachBean = memberService.findCoachByFk(Integer.parseInt(memberId));

		request.setAttribute("CoachBean",coachBean);
		
		if(coachBean.getChecked().equals("0")) {
			RequestDispatcher rd = request.getRequestDispatcher("/member/checkingCoachingDetail.jsp");	
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/member/checkedCoachingDetail.jsp");
			rd.forward(request, response);
		}
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
