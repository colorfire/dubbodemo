Dubbo demo.

- spring-boot 1.4.0
- dubbo 2.5.3
- zookeeper 3.4.6(option)


If you found this exception, pls to try add above command into jvm arg.
-DJava.net.preferIPv4Stack=true


dubbo-admin编译命令或者直接下载war,然后放到tomcat下去运行。
mvn package -Dmaven.skip.test=true


TODO:
- 打包编译
- 替换服务端jetty服务,改为hessian