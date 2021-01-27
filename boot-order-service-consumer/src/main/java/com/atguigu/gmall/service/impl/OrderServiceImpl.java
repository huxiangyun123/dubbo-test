package com.atguigu.gmall.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 */
@Service
public class OrderServiceImpl{


	@Reference(loadbalance="random",timeout=3000) //dubbo直连
	//@Reference(url = "192.168.1.3:20881")
	UserService userService;
	
	@HystrixCommand(fallbackMethod="hello")
	public List<UserAddress> initOrder(String userId) {
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		return addressList;
	}
	
	
	public List<UserAddress> hello(String userId) {
		// TODO Auto-generated method stub

		return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
	}
	

}
