package behavioral.mediator.base;

public abstract class AbstractColleague {

    protected AbstractMediator abstractMediator;

    public void setMedium(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

    public abstract void receive();

    public abstract void send();
}
