package com.itheima.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> all = checkItemDao.findAll();
        return all;
    }

    @Override
    public void save(CheckItem checkItem) {
        checkItemDao.save(checkItem);

    }

    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        // 当前页和页面大小
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        // 判断是否有查询条件
        if(!StringUtils.isEmpty(queryPageBean.getQueryString())){
            // 不为空,进行模糊查询拼接
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        Page<CheckItem> page=checkItemDao.findPage(queryPageBean.getQueryString());

        PageResult<CheckItem> pageResult=new PageResult<CheckItem>(page.getTotal(),page.getResult());
        return pageResult;

    }
}
