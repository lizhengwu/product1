package com.lzw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class QuartzConfig {

	@Scheduled(fixedRate = 5000)
	public void batch1() {
		System.out.println("11111111");
	}

	@Scheduled(cron = "2 * * * * * ")
	public void batch2() {
		System.out.println("222222222");
	}
}
