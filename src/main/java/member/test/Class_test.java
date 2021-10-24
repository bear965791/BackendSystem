package member.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.util.HibernateUtils;
import member.model.MemberBean;

public class Class_test {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("查找教練:");
		MemberBean p = session.get(MemberBean.class, 1);
        if ( p != null) {
        	System.out.println("教練:" + p.getCoach().getExperience());
        } else {
        	System.out.println("查無此筆資料");
        }
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
//	}
		
		
		
		
		
//		MemberService memberService = new MemberServiceImpl();
//		CoachService coachServie = new CoachServiceImpl();
//		
//		MemberBean bean= memberService.findById(1);
//		System.out.println(bean);
//		CoachBean coachBean = coachServie.findByFk(1);
//		
//		System.out.println(coachBean.getCheckTime());
//		
//		
//		
		
//		ClassService classService = new ClassServiceImpl();

//		SELECT * FROM VideoBean WHERE NAME LIKE '%4%' OR videoId LIKE "%4%";
//		'%4%'
//		"%inputValue%"
//		String inputValue = "2";
//		inputValue = "'"+"%"+inputValue+"%"+"'";
//		
//		System.out.println(inputValue);
//		List<VideoBean> list = classService.search("4");
//		System.out.println(list);
//		for(VideoBean bean : list) {
//			System.out.println(bean.getName());
//		}
		
		
//		
//		List<VideoBean> list = classService.findByPassAndPartOfBody("全身",1);
//		System.out.println(list);
//		for(VideoBean bean : list) {
//			System.out.println(bean.getCoach());
//		}
//		
		
		
		
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
