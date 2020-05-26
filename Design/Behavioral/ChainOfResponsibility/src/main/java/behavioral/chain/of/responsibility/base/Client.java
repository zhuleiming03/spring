package behavioral.chain.of.responsibility.base;

public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandlerOne();
        Handler handler2 = new ConcreteHandlerTwo();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
