package behavioral.visitor.base;

public class ConcreteElementTwo implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationTwo() {
        return "具体元素 Two 的操作。";
    }
}
