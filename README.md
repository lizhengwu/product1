# 知识点

## OpenSource



Spring Framework

Spring Boot

Spring Cloud

Spring Data 

Spring Cloud Data FLow

Spring Security



Hystrix 服务熔断

Zuul   API网关

Ribbbon  负载均衡

Feign webservice 客户端代理

Zookeeper  分布式协调服务

Consul  分布式协调服务

Eureka  服务发现

Dubbo  分布式服务治理



Etcd

Nginx 

Kong

Apollo

Nacos

ELK

​	Elasticsearch 实时搜索框架

​	Logstash  日志流处理

​	Kibana 数据渲染展示

K8s	kubernetes

Docker





## HTTP2.0
    Hypertext 超文本协议
    HPACK 







## Rest协议
一方面是 requestMethod的运用，另一方面是response 更多的根据状态码来判断。







## 分布式的CAP

CAP是加州大学伯克利分销的Eric Brewer教授提出来的。指的是在分布式系统中，三个要素最多能实现两点，不可能三者兼顾



(Consistency) 一致性

​	在分布式系统中所有的数据备份在同一时刻是一致的。同步数据的延迟性极小

(Available) 可用性 

​	在分布式系统中某一单点节点宕机之后,每个响应依然可以完成

(Partition tolerance) 分区容错性

​	在集群中如果出现错误能够正常服务



### BASE 理论

Basically Avaliable (基本可用)

Soft state  （软状态）

Eventually consistent (最终一致性)

base理论是对CAP的一种妥协，无法做到强一致，就使用另一种方法来达到最终的目的



### XA协议

1、2PC   to prepare commit  两阶段提交，就是XA协议的原理。牺牲一部分可用性来保证一致性。

第一阶段提交就是预提交，等处理完成后接受返回，判断返回结果来决定下一个请求是commit还是abort。

2、TCC   try catch cancel   执行的时候判断是否出现异常，如果失败，则调用cancel处理。

3、异步补偿机制  ，写入数据的时候如果异常，需要写入一个消息，异步通过消息来对此次写入数据做补偿。



[参考文章](https://www.cnblogs.com/savorboard/p/distributed-system-transaction-consistency.html)



## 面向服务的架构 SOA 









## Cloud Native

百度百科这样解释

>Cloud Native翻译为云原生，是Matt Stine提出的一个概念，它是一个思想的集合，包括[DevOps](https://baike.baidu.com/item/DevOps/2613029)、[持续交付](https://baike.baidu.com/item/持续交付/9803571)（Continuous Delivery）、[微服务](https://baike.baidu.com/item/微服务/18758759)（MicroServices）、敏捷基础设施（Agile Infrastructure）、康威定律（Conways Law）等，以及根据商业能力对公司进行重组。Cloud Native既包含技术（微服务，敏捷基础设施），也包含管理（DevOps，持续交付，康威定律，重组等）。Cloud Native也可以说是一系列Cloud技术、企业管理方法的集合。



云计算的三层基础架构

```
1、基础设施即服务IaaS)
基础设施即服务是主要的服务类别之一，它向云计算提供商的个人或组织提供虚拟化计算资源，如虚拟机、存储、网络和操作系统。 
2、平台即服务(PaaS)
平台即服务是一种服务类别，为开发人员提供通过全球互联网构建应用程序和服务的平台。Paas为开发、测试和管理软件应用程序提供按需开发环境。 
3、软件即服务(SaaS)
软件即服务也是其服务的一类，通过互联网提供按需软件付费应用程序，云计算提供商托管和管理软件应用程序，并允许其用户连接到应用程序并通过全球互联网访问应用程序。
```





​	在spring体系中，spring提供了一套 cloud navit 的解决方案，其中主要了解一下 MicroService 和DevOps。

Cloud Native的基础设施有

- 服务发现     eureka、zookeeper、consul、nacos
- 服务网关    zuul、nginx、openrestry、Spring cloud gateway
- 负载均衡  Ribbon、dubbo、Kong
- 服务容错  hystrix dubbo Kong
- 分布式配置 git， nacos 、zookeeper、consul
- 服务监控  ELK、spring 
- 服务跟踪  zipkin 、openTracing、



## Euraka 

服务发现：

- 常见的协议
  - ​	java ： jini

  - ​	Rest： hateoas

  - ​	webservice UDDI  通常使用 WSDL

    

服务注册：

- 常见注册中西

  - zookeeper   比较稳定的注册中心  （从paxos 到zookeeper）

  - Netflix eureka 

  - consul

    

有中心化注册，和去中心化注册（区块链）（Steam），



高可用架构：

​	主要是指标。消灭单点故障。通常通过集群来解决。



注册中心



| 注册中心  | CAP   | 推荐规模  |
| --------- | ----- | --------- |
| Eureka    | AP    | <30K      |
| Zookeeper | CP    | <30k      |
| console   | AP/CP | <5k       |
| nacos     | AP/CP | 199k-200k |





## Feign Hystrix

JAVA  RMI  二进制协议

WebService

- ​	xml约束
- ​	json约束

restEasy  实现了JAX-RS2.0



Feign、 Spring Cloud Open Feign ，JAX-RS、Spring Web Mvc 

| 技术                    | e                  | 请求映射路径    | 请求参数 |
| ----------------------- | ------------------ | --------------- | -------- |
| Feign                   | 客户端声明         |                 |          |
| Spring Cloud Open Feign | 客户端声明         | @RequestMapping |          |
| JAX-RS                  | 客户端、服务端声明 | @Patch          |          |
| Spring Web Mvc          | 服务端声明         |                 |          |

Feign 客户端负载均衡  

- 扩展支持（高度扩展，contract 提供Feign接口方法与Rest请求元信息的契约）

  - 内建Feign注解

  - JAX-RX 1/2注解

  - JAXB 

  - OkHttp

    

实现细节猜想

- Java接口与Rest 如何映射

- @FeignClient 注解指定的服务名称用到了服务发现

- @EnableFeigh 自动装配Feign组件

- Feign请求内容是如何序列化的

  

Spring Cloud + Netflix Feign 有一定的延迟。默认30秒

```
ServerListUpdater
```



