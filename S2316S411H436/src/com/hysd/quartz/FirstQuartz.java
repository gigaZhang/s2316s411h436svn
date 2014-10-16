package com.hysd.quartz;


/**
 * 第一个Quartz定时任务
 */
public class FirstQuartz {

	public void doTestJob() {
		System.out.println("\n测试Quartz定时任务：" + (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS")).format(new java.util.Date()) + "\n");
	}
	
}