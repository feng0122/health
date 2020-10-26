package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao {
    /**
     * 添加检查组
     * @param checkGroup
     */
    public void add(CheckGroup checkGroup);
    /**
     * 添加检查组与检查项的关系
     * @param checkGroupId 注意要取别名，类型相同
     * @param checkitemId
     */
    public void addCheckGroupCheckItem(@Param("checkGroupId") Integer checkGroupId,@Param("checkitemId") Integer checkitemId);

    Page<CheckGroup> findPage(String queryString);

    CheckGroup findById(Integer checkGroupId);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer checkGroupIds);

    int findSetmeal2form(Integer id);

    void deleteCheckGroupCheckItem(Integer id);

    void deleteById(Integer id);
}
