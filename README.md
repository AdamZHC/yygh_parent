# 项目简介

从网上找的体量较大的业务项目，大概做了一个月，用到的技术也比较多，下面是一些技术栈的说明，另外接口文档等就不多赘述

# 核心技术

微信支付，手机微信登陆，阿里云OSS

SpringBoot：简化新Spring应用的初始搭建以及开发过程

SpringCloud：基于Spring Boot实现的云原生应用开发工具，SpringCloud使用的技术：（SpringCloudGateway、Spring Cloud Alibaba Nacos、Spring Cloud Alibaba Sentinel、SpringCloud Task和SpringCloudFeign等）

MyBatis-Plus：持久层框架

Redis：内存缓存

RabbitMQ：消息中间件

HTTPClient: Http协议客户端

Swagger2：Api接口文档工具

Nginx：负载均衡

Lombok: idea插件，简化实体类

Mysql：关系型数据库

MongoDB：面向文档的NoSQL数据库

Vue.js：web 界面的渐进式框架

Node.js： JavaScript 运行环境

Axios：Axios 是一个基于 promise 的 HTTP 库

NPM：包管理器

Babel：转码器

Webpack：打包工具

Docker	：容器技术

Git：代码管理工具

# 业务流程

![](http://cdn.xiongsihao.com/202103252355_509.png)

# 服务架构

![](http://cdn.xiongsihao.com/202103252356_952.png)

 # 运行项目

运行环境：redis, nacos,rabbitMQ,Mysql,Mongodb

数据初始化：sql目录下有mysql和mongodb数据初始化的脚本,其中mongodb的脚本需要运行hospital-manage项目后浏览器访问http://localhost:9998/，在里面执行导入操作



服务：

前端服务：npm install， npm run dev 

yygh-site(前台用户预约端)  http://localhost:3000/

hospital_admin(后台医院管理端) http://localhost:9528/

后端接口服务：

service目录下：

service_cmn 字典服务，service_hosp医院相关接口服务,service_msm短信服务，service_order订单服务，service_oss文件存储服务，service_statistics数据统计服务，service_task定时任务服务，service_user用户中心服务

service_gateway网关服务

hospital-manage医院平台服务

service_client feign代理服务
