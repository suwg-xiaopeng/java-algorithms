package array_list;

/**
 * 数组的接口类.
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
     * 删除元素.
     *
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 获取元素.
     *
     * @param index
     * @return
     */
    E get(int index);

}
