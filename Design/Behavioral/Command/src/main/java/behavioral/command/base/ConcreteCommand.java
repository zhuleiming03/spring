package behavioral.command.base;

public class ConcreteCommand implements Command {

    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        System.out.println("命令者调用接收者:Command.execute() -> Receiver.action()");
        receiver.action();
    }
}
