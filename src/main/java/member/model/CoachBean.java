package member.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Coach")
public class CoachBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String experience;
	private Blob certification;
	private String skill;
	private Blob coachImage;
	private Clob coachInfo;
	private String account;
	private String pass; 
	private	String checked; 
	private Timestamp checkTime;
	private Timestamp applyTime;
	private String suspension;
	

	@OneToOne(mappedBy = "coach")
	MemberBean member;
	
	public CoachBean(Integer id, String experience, Blob certification, String skill, Blob coachImage, Clob coachInfo,
			String account, String pass, String checked, Timestamp checkTime, Timestamp applyTime, String suspension,
			MemberBean member) {
		super();
		this.id = id;
		this.experience = experience;
		this.certification = certification;
		this.skill = skill;
		this.coachImage = coachImage;
		this.coachInfo = coachInfo;
		this.account = account;
		this.pass = pass;
		this.checked = checked;
		this.checkTime = checkTime;
		this.applyTime = applyTime;
		this.suspension = suspension;
		this.member = member;
	}


	public CoachBean() {
		
	}


	public Integer getId() {
		return id;
	}

	public void seId(Integer id) {
		this.id = id;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Blob getCertification() {
		return certification;
	}

	public void setCertification(Blob certification) {
		this.certification = certification;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Blob getCoachImage() {
		return coachImage;
	}

	public void setCoachImage(Blob coachImage) {
		this.coachImage = coachImage;
	}

	public Clob getCoachInfo() {
		return coachInfo;
	}

	public void setCoachInfo(Clob coachInfo) {
		this.coachInfo = coachInfo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public String getSuspension() {
		return suspension;
	}

	public void setSuspension(String suspension) {
		this.suspension = suspension;
	}
	
	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}


	
}
