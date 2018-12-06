### 技术选型
| 技术 | 版本|
| :------ | :---- |
| dubbo | 2.6.5 |
| dubbo-spring-boot-starter | 0.2.0
| netty-all | 4.1.22.Final |
| spring-boot | 2.0.3.RELEASE |
| docker-compose | 1.21.0 |
| docker | 18.03.1-ce |
### 注意事项
##### 默认约束
经测试，在provider中不添加provider的版本号，默认的版本号为1.0.0,而consumer则是没有默认版本号的，下面是启动的注册信息
```
consumer://172.18.0.2/com.beidougx.dubbo_api.DemoService?application=dubbo-consumer-demo&category=consumers&check=false&default.client=netty&dubbo=2.0.2&interface=com.beidougx.dubbo_api.DemoService&methods=sayHello&pid=1&revision=0.0.1-SNAPSHOT&side=consumer&timestamp=1544079209897, dubbo version: 2.6.5, current host: 172.18.0.2

provider://172.18.0.8:20880/com.beidougx.dubbo_api.DemoService?anyhost=true&application=dubbo-demo-server&bean.name=ServiceBean:com.beidougx.dubbo_api.DemoService:1.0.0&category=configurators&check=false&dubbo=2.0.2&generic=false&interface=com.beidougx.dubbo_api.DemoService&methods=sayHello&pid=1&revision=0.0.1-SNAPSHOT&server=netty&side=provider&status=server&timestamp=1544079206222&version=1.0.0, dubbo version: 2.6.5, current host: 172.18.0.8
```
##### 如何修复
在provider中application.properties添加
```
dubbo.provider.version=1.0.0
```
在consumer中application.properties添加
```
dubbo.consumer.version=1.0.0
```
### 启动运行
本项目在docker-compose下测试，配置文件[docker-compose.yaml](./docker-compose.yaml)
##### 节点规划
| service | node |
| ------ | ---- |
| dubbo_consumer | 1 |
| dubbo_provider | 1 |
| zookeeper | 3 | 
| mysql | 1 |
##### linux/unix
```
sh build.sh && docker-compose up -d
```
##### windows
需要自己编译打包docker镜像，参考[build.sh](./build.sh),然后在当前目录下执行
```bash
docker-compose up -d
```
##### 访问链接^_^
[http://localhost:8081/dubbo/test](http://localhost:8081/dubbo/test)
### TODO 
- dubbo dashbord
- mysql cluster
- mycat HA
- tracing
- metric
- logging