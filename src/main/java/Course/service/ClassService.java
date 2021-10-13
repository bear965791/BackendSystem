package Course.service;

import java.util.List;

import Course.model.VideoBean;

public interface ClassService {
	public VideoBean findById(int pk);
	public List<VideoBean> getPageCourse();
	void delete(int pk) ;

}
