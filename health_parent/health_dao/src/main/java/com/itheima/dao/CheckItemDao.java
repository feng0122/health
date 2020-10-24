package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    /**
     * 查询 所有检查项
     * @return
     */
    List<CheckItem> findAll();

    void save(CheckItem checkItem);

    Page<CheckItem> findPage(String queryString);

    int findCountByCheckItemId(Integer id);

    void deleteById(Integer id);
}
