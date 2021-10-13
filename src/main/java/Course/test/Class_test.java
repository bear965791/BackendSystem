package Course.test;

import Course.model.VideoBean;
import Course.service.ClassService;
import Course.service.Impl.ClassServiceImpl;

public class Class_test {

	public static void main(String[] args) {
		
		ClassService classService = new ClassServiceImpl();
		
		VideoBean emp = classService.findById(1);
		System.out.println(emp.getName()); 
		
//		List<VideoBean> list = classService.getPageCourse();	
//		for(VideoBean bean : list) {
//			System.out.println(bean.getCoach());
//		}
//		
	}
}
