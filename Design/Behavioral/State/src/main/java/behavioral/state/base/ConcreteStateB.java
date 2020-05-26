package behavioral.state.base;

public class ConcreteStateB extends AbstractState {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}
