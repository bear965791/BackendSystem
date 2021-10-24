package member.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.sql.rowset.serial.SerialClob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.model.VideoBean;
import Course.util.HibernateUtils;
import member.model.CoachBean;
import member.model.MemberBean;

public class Insert {

	public static void main(String[] args) {

		List<MemberBean> mbList = new ArrayList<>();
		MemberBean mb;
		
		List<CoachBean> cbList = new ArrayList<>();
		CoachBean cb;
		

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String row;
		String[] col;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINESE);

		try {
			
			try (BufferedReader br = new BufferedReader(new FileReader("member.csv"))) {
				int times = 0;
				while ((row = br.readLine()) != null) {
					if (times != 0) {
						mb = new MemberBean();
						col = row.split(",");
						mb.setMemberPassword(col[1]);
						mb.setName(col[2]);
						mb.setEmail(col[3]);
						mb.setPhone(col[4]);
						mb.setGender(col[5]);
						mb.setBirthday(new Date(format.parse(col[6]).getTime()));
						mb.setRole(col[7]);
						mb.setRegisterTime(new java.sql.Timestamp(System.currentTimeMillis()));
					
						mbList.add(mb);
					}
					times++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(MemberBean m : mbList) {
				session.persist(m);
			}
			
//			
			try (BufferedReader br = new BufferedReader(new FileReader("coach.csv"))) {
				int times = 0;
				while ((row = br.readLine()) != null) {
					if (times != 0) {
						cb = new CoachBean();
						col = row.split(",");
						int memberId = Integer.parseInt(col[0]);
						MemberBean memberBean = session.get(MemberBean.class, memberId);
						cb.setMember(memberBean);
						cb.setChecked(col[1]);
						cb.setPass(col[2]);
						cb.setExperience(col[3]);
						cb.setSkill(col[5]);
						cb.setCoachInfo(new SerialClob((col[7]).toCharArray()));
						cb.setAccount(col[9]);
						cb.setApplyTime(new java.sql.Timestamp(System.currentTimeMillis()));
						cbList.add(cb);
					}
					times++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
//		
			for(CoachBean c : cbList) {
				session.persist(c);
			}
			tx.commit();
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		} 
		
		session.close();
		factory.close();
		System.out.println("程式結束(Done...!!)");
	}
}
