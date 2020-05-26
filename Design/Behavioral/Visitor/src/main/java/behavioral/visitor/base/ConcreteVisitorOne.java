package behavioral.visitor.base;

public class ConcreteVisitorOne implements Visitor {

    @Override
    public void visit(ConcreteElementOne element) {
        System.out.println("具体访问者 One 访问-->" + element.operationOne());
    }

    @Override
    public void visit(ConcreteElementTwo element) {
        System.out.println("具体访问者 One 访问-->" + element.operationTwo());
    }
}
