package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.StringUtil;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(interfaceClass = CheckGroupService.class)
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    @Transactional
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        // 1.添加检查组
        checkGroupDao.add(checkGroup);
        // 2.获取检查组的id
        Integer checkGroupId = checkGroup.getId();
        //3. 添加检查组id与检查项的关系
        if(checkitemIds!=null){
            for (Integer checkitemId : checkitemIds) {
                checkGroupDao.addCheckGroupCheckItem(checkGroupId,checkitemId);
            }
        }

    }

    @Override

    public PageResult<CheckGroup> findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());

        if(!StringUtil.isEmpty(queryPageBean.getQueryString())){

            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
      Page<CheckGroup> page=  checkGroupDao.findPage(queryPageBean.getQueryString());
        return new PageResult<CheckGroup>(page.getTotal(),page.getResult());
    }

    @Override
    public CheckGroup findById(Integer checkGroupId) {
    CheckGroup checkGroup=    checkGroupDao.findById(checkGroupId);
    return checkGroup;
    }

    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer checkGroupIds) {
     List<Integer> findCheckItemIds=   checkGroupDao.findCheckItemIdsByCheckGroupId(checkGroupIds);

     return findCheckItemIds;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // 1.判断id是否被被套餐使用
     int cow =  checkGroupDao.findSetmeal2form(id);
     if(cow>0){
         throw new MyException("被套餐使用了,不能删除");

     }
     // 2.没有被套餐使用,删除组与项的关联
        checkGroupDao.deleteCheckGroupCheckItem(id);

     // 3.删除
        // 删除检查组
        checkGroupDao.deleteById(id);


    }
}
