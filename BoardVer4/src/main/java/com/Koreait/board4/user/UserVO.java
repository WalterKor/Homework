package com.Koreait.board4.user;

public class UserVO {//레코드 하나를 저장할 수 있는것
	private int iuser;
	private String uid;
	private String upw;
	private String unm;
	private int gender;
	private String regdt;
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	
	
}
