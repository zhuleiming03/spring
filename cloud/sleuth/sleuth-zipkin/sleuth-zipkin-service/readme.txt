1������ zipkin.jar
>linux:
>>>>curl -sSL https://zipkin.io/quickstart.sh | bash -s
>windows:
>>>>https://zipkin.io/quickstart.sh ���� quickstart.sh 
>>>>git bath here >sh quickstart.sh

2������ zipkin.jar
java -jar zipkin.jar --zipkin.collector.rabbitmq.addresses=localhost:5672 --zipkin.collector.rabbitmq.username=sa 

3������
http://localhost:9411/zipkin/