package behavioral.state.base;

public class ConcreteStateA extends AbstractState {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}
