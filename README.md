# spring-cloud-examples
spring cloud高可用集群示例，包括注册中心、配置中心、网关、feign使用。

# quick start
* sh deploy.sh
* 访问http://localhost:8890/ 可以看到eureka集群成功启动。
* 访问http://localhost:8887/inventory-server-dev.properties 查看配置中心的配置。
* 访问http://localhost:8085/data/order/create 查看服务是否正常访问。

