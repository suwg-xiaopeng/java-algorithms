package linked_list;

/**
 * 链表接口类.
 *
 * @Author: suwg
 * @Date: 2023/8/4
 */
public interface List<E> {

    /**
     * 添加元素.
     *
     * @param e
     * @return
     */
    boolean add(E e);


    /**
     * 链表头插.
     */
    boolean addFirst(E e);


    /**
     * 链表尾插.
     */
    boolean addLast(E e);

    /**
     * 链表删除节点.
     */
    boolean remove(E e);

    /**
     * 获取节点值.
     */
    E get(int index);

    /**
     * 打印链表.
     */
    void printLinkList();


}
