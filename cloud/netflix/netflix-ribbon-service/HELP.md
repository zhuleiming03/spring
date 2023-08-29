# 简单的服务端

 * docker 启动命令 
 docker run -d --add-host host.docker.internal:host-gateway -p 8023:8023 -p 8024:8024 -p 8025:8025 -p 8026:8026 --name netflix-ribbon-service demo/netflix-ribbon-service:0.0.1
