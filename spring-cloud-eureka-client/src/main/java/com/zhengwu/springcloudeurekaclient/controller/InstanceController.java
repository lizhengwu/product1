package com.zhengwu.springcloudeurekaclient.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceController {

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * 获取当前实例列表，这说明所有实例都存在客户端
	 *
	 * @return
	 */
	@GetMapping("services")
	public Set<String> services() {
		return new LinkedHashSet<>(discoveryClient.getServices());
	}

	@GetMapping("services/${serviceId}")
	public List<ServiceInstance> getInstance(@PathVariable String serviceId) {

		return discoveryClient.getInstances(serviceId);
	}

	@GetMapping("services/${serviceId}/${}")
	public ServiceInstance getInstance(@PathVariable String serviceId, @PathVariable String instanceId) {
		ServiceInstance result = discoveryClient.getInstances(serviceId).stream().
				filter(serviceInstance -> serviceInstance.getInstanceId().equals(instanceId)).findFirst().get();
		return result;
	}
}
