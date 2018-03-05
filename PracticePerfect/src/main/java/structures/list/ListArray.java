package structures.list;

/**
 * Created by eduardo.graciano on 3/2/18.
 */
public class ListArray<E> implements IList<E> {

    public static final int DEFAULT_CAPACITY = 10;
    private Object[] content;
    private int size = 0;

    public ListArray() {
        this.content = new Object[DEFAULT_CAPACITY];
    }

    public ListArray(int capacity) {
        this.content = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E getFrom(int position) {
        validate(position);
        return get(position);
    }

    @Override
    public void add(E item) {
        expandIfNeeded();
        content[size] = item;
        ++size;
    }

    @SuppressWarnings("ManualArrayCopy")
    private void expandIfNeeded() {
        if (size == content.length - 1) {
            int newSize = content.length >> 1;
            Object[] newContent = new Object[content.length + newSize];

            for (int i = 0; i < content.length; i++) {
                newContent[i] = content[i];
            }

            content = newContent;
        }
    }

    @SuppressWarnings("unchecked")
    private E get(int pos) {
        return (E) content[pos];
    }

    //Remove and item using the position/index, it is slower than
    //the one java propose, why because of the copy. Java copy
    //the array using c/c++ code which make the coping ~x10 faster
    @SuppressWarnings({"unchecked", "ManualArrayCopy"})
    @Override
    public void removeFrom(int position) {
        validate(position);

        if (position == size - 1) {
            content[--size] = null;
        } else {
            content[position] = null;

            for (int i = position; i < size; i++) {
                content[i] = content[i + 1];
            }

            content[--size] = null;
        }
    }

    private void fastRemove(int position) {
        System.arraycopy(content, position+1, content, position, size - position - 1);
        content[--size] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < content.length; i++) {
            content[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void validate(int position) {
        if (position >= size) {
            throw new ArrayIndexOutOfBoundsException("Requested element from position: " + position +" and the size is: "+size);
        }
    }
}
