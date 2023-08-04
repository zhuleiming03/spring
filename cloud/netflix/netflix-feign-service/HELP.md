# Read Me First
* 注意打包插件plugin 

* docker启动命令 (host.docker.internal映射为宿主本地地址 localhost为容器本地地址)
docker run -d --add-host host.docker.internal:host-gateway -p 8021:8021 --net network_demo --name netflix-feign-service demo/netflix-feign-service:0.0.6