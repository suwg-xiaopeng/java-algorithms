package linked_list;

/**
 * @Author: suwg
 * @Date: 2023/8/4
 */
public class LinkedList<E> implements List<E> {


    //transient 修饰的变量不参与序列化
    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }


    /**
     * ？表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     */
    //static 修饰的内部类只能访问外部类的静态成员变量和方法
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }

    /**
     * 头插元素方法.
     *
     * @param e
     * @return
     */

    void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode; //头节点指向新插入的节点
        //如果头节点为空，说明链表为空，尾节点也是新插入的节点
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 尾插元素方法.
     *
     * @param e
     * @return
     */

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode; //尾节点指向新插入的节点
        //如果尾节点为空，说明链表为空，头节点也是新插入的节点
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 拆链.
     *
     * @param x
     * @return
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        //如果前驱节点为空，说明是头节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        //如果后继节点为空，说明是尾节点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }


    //添加元素 尾插法.
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        //遍历链表，找到o元素，删除，根据o元素是否为空，调整判断方法.
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }


    // 1. size >> 1 位运算，右移一位，相当于除以2，这里是为了找到中间节点
    // 2. 从头节点开始遍历，如果index小于size的一半，就从头节点开始遍历，否则从尾节点开始遍历
    // 3. 从头节点开始遍历，index=0，就返回头节点，index=1，就返回头节点的下一个节点，以此类推
    // 4. 从尾节点开始遍历，index=size-1，就返回尾节点，index=size-2，就返回尾节点的上一个节点，以此类推
    // 5. 为什么要这样做？因为双向链表，每个节点都有上一个节点和下一个节点的引用，所以可以从头节点开始遍历，也可以从尾节点开始遍历
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next; //从头节点开始遍历
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev; //从尾节点开始遍历
            }
            return x;
        }

    }

    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.print(temp.item + ", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
