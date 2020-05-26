package structural.bridge.domain;

public abstract class AbstractOrder {

    IUser user;

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }
}
