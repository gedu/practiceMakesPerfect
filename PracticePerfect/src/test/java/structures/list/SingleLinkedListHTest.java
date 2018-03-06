package structures.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eduardo.graciano on 3/6/18.
 */
public class SingleLinkedListHTest {


    @Test
    public void getFrom() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void removeFrom() throws Exception {
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void size() throws Exception {
        IList<String> content = new SingleLinkedListH<>();

        assertEquals(0, content.size());

        content.add("String");

        assertEquals(1, content.size());

        content.add("String2");

        assertEquals(2, content.size());
    }

}