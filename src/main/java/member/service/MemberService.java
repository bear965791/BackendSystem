package member.service;

import java.sql.Timestamp;

import Course.model.PageBean;
import member.model.CoachBean;
import member.model.MemberBean;

public interface MemberService {
	public PageBean findMemberByPage(int currentPage, int pageSize, String hql);
	
	public MemberBean findById(int id);
	
	public CoachBean findCoachByFk(int fk);
	
	

}
