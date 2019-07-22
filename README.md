# cloud系统

## 项目简介

- base
- eureka
- gateway
- service
    - common
    - user

## 技术选型

- JDK1.8
- Spring Cloud
- MyBatis
- Redis
- MySQL
- Druid
- fastJSON
- hutool

## 构建

- mvn clean install -Dmaven.test.skip=true
- mvn clean package -Dmaven.test.skip=true

## 部署

- 本地部署

- 测试部署

## 测试策略

- junit4

自动化测试如何分类，哪些必须写测试，哪些没有必要写测试

## 领域模型(业务对象封装)


## 技术架构

技术架构图

## 部署架构

部署架构图

# 外部依赖



## 环境信息 

- 各个环境的访问方式，数据库连接等

## 编码实践

- 统一的编码实践，比如异常处理原则、分页封装等
- 统一日志msg格式: LogDetail是封装的日志抽象,原理是 `String.format()`


## FAQ


