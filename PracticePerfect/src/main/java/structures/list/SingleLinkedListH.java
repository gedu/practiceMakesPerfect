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
        checkPositionRange(position);
        if (isEmptyHeader()) return null;

        Node<E> currentNode = head;

        for (int i = 0; currentNode != null; i++) {

            if (i == position) return currentNode.content;
            currentNode = currentNode.next;
        }

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
        checkPositionRange(position);
        if (isEmptyHeader()) throw new IllegalStateException("List is empty");

        if (position == 0) {
            Node<E> nextNode = head.next;
            head.content = null;
            head.next = null;
            head = nextNode;
            --size;
            return;
        }

        Node<E> currentNode = head.next;
        Node<E> prevNode = head;

        for (int i = 1; currentNode != null; i++) {

            if (i == position) {
                Node<E> tempNode = currentNode.next;
                currentNode.content = null;
                currentNode.next = null;
                prevNode.next = tempNode;
                --size;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public void clear() {
        if (isEmptyHeader()) return;

        Node<E> currentNode = head;

        while (currentNode != null) {
            Node<E> nextNode = currentNode.next;
            currentNode.content = null;
            currentNode.next = null;
            currentNode = nextNode;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkPositionRange(int position) {
        if (position > size || position < 0)
            throw new IndexOutOfBoundsException("position: "+position+" size: "+size);
    }


    private boolean isEmptyHeader() {
        return (head == null);
    }
}
