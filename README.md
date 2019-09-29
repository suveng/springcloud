# cloud系统

## 项目简介

`springcloud` 脚手架

## 目录结构说明
- `admin` 监控中心
- `base`: 基础复用包
    - `result` 返回层封装
    - `log` 日志层封装, 方便运维监控
    - `message` 外部社交消息告警
    - `lock` 并发锁,目前仅有redis
- `config` 统一配置中心,目前使用 kafka 作为 bus 通知
- `eureka`: 服务注册与服务发现,偏AP理论,可能不采用
- `zuul`: 网关,流量转发
- `service`: 服务层
    - `common`: 重用类等等
    - `console`: 管理后台服务,后台模板服务
    - `order` 模拟订单服务,实际无意义
    - `user`: 模拟用户服务,实际无意义

## 版本更新日志
- 0.0.4
    - 使用consul作为注册中心
    - 废弃springcloud config
    

- 0.0.3
    - 变更总线队列为`kafka`
- 0.0.2
    - 使用 `git flow` 规范 
- 0.0.1
    - 引入`eureka`服务注册中心
    - 引入`gateway`网关
    - `gateway`引入`spring security`鉴权
    - 引入`feign`服务间通信
    - 引入`hystrix`熔断
    - 引入 `spring-boot-admin`监控
    - 引入 `spring config server` 统一配置中心
    - 引入 `rabbitmq` bus总线
    - `console` 使用 `Xadmin` 后台模板

## 技术选型

- `git flow`
- [`JDK1.8`](https://www.oracle.com/)
- [`Spring Cloud`](https://www.docs4dev.com/zh)
    - `Spring Boot` 
    - `Spring Security`
    - `Spring Data`
    - `Zuul`
    - `Eureka`
    - `Ribbon`
    - `Feign`
    - `Hystrix`
    - `Spring Config`
    - `kafka` `bus` 总线动态刷新配置
- [`MyBatis`](http://www.mybatis.org/mybatis-3/zh/index.html) 
- [`Redis 5.0`](https://redis.io/)
- [`MySQL 5.7`](https://www.mysql.com/)
- [`Druid`](https://github.com/alibaba/druid) 
- [`FastJSON`](https://github.com/alibaba/fastjson)
- [`hutool`](https://github.com/looly/hutool)
- [`X-admin`](https://gitee.com/daniuit/X-admin)
- [jetBrains](https://www.jetbrains.com/?from=https://github.com/suveng/springcloud)

![](https://gitee.com/suveng/upic/raw/master/jetbrains-variant-3.png)
## 构建

- `mvn clean install -Dmaven.test.skip=true`
- `mvn clean package -Dmaven.test.skip=true`

## 部署

### 本地部署

服务启动顺序

1. `eureka`
2. `admin` , `config`
3. 任意一个`service`
4. `gateway`

> 注意: 配置 MySQL 路径, rabbitMQ/kafka路径

### 上线部署
咨询本人

## 测试策略

自动化测试如何分类，哪些必须写测试，哪些没有必要写测试

- `junit4`



## 领域模型(业务对象封装)


## 技术架构

技术架构图....(待补充)

## 部署架构

部署架构图....(待补充)


## 外部依赖



    
## 环境信息 

自行搭建或者修改 `application.yml` 里面的配置信息

- `MySQL` `127.0.0.1:3306/srping` 
- `Redis` `127.0.0.1:6379` 

## 编码实践

- 统一路径转发: 每个微服务配置 服务名,在`zuul`规则过滤掉这个路径服务,直接转发,
详情看`gateway`模块的`application.yml`,服务间调用配置带上 服务前缀,详情看`user`模块的`client`
- 统一代码格式化 `.editorconfig`
- 统一异常处理 `GlobalExceptionAdvice`
- 统一日志msg格式: LogDetail是封装的日志抽象,原理是 `String.format()`
- 全局请求id `LogDetailThreadLocal`

## FAQ
提问留下`issue`即可

