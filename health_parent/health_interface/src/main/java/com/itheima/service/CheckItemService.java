package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {

    /**
     * 查询所有的检查项
     * @return
     */
    List<CheckItem> findAll();

    /**
     * 添加检查项
     * @param checkItem
     */

    void save(CheckItem checkItem);



    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);


    void deleteById(Integer id) throws MyException;



    void update(CheckItem checkItem);
    /**
     * 通过id查询
     * @param id
     * @return
     */
    CheckItem findById(int id);

}
