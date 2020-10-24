package com.itheima.dao;

import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    /**
     * 查询 所有检查项
     * @return
     */
    List<CheckItem> findAll();

    void save(CheckItemDao checkItemDao);
}
