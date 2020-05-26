package behavioral.command.base;

public class Client {

    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        System.out.println("客户访问调用者的方法：Invoker.call()");
        invoker.call();
    }
}
