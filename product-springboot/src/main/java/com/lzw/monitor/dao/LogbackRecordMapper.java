package com.lzw.monitor.dao;

import java.util.List;

import com.lzw.monitor.model.LogbackRecord;

public interface LogbackRecordMapper {
	int deleteByPrimaryKey(String id);

	int insert(LogbackRecord record);

	LogbackRecord selectByPrimaryKey(String id);

	List<LogbackRecord> selectAll();

	int updateByPrimaryKey(LogbackRecord record);

	int insertRecord(LogbackRecord record);

	int updateEndTime(LogbackRecord record);
}