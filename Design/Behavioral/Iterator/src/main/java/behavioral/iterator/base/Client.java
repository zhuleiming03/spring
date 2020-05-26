package behavioral.iterator.base;

public class Client {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("中山大学");
        aggregate.add("华南理工");
        aggregate.add("韶关学院");
        System.out.print("聚合的内容有：");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object ob = iterator.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = iterator.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
