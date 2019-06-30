package com.lzw.monitor.model;

import java.io.Serializable;
import java.util.Date;

public class LogbackConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String directoryname;
	private String environment;
	private Boolean enable;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirectoryname() {
		return directoryname;
	}

	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}