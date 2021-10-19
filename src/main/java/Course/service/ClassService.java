package Course.service;

import java.sql.Date;

import Course.model.PageBean;
import Course.model.VideoBean;

public interface ClassService {
	public VideoBean findById(int pk);
	void delete(int pk) ;
	public void save(VideoBean vb);
	public void update(VideoBean mem);
	public void passOrNot(int pass, int checked, int pk,Date sqlDate);
	public PageBean findCourseByPage(int currentPage, int pageSize, String hql);
}
