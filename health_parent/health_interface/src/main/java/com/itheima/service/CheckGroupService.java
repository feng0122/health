package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    /**
     * 添加检查组
     * @param checkGroup
     * @param checkitemIds
     */
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    PageResult<CheckGroup> findPage(QueryPageBean queryPageBean);

    CheckGroup findById(Integer checkGroupId);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer checkGroupIds);


    void deleteById(Integer id) throws MyException;
}
