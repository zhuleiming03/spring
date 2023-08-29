# Read Me First
* 注意打包插件plugin 

* 提供三个接口 没有熔断、有熔断异常返回、有区分熔断异常类型返回

* docker启动命令 (host.docker.internal映射为宿主本地地址 localhost为容器本地地址)
docker run -d --add-host host.docker.internal:host-gateway -p 8022:8022 --net network_demo --name netflix-hystrix-service demo/netflix-hystrix-service:0.0.4
