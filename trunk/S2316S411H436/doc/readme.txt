
一、项目名称：S2316S411H436
项目原型：Struts2.3.16 + Spring4.1.1 + Hibernate4.3.6 + Quartz2.2.1

二、项目目的：
整合使用最新版本的三大框架（即Struts2、Spring4和Hibernate4），演示搭建项目架构原型。
项目架构原型：Struts2.3.16 + Spring4.1.1 + Hibernate4.3.6 + Quartz2.2.1。
此外，还有：Quartz、JUnit4、Log4j、SLF4J、Ehcache、Gson等这些库或框架，也全部使用最新版本。

三、项目特色：
1、同时使用了Struts2、Spring4、Hibernate4、Quartz、JUnit4、Log4j、SLF4J、Ehcache、Gson等库或框架，搭建一个最基本的项目原型。
2、Spring配置提供了多种可选整合方案：详见applicationContext.xml的配置
（1）提供支持三种数据源方案：C3P0、DBCP、JNDI，三选一，请注释或删除其他方案
（2）提取四种Hibernate整合方案：四选一，请注释或删除其他方案
（3）提供两种声明式事务管理器方案：二选一，请注释或删除其他方案

	
	
	
四、三大框架最新版本下载：截止2014-10-01

Struts2.3.6：发布于2014-05-03，官网：http://struts.apache.org/
http://mirrors.cnnic.cn/apache/struts/binaries/struts-2.3.16.3-all.zip

Spring4.1.1：发布于2014-10-01，官网：http://spring.io/
http://repo.spring.io/libs-release-local/org/springframework/spring/4.1.1.RELEASE/spring-framework-4.1.1.RELEASE-dist.zip

Hibernate4.3.6：发布于2014-07-16，官网：http://hibernate.org/
http://softlayer-sng.dl.sourceforge.net/project/hibernate/hibernate4/4.3.6.Final/hibernate-release-4.3.6.Final.zip



参考文档：（感谢下边的两位原创作者，另外我在结合两个优点的基础之上，增加了更多的配置方案。）
http://blog.csdn.net/songanling/article/details/22454973
http://1194867672-qq-com.iteye.com/blog/1522906