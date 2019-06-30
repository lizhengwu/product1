package com.lzw.monitor.dao;

import java.util.List;

import com.lzw.monitor.model.LogbackConfig;

public interface LogbackConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(LogbackConfig record);

	LogbackConfig selectByPrimaryKey(Integer id);

	List<LogbackConfig> selectAll();

	int updateByPrimaryKey(LogbackConfig record);
}