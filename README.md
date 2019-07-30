# cloud系统

## 项目简介

- `base`: 基础复用包
- `eureka`: 服务注册与服务发现
- `gateway`: 网关
- `service`: 服务
    - `common`: 重用`mapper`等等
    - `user`: 用户服务
    - `console`: 管理后台服务

## 技术选型

- `JDK1.8`
- `Spring Cloud`
    - `Spring Boot` 
    - `Spring Security`
    - `Spring Data`
    - `Zuul`
    - `Eureka`
    - `Ribbon`
    - `Feign`
    - `Hystrix`
    - `Spring Config`
- `MyBatis` 
- `Redis 5.0`
- `MySQL 5.7`
- `Druid` 
- `FastJSON`
- `hutool`

## 构建

- `mvn clean install -Dmaven.test.skip=true`
- `mvn clean package -Dmaven.test.skip=true`

## 部署

### 本地部署

服务启动顺序

1. `eureka`
2. `gateway`
3. 任意一个`service`

### 测试部署

## 测试策略

自动化测试如何分类，哪些必须写测试，哪些没有必要写测试

- `junit4`



## 领域模型(业务对象封装)


## 技术架构

技术架构图

## 部署架构

部署架构图


# 外部依赖

- `spring cloud: Finchley.RELEASE` 
- `hutool`工具包



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


