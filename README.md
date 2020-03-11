# 一、JAVA技术栈



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



Solr  搜索服务 





webmagic 爬虫框架





# 二、JAVA 基础

## 2.1 位移运算 

```
<< : 左移运算符，num <<1,相当于num乘以2

>> : 右移运算符，num >>1,相当于num除以2

>>> : 无符号右移，忽略符号位，空位都以0补齐，（计算机中数字以补码存储，首位为符号位）。

如：a  =  00110111，则a>>2    = 00001101，b=11010011，则b>>2   =  11110100；  

如：a  =  00110111，则a>>>2  = 00001101，b=11010011，则b>>>2 =  00110100。

```



## 2.2 Collection



### ArrayList
**Features**

- ArrayList 是一个动态的可变的数组，其内部主要是由一个 Object[] 数组来存储数据，实现了List ，RandomAccess，Serializable
- ArrayList 初始化大小是10，最大可以存放INTEGER.MAXVALUE个元素，但是这个时候要考虑方法栈的大小。
- ArrayList 序列化的时候是遍历没一个元素进行序列化。`writeObject`
- ArrayList 新增的时候，每次在数组满了之后才会新增数组，增加的是现有的一半（1.5倍扩容），并且是直接Copy过去
- 删除元素，直接把后面的元素整体复制到前面。
- fail-fast modCounr 用来记录ArrayListde 改变次数，所以，在迭代器迭代的时候如果count，发生改变了，则会抛出exception。这就是为啥不能再for循环的时候删除元素，只能在迭代器里面进行删除

**Question**

最大有多少个元素，是否能存那么多个，要考虑内存够不够，一个栈的内存能放多少。



### Vector

**Features**

- 线程安全版本的ArrayList，内部方法基本上都差不多。
- 每次扩容成倍的扩容

Vector如果单纯是为了线程安全考虑的话，是可以有替代方案的

```java
 Collections.synchronizedCollection(new ArrayList<>());
```

```java
CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
```

CopyOnWriteArrayList 新增的时候每次都会copy原来的数组，在读的时候不会锁，只加了个写锁，在高并发情况下读多写少的情况下可以用这个，但是无法避免脏读现象

### LinkedList 

数据结构

```java
/**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
transient Node<E> last;

private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```



**Features**

- LinkedList是一个双向的链表，存储了头指针和 尾指针。这两个Node就是两个链表。
- 序列化的时候和ArrayList一样，遍历每一个元素
- 不支持随机查找，只能挨个遍历，新增和删除很快，但是查找却很慢。是因为查找的时候只能从前遍历或者从后遍历。



### HashMap

**Features**

- 初始化大小是16，新增因子是0.75 
- HashMap的第一层是`Node<K,V>[] table`，key存放的是hash ，Node存放的是数据，可以是个object ，单向链表，树。在他的单个node的size大于 等于8时，为了查询效率转化为红黑树，当转的时候，如果发现Hashtale的size小于64的话，会选择直接扩容HashTable，而不去转红黑树。
- HashMap在扩容的时候，oldTab.length << 1 ,然后再拿所有的hash重新按照size计算一下。放入新的tab中



**源码分析**

put分析

```java
/**
 * Implements Map.put and related methods
 *
 * @param hash hash for key
 * @param key the key
 * @param value the value to put
 * @param onlyIfAbsent if true, don't change existing value
 * @param evict if false, the table is in creation mode.
 * @return previous value, or null if none
 */
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    //如果table不存在，新增table
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 用hash与table大小进行计算，看看是否能得到table的数组的下标的链表，没有的话新增node，在这里n是hashMap的大小，就是为了让n与hash参与运算，hash的值也会与自己的高16位参与一个异或运算，为了保证一个散列程度
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        //如果拿到了Node
        Node<K,V> e; K k;
        // 如果发现Node的key相等，那么就覆盖
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        // 如果不相等，看看这个key是否已经变为树
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        // 不是树就是单向的链表，头部开头的链表
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    // 这里判断要不要转为树
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                // 赋值给当前节点
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            //linkedHashMap所拥有的特性
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    //linkedHashMap所拥有的特性
    afterNodeInsertion(evict);
    return null;
}
```



resize 重新扩容

```java
/**
 * Initializes or doubles table size.  If null, allocates in
 * accord with initial capacity target held in field threshold.
 * Otherwise, because we are using power-of-two expansion, the
 * elements from each bin must either stay at same index, or move
 * with a power of two offset in the new table.
 *
 * @return the table
 */
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```



### ConcurrentHashMap

数据结构

```java
final int hash;
final K key;
volatile V val;
volatile Node<K,V> next;
```

**Features**

- 线程安全的HashMap 

- 1.7 用segment ，1.8 用CAS 分段锁。并且在链表过长也会转红黑树

- 

  

### LinkedHashMap



**Features**

- 插入有序的HashMap 底层考一个LinkedList来维护。
- accessOrder 决定了是插入排序，还是读取排序，fail为插入排序，true为读取排序，每日插入或者读取，都会将当前元素放在链表的尾部

可以依靠LinkedHashMap的特性来实现LRU算法， 

```java
public class LRUCache extends LinkedHashMap {

   /**
    * 保存3个热点
    */
   private static int MAX_ENTRIES;

   /**
    * 初始化最大热点数量
    * @param maxEntries
    */
   public LRUCache(int maxEntries) {
      super();
      MAX_ENTRIES = maxEntries;
   }

   /**
    * 如果返回true，则删除头结点
    * @param eldest
    * @return
    */
   @Override
   protected boolean removeEldestEntry(Map.Entry eldest) {
      return size() > MAX_ENTRIES;
   }
}
```





### WeakHashMap

基本特点就是Key如果没有被其他实际对象引用，则会被垃圾回收掉。

tomcat中的ConcurrentCache 是通过WeakHashMap和ConcurrentHashMap实现的

```java
public final class ConcurrentCache<K,V> {

    private final int size;
	// 伊甸园
    private final Map<K,V> eden;
	// 持久代
    private final Map<K,V> longterm;

    public ConcurrentCache(int size) {
        this.size = size;
        this.eden = new ConcurrentHashMap<>(size);
        this.longterm = new WeakHashMap<>(size);
    }
	// 先从伊甸园里面找
    public V get(K k) {
        V v = this.eden.get(k);
        // 找不到再从持久代里面找，
        if (v == null) {
            synchronized (longterm) {
                v = this.longterm.get(k);
            }
            // 如果找到了，放入伊甸园中
            if (v != null) {
                this.eden.put(k, v);
            }
        }
        return v;
    }

    public void put(K k, V v) {
        // 如果热点区域的大小超过预制的大小，则放入WeakHashMap中，依靠JVM进行GC
        if (this.eden.size() >= size) {
            synchronized (longterm) {
                this.longterm.putAll(this.eden);
            }
            this.eden.clear();
        }
        this.eden.put(k, v);
    }
}
```



## 2.3  序列化

**定义**

把内存数据转换成可储存的数据。





## 2.3 代理反射



## 2.4 内存模型



## 2.5 线程并发

### 线程状态

NEW、RUNNABLE 、BLOCK、WAIT、TIMEWAIT、TERMINATED





### 线程池

ThreadPoolExecutor

- newCachedThreadPool  return 	ExecutorService
- newFixedThreadPool  return 	ExecutorService
- newWorkStealingPool  return 	ExecutorService
- newSingleThreadExecutor   return 	ExecutorService
- newSingleThreadScheduledExecutor    return ScheduledExecutorService





### 线程安全

volatile、synchronize、Lock

**synchronize 和Lock**

- synchronize 是JVM级别的锁，Lock是JDK级别的锁


**锁的分类**

- 可重入锁

- 排他锁

- 读写锁

  

ReadWrite 读写锁 与java8的StampedLock比较

ReetrantLock 可重入锁 可以显示的 加锁和释放锁，建议用finally来保证锁的释放

死锁。 要写出来个死锁



### 线程通信

notify 

wait

notifyAll

Condition来唤醒线程

阻塞队列来控制BlockingQueue

### 线程相关的类

ThreadLocal



### CAS 无锁同步机制



## 2.6 JAVA 虚拟机



## 2.XX Java8新特性

1、接口式编程

2、lamada表达式

3、interface default

4、stream处理

5、parallelStream ，stream 新能比较









# 三、JAVA框架

## 3.1 SpringFramework

### Features

- [Core technologies](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html): dependency injection, events, resources, i18n, validation, data binding, type conversion, SpEL, AOP.
- [Testing](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html): mock objects, TestContext framework, Spring MVC Test, `WebTestClient`.
- [Data Access](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html): transactions, DAO support, JDBC, ORM, Marshalling XML.
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) and [Spring WebFlux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html) web frameworks.
- [Integration](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/integration.html): remoting, JMS, JCA, JMX, email, tasks, scheduling, cache.
- [Languages](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/languages.html): Kotlin, Groovy, dynamic languages.

依赖注入：启动Spring过程：1、首先通过```HttpServlet``` init 方法来加载整个Spring容器，首先要定位资源信息，加载资源信息，properties文件等等，这个有个顺序可以在官方文档里面看到，

事件驱动： 在Springboot中的application 其中有一部分好像就是事件驱动

事务管理：

SpringMVC 是基于Servlet的，Spring WebFlux 是根据Netty驱动的，异步非阻塞队列









# 四、微服务

## 4.1 面向服务的架构 SOA 



## 4.2 Cloud Native

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



## 4.3 Euraka 



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





## 4.4 Feign Hystrix

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





## 4.5 DUBBO

自我经验应用场景

- 通过SPI协议扩展
- 隐式传参，在Consumer的FIlter中设置，在Provider的Filter中获取

```java
RpcContext.getContext().getAttachment();
```

- 集群容错：有的可以retries，有的则需要boardcast
- 负载均衡：根据业务场景，如果涉及到缓存，应该用最少活跃，或者其他的
- 多版本：根据不同的版本，调用不同的接口处理。
- 服务分组：批量调用和普通调用是不一样的
- 异步调用：
- 控制连接数：
- 路由规则：

Dubbo配置分为三大类：

1. 服务发现：服务的注册与发现，目的是发布服务，并且使调用方可以能够尽快的感知服务的存在
2. 服务治理：负载均衡，集群容错，相关的配置。
3. 性能调优：之所以所谓调优，意思就是不同的配置会有不同的应用场景，根据业务场景来达到最优解。

attention：只有group，interface，version 是服务的匹配条件三者决定是不是同一个服务，其它配置项均为调优和治理参数。

# 五、分布式

## 分布式的CAP

**概念**

CAP是加州大学伯克利分销的Eric Brewer教授提出来的。指的是在分布式系统中，三个要素最多能实现两点，不可能三者兼顾

- (Consistency) 一致性 ：在分布式系统中所有的数据备份在同一时刻是一致的。同步数据的延迟性极小

- (Available) 可用性 ：	在分布式系统中某一单点节点宕机之后,每个响应依然可以完成

- (Partition tolerance) 分区容错性：	在集群中如果出现错误能够正常服务


一般来说，都是在可用性和一致性上来抉择。



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





# 六、DB

## 6.1 MySQL

### 主从同步

1. Master接受写请求
2. Master通知slaver同步数据
3. Master等待所有slaver返回结果

这样如果一旦任何一个slaver出错，就可能造成阻塞。



## 6.2 Redis

**Features**

- 单线程的I/O多路复用 线程安全 QPS 极高
- 集群部署
- 数据持久化



**数据类型**

| 类型    | 简介               | 特性 | 场景 |
| ------- | ------------------ | ---- | ---- |
| String  | 二进制安全的字符串 |      |      |
| List    | 双向链表           |      |      |
| Hash    | hash               |      |      |
| Set     | 不重复链表         |      |      |
| SortSet | 有序链表           |      |      |



**异常场景**

缓存雪崩：大量缓存的TTS在同一时间失效

缓存击穿：缓存命中问题 

缓存穿透：缓存没命中，数据库也没命中，

淘汰策略



解决方案，布隆过滤器，提前判断缓存中是否有可能存在



主从，哨兵

# 七、网络

## 7.1 HTTP2.0
    Hypertext 超文本协议
    HPACK 



## 7.2 Rest协议
一方面是 requestMethod的运用，另一方面是response 更多的根据状态码来判断。



















# 算法



## 布隆过滤器

## 红黑树

## LRU算法

