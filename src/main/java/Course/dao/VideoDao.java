package Course.dao;

import java.util.List;

import Course.model.VideoBean;

public interface VideoDao {
	public VideoBean findById(int pk);
	public List<VideoBean> getNoCheckPageCourse();
	public List<VideoBean> getCheckedPageCourse();
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void delete(int pk) ;
	public List<VideoBean> findByPass(int num);
	public List<VideoBean> findBypartOfBody(String partOfBody);
	
}
