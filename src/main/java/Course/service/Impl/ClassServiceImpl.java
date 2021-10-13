package Course.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.dao.VideoDao;
import Course.dao.Impl.VideoDaoImpl__Hibernate;
import Course.model.VideoBean;
import Course.service.ClassService;
import Course.util.HibernateUtils;

public class ClassServiceImpl implements ClassService {
	
	SessionFactory factory;
	VideoDao classDao;

	
	public ClassServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		classDao = new VideoDaoImpl__Hibernate();
	}

	
	@Override
	public VideoBean findById(int pk) {
		Session session = factory.getCurrentSession();
		VideoBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = classDao.findById(pk);
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
	public List<VideoBean> getPageCourse() {
		
		Session session = factory.getCurrentSession();
		List<VideoBean> list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = classDao.getPageCourse();
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return list;
	}

	@Override
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			classDao.delete(pk);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);				
			}
		}
		return;
		
	}
	

}
