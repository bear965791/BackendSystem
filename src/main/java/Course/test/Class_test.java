package Course.test;

import java.util.List;

import Course.dao.VideoDao;
import Course.dao.Impl.VideoDaoImpl__Hibernate;
import Course.model.VideoBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;

public class Class_test {

	public static void main(String[] args) {
		
		ClassService classService = new ClassServiceImpl();
		
//		List<VideoBean> list = classService.search("4");
//		System.out.println(list);
//		for(VideoBean bean : list) {
//			System.out.println(bean.getName());
//		}
		
		
		
		List<VideoBean> list = classService.findByPassAndPartOfBody("全身",1);
		System.out.println(list);
		for(VideoBean bean : list) {
			System.out.println(bean.getCoach());
		}
		
		
		
		
//		List<VideoBean> list = classService.findBypartOfBody("二頭");	
//		System.out.println(list);
//		
//		for(VideoBean bean : list) {
//			System.out.println(bean.getCoach());
//		}
		
//		int num =1;
//		List<VideoBean> list = classService.findByPass(1);	
//		System.out.println(list);
//		for(VideoBean bean : list) {
//			System.out.println(bean.getCoach());
//		}
		
		
		
//		VideoBean emp = classService.findById(1);
//		System.out.println(emp.getName()); 
//		
//		List<VideoBean> list = classService.getPageCourse();	
//		for(VideoBean bean : list) {
//			System.out.println(bean.getCoach());
//		}
//		
	}
}
