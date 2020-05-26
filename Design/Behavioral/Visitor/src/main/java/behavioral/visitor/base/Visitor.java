package behavioral.visitor.base;

public interface Visitor {

    void visit(ConcreteElementOne element);

    void visit(ConcreteElementTwo element);
}
