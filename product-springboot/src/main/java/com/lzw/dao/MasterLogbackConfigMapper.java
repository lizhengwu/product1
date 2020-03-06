package com.lzw.dao;

import java.util.List;

import com.lzw.monitor.model.LogbackConfig;

public interface MasterLogbackConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(LogbackConfig record);

	LogbackConfig selectByPrimaryKey(Integer id);

	List<LogbackConfig> selectAll();

	int updateByPrimaryKey(LogbackConfig record);
}