package com.task.app;

import java.sql.Timestamp;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class ParentTask {
	@Id
	public int ptaskId;
	public String ptaskName;
	
	public ParentTask(int ptaskId, String ptaskName) {
		super();
		this.ptaskId = ptaskId;
		this.ptaskName = ptaskName;
	}
	
	public int getPtaskId() {
		return ptaskId;
	}
	public void setPtaskId(int ptaskId) {
		this.ptaskId = ptaskId;
	}
	public String getPtaskName() {
		return ptaskName;
	}
	public void setPtaskName(String ptaskName) {
		this.ptaskName = ptaskName;
	}
	
}
