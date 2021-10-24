package member.model;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Member")
public class MemberBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberId;
	private String memberPassword;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private Date birthday;
	private String role;
	private Blob memberPicture;
	private Timestamp registerTime;
	private Blob memberImage;
	
	@OneToOne(cascade =CascadeType.PERSIST)
	@JoinColumn
	CoachBean coach;
	

	public MemberBean(Integer memberId, String memberPassword, String name, String email, String phone, String gender,
			Date birthday, String role, Blob memberPicture, Timestamp registerTime, Blob memberImage, CoachBean coach) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.role = role;
		this.memberPicture = memberPicture;
		this.registerTime = registerTime;
		this.memberImage = memberImage;
		this.coach = coach;
	}



	public MemberBean() {
		
	}



	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getMemberPassword() {
		return memberPassword;
	}


	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Blob getMemberPicture() {
		return memberPicture;
	}


	public void setMemberPicture(Blob memberPicture) {
		this.memberPicture = memberPicture;
	}


	public Timestamp getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	

	public CoachBean getCoach() {
		return coach;
	}


	public void setCoach(CoachBean coach) {
		this.coach = coach;
	}



	public Blob getMemberImage() {
		return memberImage;
	}



	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	
	
	
}
