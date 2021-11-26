# SpringCloudStudy
SpringCloud练习笔记

zookeeper和rabbitmq用docker安装和启动的
```$xslt
docker pull zookeeper:latest
docker run -it --name myzookeeper -p 2181:2181 zookeeper:latest
docker pull rabbitmq:management
docker run -itd --name myRabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 rabbitmq:management
```