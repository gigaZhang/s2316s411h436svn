
一、导包说明：
除了junit-4.11.jar和hamcrest-core-1.3.jar，其他jar包都导入到classpath中。
（原因：junit-4.9.jar相当于：junit-4.11.jar和hamcrest-core-1.3.jar的二合一，两种方案选择一种即可。）

二、jar包来源：
此文件夹中的jar包全部来自第三方，一般来自对应官网或者Apache官网。

其中，
（1）如果没有用到JUnit测试，可以从classpath中移除：junit-4.11.jar，hamcrest-core-1.3.jar。
	在较低版本的JUnit4.X中（例如junit-4.9等）是将这两个jar合并在一起的。
（2）如果没有用到DBCP，可以从classpath中移除：commons-dbcp-1.4.jar，commons-pool-1.6.jar。
（3）如果没有用到aspectj，可以从classpath中移除：aspectjweaver-1.8.2.jar。



下载地址：
1、JUnit4：http://junit.org/
https://github.com/junit-team/junit/wiki/Download-and-Install

2、Hamcrest：http://hamcrest.org/

3、Ehcache：http://www.ehcache.org/

4、Log4j：http://logging.apache.org/
http://www.apache.org/dyn/closer.cgi/logging/log4j/1.2.17/log4j-1.2.17.zip

5、SLF4J：http://www.slf4j.org/
http://www.slf4j.org/dist/slf4j-1.7.7.zip

6、Quartz：http://www.quartz-scheduler.org/
http://d2zwv9pap9ylyd.cloudfront.net/quartz-2.2.1-distribution.tar.gz

7、Gson：需翻墙，https://code.google.com/p/google-gson/
https://google-gson.googlecode.com/files/google-gson-2.2.4-release.zip

8、Apache官网：http://www.apache.org/
通过搜索可以下载到常用包
