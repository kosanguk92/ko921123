package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

/*
 * vo value Object
 * DTO Data Transfer Object
 * DO Domain Object
 * Entity
 * bean
 * 
 * VO클래스의 조건
 * 1. 모든 필드는 반드시 캡슐화 적용된 private사용
 * 2. 필드에 대해 getter/setter 작성 필수
 * 3. 기본생성자/파라미터생성자 작성 필수
 * 4. 직렬화 처리(Serializable 인터페이스 구현 , versionUID 작성)
 * 
 * */
public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private String password;
	private String memberName;
	private String memberRole;
	private String gender;
	private Date birthDay;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	public Member(String memberId, String password, String memberName, String memberRole, String gender, Date birthDay,
			String email, String phone, String address, String hobby, Date enrollDate) {
		super();
		
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.memberRole = memberRole;
		this.gender = gender;
		this.birthDay = birthDay;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", memberName=" + memberName
				+ ", memberRole=" + memberRole + ", gender=" + gender + ", birthDay=" + birthDay + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}
	
}
