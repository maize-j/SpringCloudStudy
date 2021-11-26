# SpringCloudStudy
这个项目是在学习练习中所用项目，很多技术已经进入停更维护状态，更新的技术在[SpringCloudAlibaba](https://github.com/maize-j/SpringCloudAlibaba.git)

注册中心：Eureka

负载均衡：LoadBalancer

服务调用：openfeign

服务网关：Gateway

服务降级，熔断：hystrix

配置中心：Config

服务总线：Bus（以Rabbit演示）

zookeeper和rabbitmq用docker安装和启动的
```$xslt
docker pull zookeeper:latest
docker run -it --name myzookeeper -p 2181:2181 zookeeper:latest
docker pull rabbitmq:management
docker run -itd --name myRabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 rabbitmq:management
```