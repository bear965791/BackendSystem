package Course.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Course.dao.VideoDao;
import Course.model.VideoBean;
import Course.ude.RecordNotFoundException;
import Course.util.HibernateUtils;

public class VideoDaoImpl__Hibernate implements VideoDao {
	
	SessionFactory factory;
	
	public VideoDaoImpl__Hibernate()  { 
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	@Override
	public void save(VideoBean vb) {
		Session session = factory.getCurrentSession();
		session.save(vb);
	}

	@Override
	public void update(VideoBean vb) {
//		String hql = "UPDATE VideoBean SET price = price*0.8 WHERE category = :course_category";
		Session session = factory.getCurrentSession();
		//單項更新
		VideoBean vb1 = session.get(VideoBean.class, vb.getVideoId());
		vb.setPrice(vb1.getPrice());
//		VideoBean vb2 = session.get(VideoBean.class, 6);
//		vb2.setChecked(true);
//		vb2.setPass(true);
        session.merge(vb);
//        session.merge(vb2);
        
        //用hql語法條件抓
//        int result;
//        
//        result = session.createQuery(hql)
//        		.setParameter("course_category", "有氧")
//        		.executeUpdate();
//		System.out.println("總共修改" + result + "筆");
	}	
	

	
	@Override
	public void delete(int videoId) {
		Session session = factory.getCurrentSession();
		VideoBean video01 = findById(videoId);
		if (video01 == null ) {
			throw new RecordNotFoundException("要刪除的紀錄不存在: 主鍵值為: " + videoId);
		} else {
			session.delete(video01);  
		}
	}

	
	@Override
	public VideoBean findById(int videoId) {
		VideoBean video = null;
		Session session = factory.getCurrentSession();
		Integer videopk = Integer.valueOf(videoId);
		video = (VideoBean) session.get(VideoBean.class, videopk);
		return video;
	}
	

	
	@Override
	public List<VideoBean> getPageCourse() {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = new ArrayList<VideoBean>();
		String hql = "FROM VideoBean";
		list = session.createQuery(hql, VideoBean.class)
					.getResultList();
		return list;
	}


}
