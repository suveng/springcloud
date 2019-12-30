# cloud系统-测试学习用

## 项目简介

`springcloud`测试项目

## 版本更新日志
- 1.0.0
    - 组件更新
    - springcloud版本升级为 Hoxton
    - consul注册中心/配置中心
    - springcloud gateway 网关
    - 两个微服务
    - 一个静态资源后台服务
    - 微服务使用OpenFeign,自带熔断
    
- 0.0.7
    - log增加扩展demo
    - currency.log 1.3.0

- 0.0.6

- 0.0.5 
    - 引入hibernate validation参数校验
    - zuul dockerfile, consul的settings.yml配置
- 0.0.4
    - 使用consul作为注册中心
    - 废弃springcloud config
    - 使用consul作为配置中心,consul配置文件存放在每个module下面的settings.yml

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
- [`MyBatis`](http://www.mybatis.org/mybatis-3/zh/index.html) 
- [`Redis 5.0`](https://redis.io/)
- [`MySQL 5.7`](https://www.mysql.com/)
- [`Druid`](https://github.com/alibaba/druid) 
- [`FastJSON`](https://github.com/alibaba/fastjson)
- [`hutool`](https://github.com/looly/hutool)
- [`X-admin`](https://gitee.com/daniuit/X-admin)
- [jetBrains](https://www.jetbrains.com/?from=https://github.com/suveng/springcloud)
- [hibernate validation](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-gettingstarted-createproject)


 ![jetbrains](https://gitee.com/suveng/upic/raw/master/jetbrains-variant-3.png)
 

## 构建
开发环境构建:
本地开发调试,无须打包成docker,上测试环境才需要
- mvn clean package -Dmaven.test.skip=true -Pdev
测试环境构建:
- mvn clean package install -Dmaven.test.skip=true -DpushImage -Ptest
## 启动/部署

本地: 
IDEA启动
测试: 
k8s部署容器

## FAQ
提问留下`issue`即可

