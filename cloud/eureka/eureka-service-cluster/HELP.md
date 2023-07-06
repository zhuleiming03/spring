# Read Me First
 * 服务注册中心（集群）
 * 打包好后分别运行
 * java -jar eureka-service-cluster.jar --spring.profiles.active=peer1
 * java -jar eureka-service-cluster.jar --spring.profiles.active=peer2
 * 成功后访问 http://localhost:8011/ 或 http://localhost:8012/
 
 * 启动命令 docker run -d -p 8011:8011 -p 8012:8012 --name  eureka-service-cluster demo/eureka-service-cluster