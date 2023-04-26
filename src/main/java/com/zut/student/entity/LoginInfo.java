package com.zut.student.entity;

public class LoginInfo {
	private String studentId;
	private String passWord;
	private String className;
	private Integer inClass;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getInClass() {
		return inClass;
	}

	public void setInClass(Integer inClass) {
		this.inClass = inClass;
	}

}
