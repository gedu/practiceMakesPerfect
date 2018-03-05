package structures.list;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eduardo.graciano on 3/2/18.
 */
public class ListArrayTest {

    @Test
    public void getFrom_0() throws Exception {
        IList<String> content = buildContent();

        String item = content.getFrom(0);

        assertEquals("String", item);
    }

    @Test
    public void getFrom_3() throws Exception {
        IList<String> content = buildContent();

        String item = content.getFrom(3);

        assertEquals("String4", item);
    }

    @Test
    public void getFrom_last() throws Exception {
        IList<String> content = buildContent();

        String item = content.getFrom(content.size() - 1);

        assertEquals("String5", item);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFrom_throw() throws Exception {
        IList<String> content = buildContent();

        String item = content.getFrom(content.size());

        assertEquals("String5", item);
    }

    @Test
    public void add_one_element() throws Exception {
        IList<String> content = new ListArray<>();

        content.add("String");

        assertEquals(1, content.size());
    }

    @Test
    public void add_two_elements() throws Exception {
        IList<String> content = new ListArray<>();

        content.add("String");
        content.add("String2");

        assertEquals(2, content.size());
    }

    @Test
    public void add_30_elements() throws Exception {
        IList<String> content = new ListArray<>();

        for (int i = 0; i < 30; i++) {
            content.add("String");
        }

        assertEquals(30, content.size());
    }

    @Test
    public void removeFrom_0() throws Exception {
        IList<String> content = buildContent();

        content.removeFrom(0);

        assertEquals(content.getFrom(0), "String2");
        assertEquals(content.getFrom(1), "String3");
        assertEquals(content.getFrom(2), "String4");
        assertEquals(content.getFrom(3), "String5");
    }

    @Test
    public void removeFrom_2() throws Exception {
        IList<String> content = buildContent();

        content.removeFrom(2);

        assertEquals(content.getFrom(0), "String");
        assertEquals(content.getFrom(1), "String2");
        assertEquals(content.getFrom(2), "String4");
        assertEquals(content.getFrom(3), "String5");
    }

    @Test
    public void removeFrom_4() throws Exception {
        IList<String> content = buildContent();

        content.removeFrom(3);

        assertEquals(content.getFrom(0), "String");
        assertEquals(content.getFrom(1), "String2");
        assertEquals(content.getFrom(2), "String3");
        assertEquals(content.getFrom(3), "String5");
    }

    @Test
    public void removeFrom_last() throws Exception {
        IList<String> content = buildContent();

        content.removeFrom(content.size() - 1);

        assertEquals(content.getFrom(0), "String");
        assertEquals(content.getFrom(1), "String2");
        assertEquals(content.getFrom(2), "String3");
        assertEquals(content.getFrom(3), "String4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFrom_outIndex() throws Exception {
        IList<String> content = buildContent();

        content.removeFrom(content.size());
    }

    @Test
    public void clear() throws Exception {
        IList<String> content = buildContent();

        content.clear();

        assertEquals(0, content.size());
    }

    @Test
    public void size_using_default() throws Exception {
        IList<String> content = new ListArray<>();

        assertEquals(0, content.size());
    }

    @Test
    public void size_using_five() throws Exception {
        IList<String> content = new ListArray<>(5);

        assertEquals(0, content.size());
    }

    @Test
    public void size_using_100() throws Exception {
        IList<String> content = new ListArray<>(100);

        assertEquals(0, content.size());
    }

    @Test
    public void java_list_bench_first() {
        List<String> content = new ArrayList<>();

        for (int i = 0; i < 10000; i++) content.add("String");
        for (int i = 0; i < 10000; i++) content.remove(0);

        assertEquals(content.size(), 0);
    }

    @Test
    public void my_list_bench_first() {
        IList<String> content = new ListArray<>();

        for (int i = 0; i < 10000; i++) content.add("String");
        for (int i = 0; i < 10000; i++) content.removeFrom(0);

        assertEquals(content.size(), 0);
    }

    @Test
    public void java_list_bench_last() {
        List<String> content = new ArrayList<>();

        for (int i = 0; i < 10000; i++) content.add("String");
        for (int i = 0; i < 10000; i++) content.remove(content.size() - 1);

        assertEquals(content.size(), 0);
    }

    @Test
    public void my_list_bench_last() {
        IList<String> content = new ListArray<>();

        for (int i = 0; i < 10000; i++) content.add("String");
        for (int i = 0; i < 10000; i++) content.removeFrom(content.size() - 1);

        assertEquals(content.size(), 0);
    }

    private IList<String> buildContent() {
        IList<String> content = new ListArray<>();

        content.add("String");
        content.add("String2");
        content.add("String3");
        content.add("String4");
        content.add("String5");

        return content;
    }

}