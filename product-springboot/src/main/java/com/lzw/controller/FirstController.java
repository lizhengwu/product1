/**
 * FileName: FirstController
 * Author:   lzw
 * Date:     2020/2/20 16:42
 * Description:
 * History:
 */
package com.lzw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzw.dao.MasterLogbackConfigMapper;
import com.lzw.monitor.dao.LogbackConfigMapper;
import com.lzw.monitor.model.LogbackConfig;

/**
 * 〈SpringMvc conroller〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@RestController
public class FirstController {

	// @Autowired
	// private LogbackConfigMapper logbackConfigMapper;

	@Autowired
	private MasterLogbackConfigMapper masterLogbackConfigMapper;

	// @GetMapping("/config")
	// public List<LogbackConfig> helloWordByController() {
	// 	return logbackConfigMapper.selectAll();
	// }

	@GetMapping("/masterConfig")
	public List<LogbackConfig> masterConfig() {
		return masterLogbackConfigMapper.selectAll();
	}
}