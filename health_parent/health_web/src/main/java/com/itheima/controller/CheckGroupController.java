package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;
    /*
    * 添加检查组方法
    * */
    @RequestMapping("/add")
    public  Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        checkGroupService.add(checkGroup,checkitemIds);

        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
    /*
     * 分页显示
     * */
    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
      PageResult<CheckGroup> page= checkGroupService.findPage(queryPageBean);

      return new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS,page);

    }
    /**
     * 通过id获取检查组
     */
    @GetMapping("/findById")
    public Result findById(Integer checkGroupId){
      CheckGroup checkGroup=  checkGroupService.findById(checkGroupId);
      return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);

    }

    /**
     * 通过检查组id查询选中的检查项id
     */
    @GetMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(Integer checkGroupId){
        List<Integer> checkItemIds= checkGroupService.findCheckItemIdsByCheckGroupId(checkGroupId);
      return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItemIds);

    }
    @GetMapping("/deleteById")
    public Result deleteById(Integer id){
        checkGroupService.deleteById(id);
        return new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS);

    }
 }
