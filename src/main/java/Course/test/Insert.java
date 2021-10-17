package Course.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.sql.rowset.serial.SerialClob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Course.model.VideoBean;
import Course.util.HibernateUtils;

public class Insert {

	public static void main(String[] args) {

		VideoBean vb1 = new VideoBean();
		VideoBean vb2 = new VideoBean();
		VideoBean vb3 = new VideoBean();
		VideoBean vb4 = new VideoBean();
		VideoBean vb5 = new VideoBean();
		VideoBean vb6 = new VideoBean();
		List<VideoBean> vb = Arrays.asList(vb1, vb2, vb3, vb4, vb5, vb6);

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String row;
		String[] col;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINESE);

		try (BufferedReader br = new BufferedReader(new FileReader("video.csv"))) {
			int times = 0;
			int i = 0;
			while ((row = br.readLine()) != null) {
				if (times != 0) {
					col = row.split(",");
					vb.get(i).setName(col[1]);
					vb.get(i).setVideoInfo(new SerialClob((col[2]).toCharArray()));
					vb.get(i).setCategory(col[3]);
					vb.get(i).setPartOfBody(col[4]);
					vb.get(i).setTime(format.parse(col[7]));
					vb.get(i).setPrice(Integer.parseInt(col[8]));
					vb.get(i).setCoach(col[9]);
					vb.get(i).setEquipment(col[10]);
					vb.get(i).setLevel(col[11]);
					vb.get(i).setPass(Boolean.parseBoolean(col[12]));
					vb.get(i).setChecked(Boolean.parseBoolean(col[13]));
					i++;
				}
				times++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(VideoBean v : vb) {
			session.persist(v);
		}
		tx.commit();
		session.close();
		factory.close();
		System.out.println("程式結束(Done...!!)");
	}
}
