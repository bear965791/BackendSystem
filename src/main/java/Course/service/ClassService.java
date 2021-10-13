package Course.service;

import java.util.List;

import Course.model.VideoBean;

public interface ClassService {
	public VideoBean findById(int pk);
	public List<VideoBean> getPageCourse();
	void delete(int pk) ;
	public void save(VideoBean vb);
	public void update(VideoBean mem);

}
