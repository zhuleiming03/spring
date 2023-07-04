# Read Me First
 * 服务注册中心（集群）
 * 需要配置主机域名
 * Windows: C:\Windows\System32\drivers\etc\hosts
 * Linux:   /etc/host
 * 添加 127.0.0.1 eureka-server 127.0.0.1 eureka-server-1 127.0.0.1 eureka-server-2
 * 打包好后分别运行
 * java -jar eureka-service-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
 * java -jar eureka-service-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
 
 * docker run -d -p 8080:8080 --name docker-base demo/docker-base