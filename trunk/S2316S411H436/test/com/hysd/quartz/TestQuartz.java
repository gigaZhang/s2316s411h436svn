package com.hysd.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试Quartz定时任务
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
@TransactionConfiguration
@Transactional
public class TestQuartz {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void test_job() {
		//观察一分钟：请先调整定时任务的间隔时间，建议十秒
		try {
			//还可以在这里获取Spring容器上下文
			System.out.println("\n在Quartz定时任务中获取Spring容器上下文：\n" + applicationContext + "\n");
			
			Thread.sleep(30000);//单位：毫秒，所以一分钟：60*1000毫秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
