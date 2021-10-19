package Course.dao;

import java.util.List;

import Course.model.VideoBean;



public interface VideoDao {
	public VideoBean findById(int pk);
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void delete(int pk) ;
//
	public void updatPassAndChecked(VideoBean vb);
	List<? super Integer> getCountsAndPage(int pageSize, String hql);
	//根據頁面查詢商品
	public List<VideoBean> findVideoByPage(int currentpage, int pagesize, String hql);
	public List<VideoBean> findVideoByPage(List<VideoBean> list,int currentPage, int pageSize);
	public List<VideoBean> findByInputValue(String inputValue);
	public List<VideoBean> findBypartOfBody(String partOfBody);
	public List<VideoBean> findByPassAndPartOfBody(String partOfBody, int num);
	public String getSelectHql(String partOfBody, String num);
	
	
//	public List<Object> findBypartOfBody(String partOfBody);
	
}
