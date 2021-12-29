package com.valid.result.response;


import com.valid.result.code.CommonError;

import java.util.ArrayList;
import java.util.List;

public class ResponseList<T> extends Response {

    public static <T> ResponseList<T> success(List<T> data, Long total) {
        return new ResponseList(data, total);
    }

    public static <T> ResponseList<T> empty() {
        return new ResponseList(new ArrayList(0), 0L);
    }

    protected ResponseList(List<T> data, Long total) {
        this(CommonError.SUCCESS.getCode(), data, total, CommonError.SUCCESS.getMsg());
    }

    protected ResponseList(int code, List<T> data, Long total, String message) {
        super(code, (Object) null, message);
        PageData<T> pageData = new PageData();
        if (null == total) {
            total = 0L;
        }
        if (null == data) {
            data = new ArrayList();
            pageData.setSize(0L);
        } else {
            pageData.setSize((long) ((List) data).size());
        }
        pageData.setList((List) data);
        pageData.setTotal(total);
        this.setData(pageData);
    }

    protected class PageData<T> {

        private List<T> list;
        private Long size;
        private Long total;

        protected PageData() {
        }

        public List<T> getList() {
            return this.list;
        }

        public void setList(List<T> records) {
            this.list = records;
        }

        public Long getSize() {
            return this.size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public Long getTotal() {
            return this.total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }
    }

}