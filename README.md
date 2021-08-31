# dubbo-basic-framework

微服务基础框架搭建

技术结构

    Dubbo
    Zoopeeker
    Redis
    Mybatis Plus

项目结构

    basic-core(基础核心模块)
    basic-interface(接口核心模块)
    area-provider(地区供应者)
    area-consumer(地区消费者)
    user-provider(用户供应者)
    user-consumer(用户消费者)  

启动

    修改各服务中的appliction.yml配置，包括数据库连接,Zoopeeker连接,Redis连接等
    需启动redis客户端(集成一些技术需要用到redis)
    需启动Zoopeeker客户端(将服务注册到Zoopeeker服务中心中)
    启动类:各服务中Application应用启动类

swagger接口文档

    访问路径：http://localhost:port/doc.html

    根据自己项目所需的端口和命名方式配置appliction.yml配置中的值