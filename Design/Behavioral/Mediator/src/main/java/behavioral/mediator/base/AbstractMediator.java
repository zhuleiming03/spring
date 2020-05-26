package behavioral.mediator.base;

public abstract class AbstractMediator {

    public abstract void register(AbstractColleague abstractColleague);

    public abstract void relay(AbstractColleague abstractColleague);
}
