该服务用于配合 netflix 测试使用

 * docker 启动命令 
 docker run -d --add-host host.docker.internal:host-gateway -p 8022:8022 -p 8023:8023 -p 8024:8024 --name netflix-service demo/netflix-service-instance:0.0.2