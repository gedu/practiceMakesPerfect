package structures.list;

/**
 * Created by eduardo.graciano on 3/6/18.
 *
 * This liked list only keep track of the Head node
 */
public class SingleLinkedListH<E> implements IList<E> {

    private int size = 0;
    private Node<E> head = null;

    public SingleLinkedListH() {}


    @Override
    public E getFrom(int position) {
        return null;
    }

    @Override
    public void add(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node<E> currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;
    }

    @Override
    public void removeFrom(int position) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }
}
