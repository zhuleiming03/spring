package behavioral.state.base;

public class Context {

    private AbstractState abstractState;

    /**
     * 定义环境类的初始状态
     */
    public Context() {
        this.abstractState = new ConcreteStateA();
    }

    /**
     * 设置新状态
     *
     * @param abstractState
     */
    public void setState(AbstractState abstractState) {
        this.abstractState = abstractState;
    }

    /**
     * 读取状态
     *
     * @return
     */
    public AbstractState getState() {
        return (abstractState);
    }

    /**
     * 对请求做处理
     */
    public void handle() {
        abstractState.handle(this);
    }
}
