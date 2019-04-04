package com.lk.entity;

import java.util.Date;

public class Things_record {

	private int re_id;
	private String re_name;
	private Date re_time;
	
	public Things_record() {
		super();
	}

	
	
	public Things_record(int re_id, String re_name, Date re_time) {
		super();
		this.re_id = re_id;
		this.re_name = re_name;
		this.re_time = re_time;
	}



	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public Date getRe_time() {
		return re_time;
	}

	public void setRe_time(Date re_time) {
		this.re_time = re_time;
	}
	
	
	
}
