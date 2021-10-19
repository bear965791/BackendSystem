package Course.service.Impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.dao.VideoDao;
import Course.dao.Impl.VideoDaoImpl__Hibernate;
import Course.model.PageBean;
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
//
//	@Override
//	public List<Object> findBypartOfBody(String partOfBody) {
//		Session session = factory.getCurrentSession();
//		List<Object> list = null;
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = videoDao.findBypartOfBody(partOfBody);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//				e.printStackTrace();
//				throw new RuntimeException(e);				
//			}
//		}
//		return list;
//	}
	
	@Override
	public List<VideoBean> findBypartOfBody(String partOfBody) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = videoDao.findBypartOfBody(partOfBody);
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



//	
//	@Override
//	public List<VideoBean> findByPassAndPartOfBody(String partOfBody, int num) {
//		Session session = factory.getCurrentSession();
//		List<VideoBean> list = null;
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			list = videoDao.findByPassAndPartOfBody(partOfBody,num);
//			tx.commit();
//		}catch(Exception e) {
//			if(tx != null) {
//				tx.rollback();
//				e.printStackTrace();
//				throw new RuntimeException(e);				
//			}
//		}
//		return list;
//	}
	
	@Override
	 public PageBean findCourseByPage(int currentPage, int pageSize, String hql) {
	  long count; 
	  int totalpage;
	  Session session = factory.getCurrentSession();
	  PageBean pageBean = new PageBean();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   // 返回資料庫中的商品總數
	   count = (long) videoDao.getCountsAndPage(pageSize, hql).get(0);
	   // 計算總頁數
	   totalpage = (int) videoDao.getCountsAndPage(pageSize, hql).get(1);
	   
	   // 查詢到的當前頁面要顯示的商品
	   List<VideoBean> course = videoDao.findVideoByPage(currentPage, pageSize, hql);

	   pageBean.setCourseCount(count);
	   pageBean.setVideoBean(course);
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
	public void passOrNot(int pass, int checked, int pk,Date sqlDate) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			VideoBean vb = videoDao.findById(pk);
			vb.setPass(pass);
			vb.setChecked(checked);
			vb.setChecktime(sqlDate);
			videoDao.updatPassAndChecked(vb);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}


	@Override
	public List<VideoBean> search(String inputValue) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = videoDao.findByInputValue(inputValue);
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
	
//	@Override
//	 public PageBean findCourseByPage(List<VideoBean> list, int currentPage, int pageSize) {
//	  long count; 
//	  int totalpage;
//	  Session session = factory.getCurrentSession();
//	  PageBean pageBean = new PageBean();
//	  Transaction tx = null;
//	  try {
//	   tx = session.beginTransaction();
//	   // 返回資料庫中的商品總數
//	   count = (long) videoDao.getCountsAndPage(pageSize, hql).get(0);
//	   // 計算總頁數
//	   totalpage = (int) videoDao.getCountsAndPage(pageSize, hql).get(1);
//	   
//	   // 查詢到的當前頁面要顯示的商品
//	   List<VideoBean> course = videoDao.findVideoByPage(currentPage, pageSize, hql);
//
//	   pageBean.setCourseCount(count);
//	   pageBean.setVideoBean(course);
//	   pageBean.setCurrentPage(currentPage);
//	   pageBean.setTotalPage(totalpage);
//
//	   tx.commit();
//
//	  } catch (Exception e) {
//	   if (tx != null) {
//	    tx.rollback();
//	    e.printStackTrace();
//	    throw new RuntimeException(e);
//	   }
//	  }
//	  return pageBean;
//	 }
}
