package spring.core.listener.master.listener;

import org.springframework.context.ApplicationListener;
import spring.core.listener.master.event.UserEvent;

public class UserEventInterfaceListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        System.out.println(">>> 监听器[UserEventInterfaceListener], UserEvent 内容： "
                + event.getSource());
    }
}
