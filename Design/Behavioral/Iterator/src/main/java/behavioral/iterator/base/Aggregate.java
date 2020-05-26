package behavioral.iterator.base;

public interface Aggregate {

    void add(Object obj);

    void remove(Object obj);

    Iterator getIterator();
}
