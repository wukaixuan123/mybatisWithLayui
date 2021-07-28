package com.hdax.until;

import com.hdax.pojo.Student;

import java.util.List;

public class pageConfig {
    //定义分页需要的变量
    //已知变量
    private int page;//页码
    private int limit;//每页个数
    //需要计算
    private int startIndex;//开始位置
    private int endIndex;//结束位置
    private int count;//数据总量

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public pageConfig(){

    }
    public pageConfig(int page,int limit,int count){
        this.page = page;
        this.limit= limit;
        this.count=count;
        getSuanCount();
    }
    //计算数据总量 和 开始位置
    public void getSuanCount(){
        this.startIndex = (page-1)*limit;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    private List<Student> list;
}
