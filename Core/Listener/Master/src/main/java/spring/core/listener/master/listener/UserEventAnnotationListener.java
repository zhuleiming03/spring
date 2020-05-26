package spring.core.listener.master.listener;

import org.springframework.context.event.EventListener;
import spring.core.listener.master.event.UserEvent;

public class UserEventAnnotationListener {

    @EventListener
    public void onApplicationEvent(UserEvent event) {
        System.out.println(">>> 监听器[UserEventAnnotationListener], UserEvent 内容： "
                + event.getSource());
    }
}
