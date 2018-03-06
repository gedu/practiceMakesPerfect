package structures.list;

/**
 * Created by eduardo.graciano on 3/6/18.
 */
public class Node<E> {
    public E content;
    public Node<E> next;

    public Node(E content, Node next) {
        this.content = content;
        this.next = next;
    }
}
