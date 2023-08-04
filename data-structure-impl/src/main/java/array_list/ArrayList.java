package array_list;

import java.util.Arrays;

/**
 * ArrayList 实现类.
 *
 * @Author: suwg
 * @Date: 2023/8/4
 */
public class ArrayList<E> implements List<E> {


    /**
     * 默认初始化容量.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素.
     *
     * @param e
     * @return
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * ArrayList 元素数据缓存区.
     *
     * @param e
     * @return
     */
    transient Object[] elementData;

    /**
     * List 集合元素数量.
     *
     * @param e
     * @return
     */
    private int size;

    public ArrayList() {
        // 默认给个空的元素，当开始添加元素的时候再初始化长度
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENTDATA;
    }


    @Override
    public boolean add(E e) {
        //确保内部容量
        int minCapacity = size + 1;
        //如果是空元素，初始化容量为10,否则为size+1
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENTDATA) {
            //取最大值
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        //判断扩容操作
        if (minCapacity - elementData.length > 0) {
            //旧容量
            int oldCapacity = elementData.length;
            //扩容1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果原容量扩大1.5倍后仍不够，则按实际元素数量扩容.
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        //添加元素
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            //从原始数据的某个位置，拷贝到目标对象的某个位置开始后n个元素，从index+1开始，复制到index
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;//清除，让GC工作
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

}
