package com.lzw.monitor.model;

import java.io.Serializable;
import java.util.Date;

public class LogbackRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String accessJnlId;
	private String methodName;
	private String serviceType;
	private Date startTime;
	private Date endTime;
	private Integer duration;
	private String server;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessJnlId() {
		return accessJnlId;
	}

	public void setAccessJnlId(String accessJnlId) {
		this.accessJnlId = accessJnlId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
}