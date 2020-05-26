package behavioral.visitor.base;

public class Client {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementOne());
        os.add(new ConcreteElementTwo());
        Visitor visitor = new ConcreteVisitorOne();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorTwo();
        os.accept(visitor);
    }
}
