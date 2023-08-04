package linked_list;


import org.junit.Test;

/**
 * @Author: suwg
 * @Date: 2023/8/4
 */
public class LinkedListTest {

    @Test
    public void testLinkList() {
        List<String> list = new LinkedList<>();
        list.add("加一个元素");
        list.addFirst("头插一个元素");
        list.addLast("尾插一个元素");
        list.printLinkList();
        list.remove("加一个元素");
        list.printLinkList();
    }
}
