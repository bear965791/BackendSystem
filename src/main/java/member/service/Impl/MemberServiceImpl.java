package member.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.dao.VideoDao;
import Course.model.PageBean;
import Course.util.HibernateUtils;
import member.dao.MemberDao;
import member.dao.Impl.MemberDaoImpl_Hibernate;
import member.model.CoachBean;
import member.model.MemberBean;
import member.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	SessionFactory factory;
	MemberDao memberDao;
	VideoDao videoDao;
	
	public MemberServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		memberDao = new MemberDaoImpl_Hibernate();
	}


	@Override
	public PageBean findMemberByPage(int currentPage, int pageSize, String hql) {
		 long count; 
		  int totalpage;
		  Session session = factory.getCurrentSession();
		  PageBean pageBean = new PageBean();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   // 返回資料庫中的商品總數
		   count = (long) memberDao.getCountsAndPage(pageSize, hql).get(0);
		   // 計算總頁數
		   totalpage = (int) memberDao.getCountsAndPage(pageSize, hql).get(1);
		   
		   // 查詢到的當前頁面要顯示的商品
		   List<MemberBean> course = memberDao.findMemberByPage(currentPage, pageSize, hql);

		   pageBean.setCourseCount(count);
		   pageBean.setMemberBean(course);
		   pageBean.setCurrentPage(currentPage);
		   pageBean.setTotalPage(totalpage);

		   tx.commit();

		  } catch (Exception e) {
		   if (tx != null) {
		    tx.rollback();
		    e.printStackTrace();
		    throw new RuntimeException(e);
		   }
		  }
		  return pageBean;
	}


	@Override
	public  MemberBean findById(int id) {
		Session session = factory.getCurrentSession();
		MemberBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = memberDao.findById(id);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return bean;
	}


	@Override
	public CoachBean findCoachByFk(int fk) {
		Session session = factory.getCurrentSession();
		CoachBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = memberDao.findCoachByFk(fk);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return bean;
	}
	
	

}
