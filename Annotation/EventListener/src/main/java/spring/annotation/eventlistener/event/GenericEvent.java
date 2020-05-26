package spring.annotation.eventlistener.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class GenericEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    public GenericEvent(T source) {
        super(source);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(getSource()));
    }

    @Override
    public T getSource() {
        return (T) super.getSource();
    }
}
