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
	VideoDao videoDao;

	
	public ClassServiceImpl() {
		factory = HibernateUtils.getSessionFactory();
		videoDao = new VideoDaoImpl__Hibernate();
	}

	
	@Override
	public VideoBean findById(int pk) {
		Session session = factory.getCurrentSession();
		VideoBean bean = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = videoDao.findById(pk);
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
			list = videoDao.getPageCourse();
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
			videoDao.delete(pk);
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


	@Override
	public void save(VideoBean vb) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			videoDao.save(vb);
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


	@Override
	public void update(VideoBean mem) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			videoDao.save(mem);
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
