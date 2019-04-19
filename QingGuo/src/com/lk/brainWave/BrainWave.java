package com.lk.brainWave;

import java.util.Date;

public class BrainWave {

	private int attention;
	private int tied;
	private int mediton;
	private Date time;
	private int id;
	
	public BrainWave() {
		super();
	}

	public BrainWave(int attention, int tied, int mediton, Date time, int id) {
		super();
		this.attention = attention;
		this.tied = tied;
		this.mediton = mediton;
		this.time = time;
		this.id = id;
	}

	public int getAttention() {
		return attention;
	}

	public void setAttention(int attention) {
		this.attention = attention;
	}

	public int getTied() {
		return tied;
	}

	public void setTied(int tied) {
		this.tied = tied;
	}

	public int getMediton() {
		return mediton;
	}

	public void setMediton(int mediton) {
		this.mediton = mediton;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
