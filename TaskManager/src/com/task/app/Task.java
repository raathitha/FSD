package com.task.app;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
	@Id
	@XmlElement
	public int taskId;
	@XmlElement
	public String taskName;
	@XmlElement
	public String parentTask;
	@XmlElement
	public int priority;
	@XmlElement
	public String startDate;
	@XmlElement
	public String endDate;
	Task(){
		
	}
	public Task(int taskId, String taskName,String parentTask,int priority,String startDate,String endDate) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.parentTask = parentTask;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String toString(){
		return "Task [taskid=" + taskId + ", taskname=" + taskName + ", parentTask=" + parentTask + ", startDate=" + startDate + ", endDate=" + endDate +", priority=" + priority +"]";
	}
}
