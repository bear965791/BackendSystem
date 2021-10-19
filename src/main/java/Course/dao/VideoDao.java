package Course.dao;

import java.util.List;

import Course.model.VideoBean;



public interface VideoDao {
	public VideoBean findById(int pk);
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void delete(int pk) ;
	public List<Object> findBypartOfBody(String partOfBody);
	public List<Object> findByPassAndPartOfBody(String partOfBody, String num);
	public void updatPassAndChecked(VideoBean vb);
	List<? super Integer> getCountsAndPage(int pageSize, String hql);
	//根據頁面查詢商品
	public List<VideoBean> findVideoByPage(int currentpage, int pagesize, String hql);
	public List<VideoBean> findByInputValue(String inputValue);
	
}
