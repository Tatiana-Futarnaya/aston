import java.util.Collection;

public interface MyArray<E> {

    boolean addAll(Collection<? extends E> c);
    boolean add(E e);
    void add(int index, E e);
    int indexOf(E e);
    int lastIndexOf(E e);
    void delete(int index);
    void deleteRange(int indexStart, int indexEnd);
    void delete(E e);
    E get(int index);
    int size();
    E set(int index, E e);
}
