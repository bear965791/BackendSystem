package Course.dao;

import java.util.List;

import Course.model.VideoBean;

public interface VideoDao {
	public VideoBean findById(int pk);
	public List<VideoBean> getPageCourse();
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void delete(int pk) ;

}
