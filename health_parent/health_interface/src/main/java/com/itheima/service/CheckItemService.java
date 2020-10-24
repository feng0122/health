package com.itheima.service;

import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {

    /**
     * 查询所有的检查项
     * @return
     */
    List<CheckItem> findAll();

    void save(CheckItem checkItem);
}
