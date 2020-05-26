package behavioral.chain.of.responsibility.base;


public class ConcreteHandlerOne extends Handler {

    private final static String HANDLER_EVEN = "one";

    @Override
    public void handleRequest(String request) {
        if (HANDLER_EVEN.equals(request)) {
            System.out.println("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
