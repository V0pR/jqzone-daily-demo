package com.core.common.dto;

import java.util.List;

/**
 * Created by rocky on 2017/07/11.
 * <p>
 * API响应结果包装类
 */
public class ResultWrapper<T> {


    private final T module;

    private final Integer code;

    private final String message;

    public static ResultWrapper error(Integer code, String message) {
        return new ResultWrapper(null, code, message);
    }

    public static <T> ResultWrapper valueOf(T module) {
        return new ResultWrapper(module, 200, "执行成功");
    }

    public ResultWrapper(T module, Integer code, String message) {
        this.module = module;
        this.code = code;
        this.message = message;
    }

    public T getModule() {
        return module;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "module=" + module +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public static class PagedList<E> {

        private List<E> list;

        private int pageIndex;

        private int pageSize;

        private int totalCount;

        private int totalPageCount;

        public List<E> getList() {
            return list;
        }

        public void setList(List<E> list) {
            this.list = list;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalPageCount(int totalPageCount) {
            this.totalPageCount = totalPageCount;
        }

        public int getTotalPageCount() {
            return totalPageCount;
        }

        @Override
        public String toString() {
            return "PagedList{" +
                    "list=" + list +
                    ", pageIndex=" + pageIndex +
                    ", pageSize=" + pageSize +
                    ", totalCount=" + totalCount +
                    ", totalPageCount=" + totalPageCount +
                    '}';
        }
    }
}
