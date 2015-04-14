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