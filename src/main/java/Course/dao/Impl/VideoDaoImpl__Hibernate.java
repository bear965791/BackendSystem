package Course.dao.Impl;

import java.util.ArrayList;
import java.util.Arrays;
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
		Session session = factory.getCurrentSession();
		//單項更新
		VideoBean vb1 = session.get(VideoBean.class, vb.getVideoId());
		vb.setPrice(vb1.getPrice());
        session.merge(vb);
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
	public List<Object> findBypartOfBody(String partOfBody) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = new ArrayList<VideoBean>();
		List<Object> list2  =  new ArrayList<>();
		
		switch(partOfBody){
			case "0" :
				String hql1 = "FROM VideoBean WHERE checked = 0";
				list = session.createQuery(hql1, VideoBean.class)
							.getResultList();
				list2.add(hql1);
				list2.add(list);
				break;
			default:
				String parameter = partOfBody;
				String hql2 = "FROM VideoBean WHERE checked = 0 and partOfBody = " +parameter;
				
				list = session.createQuery(hql2, VideoBean.class).getResultList();
				list2.add(hql2);
				list2.add(list);
		}
		return list2;
	}


	@Override
	public  List<Object> findByPassAndPartOfBody(String partOfBody, String num) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = new ArrayList<VideoBean>();
		List<Object> list2  =  new ArrayList<>();

		System.out.println(partOfBody+num);
	
		if(num.equals("2")) {
			
			if(partOfBody.equals("0")) {
				String hql = "FROM VideoBean WHERE checked = 1";
				list = session.createQuery(hql, VideoBean.class)
							.getResultList();
				list2.add(hql);
				list2.add(list);
				
			}else {
				  String parameter = partOfBody;
				  String hql = "FROM VideoBean WHERE checked = 1 AND partOfBody = " + parameter;
				     list = session.createQuery(hql, VideoBean.class).getResultList();
				
				list2.add(hql);
				list2.add(list);
			}
			
		}else if(partOfBody.equals("0")){
			 String parameter = num;
			String hql = "FROM VideoBean WHERE checked = 1 AND  pass = " +parameter;
			list = session.createQuery(hql, VideoBean.class).getResultList();
			list2.add(hql);
			list2.add(list);
			
		}else {
			String parameter = num;
			String hql = "FROM VideoBean WHERE checked = 1 AND partOfBody = :partOfBody AND pass =" +parameter;
			list = session.createQuery(hql, VideoBean.class)
						  .setParameter("num", num)
						.getResultList();
			list2.add(hql);
			list2.add(list);
			
		}
		return list2;
	}
	
	
	@Override
	 public List<? super Integer> getCountsAndPage(int pageSize, String hql) {
	  int totalPages = 0;
	  long count = 0; 
	  List<? super Integer> pageInfo;
	  String countHql = "SELECT count(*) " + hql;
	  
	  Session session = factory.getCurrentSession();

	  List<Long> list = session.createQuery(countHql, Long.class).getResultList();
	  
	  if (list.size() > 0) {
	   count = list.get(0);
	  }
	  
	  totalPages = (int) (Math.ceil(count) / (double) pageSize);
	  
	  pageInfo = Arrays.asList(count,totalPages);
	  
	  return pageInfo;
	 }

	@Override
	public List<VideoBean> findVideoByPage(int currentPage, int pageSize, String hql) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = session.createQuery(hql, VideoBean.class).setFirstResult( (currentPage - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();	
		return list;
	}


	@Override
	public void updatPassAndChecked(VideoBean vb) {
		
		Session session = factory.getCurrentSession();
		VideoBean vb0 = session.get(VideoBean.class, vb.getVideoId());

		vb.setPass(vb0.getPass());
		vb.setChecked(vb0.getChecked());
		session.evict(vb0);
		session.merge(vb);
	}


	


	@Override
	public List<VideoBean> findByInputValue(String inputValue) {
		Session session = factory.getCurrentSession();
		List<VideoBean> list = new ArrayList<VideoBean>();
		String hql = "FROM VideoBean WHERE name LIKE :inputValue OR videoId LIKE :inputValue";
		list = session.createQuery(hql, VideoBean.class)
					  .setParameter("inputValue", "%"+inputValue+"%")
					  .setParameter("inputValue", "%"+Integer.parseInt(inputValue)+"%")
					  .getResultList();
		return list;
	}




}
