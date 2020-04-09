package com.core.controller;

import java.util.Arrays;

/**
 * @author wjq
 * @version 1.0
 * @Title: ArrayListDemo
 * @Package com.core.controller
 * @Description:
 * @date 2020/4/9 20:04
 */
public class ArrayListDemo {

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


    /**
     * add 方法
     * @param e
     * @return
     */
    public boolean add(Object e) {

        ensureExplicitCapacity(calculateCapacity(elementData, size + 1));
        elementData[size++] = e;
        return true;
    }

//    private void ensureCapacityInternal(int minCapacity) {
//        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
//    }

    /**
     * 判断初始化值，这里进行动态扩容逻辑
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
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 创建数组并返回
     * @param minCapacity
     */
    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }


    /**
     * 移除
     * @param index
     * @return
     */
    public Object remove(int index) {

        /**
         * 判断下标是否合法
         */
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        Object oldValue = (Object)elementData[index];

        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;

        return oldValue;
    }
}
