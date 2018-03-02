package structures.list;

/**
 * Created by eduardo.graciano on 3/2/18.
 */
public interface IList<E> {

    E getFrom(int position);
    void add(E item);
    void removeFrom(int position);
    void clear();
    int size();
}
