package Course.service;

import java.util.List;

import Course.model.VideoBean;

public interface ClassService {
	public VideoBean findById(int pk);
	public List<VideoBean> getNoCheckPageCourse();
	public List<VideoBean> getCheckedPageCourse();
	void delete(int pk) ;
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public List<VideoBean> findByPass(int num);
	public List<VideoBean> findBypartOfBody(String partOfBody);
}
