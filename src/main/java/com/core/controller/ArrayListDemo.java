package com.core.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author wjq
 * @version 1.0
 * @Title: ArrayListDemo
 * @Package com.core.controller
 * @Description:
 * @date 2020/4/9 20:04
 */
public class ArrayListDemo<E> {

    /**
     * 初始化数组大大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 默认空数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 元素
     */
    transient Object[] elementData;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * size
     */
    private int size;

    /**
     * 数组变更记录
     */
    protected transient int modCount = 0;


    public ArrayListDemo() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayListDemo(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }


    /**
     * add 方法
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 判断初始化值
     *
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //数组元素是空的
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //默认数组与当前数组大小进行比较
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        //数组变更记录
        modCount++;

        //判断是否需要进行动态扩容，在默认数组长度以下，都不需要进行扩容
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 创建数组并返回 ，这里进行动态扩容逻辑
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {

        //当前元素长度进行赋值
        int oldCapacity = elementData.length;
        //当前数组长度+位移运算进行扩容 10>>1 = 5 ,以此类推 所以这里是进行的1.5倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        //返回扩容后新的数组对象，赋值到elementData
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }


    /**
     * remove index 方法
     *
     * @param index
     */
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);
        //这里其实很有意思，他将我要移除的数组下标进行计算，得出后续要进行前靠的数组，移除之前的数组不动，移除以后的数组逐个往前移动，保证不浪费任何一个数组元素
        int numMoved = size - index - 1;
        if (numMoved > 0)
        /**
         *  参数释义：
         *      原始数组
         *      原始数组的起始位置
         *      目标数组
         *      目标数组的起始位置
         *      复制的元素数量
         *      eg:elementData,4,elementData,3,6
         */

            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    /**
     * remove object
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }


    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
    }


    public static void main(String[] args) {
        System.err.println(16 >> 1);
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        System.err.println(objects.get(0));
        ArrayList<Integer> objects1 = new ArrayList<>(objects);
        System.err.println(objects.get(0));
        System.err.println(objects1.get(0));
        System.err.println(objects.size());

    }

}
