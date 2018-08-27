package com.csl.demo.entity;

import java.util.Date;


@SuppressWarnings("serial")
public class LearnPlan implements java.io.Serializable {

	// Fields

	private String uuid;
	private Date startTime;
	private Date endTime;
	private String contents;
	private String memo;
	private String planner;
	private String plannerId;

	// Constructors

	/** default constructor */
	public LearnPlan() {
	}

	/** minimal constructor */
	public LearnPlan(String uuid, Date startTime, String contents,
			String planner, String plannerId) {
		this.uuid = uuid;
		this.startTime = startTime;
		this.contents = contents;
		this.planner = planner;
		this.plannerId = plannerId;
	}

	/** full constructor */
	public LearnPlan(String uuid, Date startTime, Date endTime,
			String contents, String memo, String planner, String plannerId) {
		this.uuid = uuid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.contents = contents;
		this.memo = memo;
		this.planner = planner;
		this.plannerId = plannerId;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPlanner() {
		return this.planner;
	}

	public void setPlanner(String planner) {
		this.planner = planner;
	}

	public String getPlannerId() {
		return this.plannerId;
	}

	public void setPlannerId(String plannerId) {
		this.plannerId = plannerId;
	}

	@Override
	public String toString() {
		return "Learnplan [uuid=" + uuid + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", contents=" + contents + ", memo="
				+ memo + ", planner=" + planner + ", plannerId=" + plannerId
				+ "]";
	}
	
}