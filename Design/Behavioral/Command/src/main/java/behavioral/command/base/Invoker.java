package behavioral.command.base;

public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者调用命令者:Invoker.call() -> Command.execute()");
        command.execute();
    }
}
