1、下载 zipkin.jar
>linux:
>>>>curl -sSL https://zipkin.io/quickstart.sh | bash -s
>windows:
>>>>https://zipkin.io/quickstart.sh 下载 quickstart.sh 
>>>>git bath here >sh quickstart.sh

2、运行 zipkin.jar
java -jar zipkin.jar --zipkin.collector.rabbitmq.addresses=localhost:5672 --zipkin.collector.rabbitmq.username=sa 

3、访问
http://localhost:9411/zipkin/