package structures.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eduardo.graciano on 3/6/18.
 */
public class SingleLinkedListHTest {

    @Test
    public void getFrom_0() throws Exception {
        IList<String> content = buildContent();

        assertNotNull(content.getFrom(0));
        assertEquals(content.getFrom(0), "String0");
    }
    @Test
    public void getFrom_1() throws Exception {
        IList<String> content = buildContent();

        assertNotNull(content.getFrom(1));
        assertEquals(content.getFrom(1), "String1");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFrom_negative() throws Exception {
        IList<String> content = buildContent();

        content.getFrom(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFrom_out() throws Exception {
        IList<String> content = buildContent();

        content.getFrom(10);
    }
    @Test
    public void getFrom_last() throws Exception {
        IList<String> content = buildContent();

        assertNotNull(content.getFrom(content.size() - 1));
        assertEquals(content.getFrom(content.size() - 1), "String4");
    }

    @Test
    public void add_1() throws Exception {
        IList<String> content = new SingleLinkedListH<>();

        content.add("String");

        assertEquals(1, content.size());
        assertEquals("String", content.getFrom(0));
    }

    @Test
    public void add_2() throws Exception {
        IList<String> content = new SingleLinkedListH<>();

        content.add("String");
        content.add("String1");

        assertEquals(2, content.size());
        assertEquals("String", content.getFrom(0));
        assertEquals("String1", content.getFrom(1));
    }

    @Test
    public void removeFrom_0() throws Exception {
        IList<String> content = buildContent();
        content.removeFrom(0);
        assertEquals(content.getFrom(0), "String1");
    }

    @Test
    public void removeFrom_1() throws Exception {
        IList<String> content = buildContent();
        content.removeFrom(1);
        assertEquals(content.getFrom(1), "String2");
    }

    @Test
    public void removeFrom_last() throws Exception {
        IList<String> content = buildContent();
        content.removeFrom(content.size() - 1);
        assertEquals(content.getFrom(content.size() - 1), "String3");
    }

    @Test
    public void clear() throws Exception {
        IList<String> content = buildContent();

        content.clear();

        assertEquals(0, content.size());
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

    private IList<String> buildContent() {
        IList<String> content = new SingleLinkedListH<>();

        content.add("String0");
        content.add("String1");
        content.add("String2");
        content.add("String3");
        content.add("String4");

        return content;
    }
}