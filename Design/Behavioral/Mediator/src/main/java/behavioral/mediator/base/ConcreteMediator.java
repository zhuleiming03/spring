package behavioral.mediator.base;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator extends AbstractMediator {

    private List<AbstractColleague> colleagues = new ArrayList<AbstractColleague>();

    @Override
    public void register(AbstractColleague abstractColleague) {
        if (!colleagues.contains(abstractColleague)) {
            colleagues.add(abstractColleague);
            abstractColleague.setMedium(this);
        }
    }

    @Override
    public void relay(AbstractColleague snedColleague) {
        for (AbstractColleague colleague : colleagues) {
            if (!colleague.equals(snedColleague)) {
                colleague.receive();
            }
        }
    }
}
