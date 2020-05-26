package behavioral.visitor.base;

public class ConcreteElementOne implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationOne() {
        return "具体元素 One 的操作。";
    }
}
