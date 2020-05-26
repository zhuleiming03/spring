package behavioral.mediator.base;

public class Client {

    public static void main(String[] args) {
        AbstractMediator md = new ConcreteMediator();
        AbstractColleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
