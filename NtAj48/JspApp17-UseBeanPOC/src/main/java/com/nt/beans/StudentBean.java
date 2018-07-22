package com.nt.beans;

public class StudentBean {
	private int sno;
	private String sname;
	private float avg;
	public StudentBean() {
		System.out.println("StudentBean::0-param constructor");
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}

}
