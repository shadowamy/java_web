package com.lk.entity;

public class Allthings_list {

	private int th_id;
	private String th_name;
	private int th_count;
	
	public Allthings_list(int th_id, String th_name, int th_count) {
		super();
		this.th_id = th_id;
		this.th_name = th_name;
		this.th_count = th_count;
	}

	public Allthings_list() {
		super();
	}

	public int getTh_id() {
		return th_id;
	}

	public void setTh_id(int th_id) {
		this.th_id = th_id;
	}

	public String getTh_name() {
		return th_name;
	}

	public void setTh_name(String th_name) {
		this.th_name = th_name;
	}

	public int getTh_count() {
		return th_count;
	}

	public void setTh_count(int th_count) {
		this.th_count = th_count;
	}
	
	
	
}
