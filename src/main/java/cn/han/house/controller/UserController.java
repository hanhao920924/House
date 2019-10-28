package cn.han.house.controller;


import cn.han.house.entity.Users;
import cn.han.house.servies.UserService;
import cn.han.house.util.UserCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/13
 * @Description:
 */
@Controller
@RequestMapping("/admin/")
public class UserController {
    @Autowired
    private UserService userService;

    //前端  datagrid 自动传参
    @RequestMapping("getUserByPage")
    @ResponseBody
    public Map<String,Object> getUserByPage(UserCondition condition){
        PageInfo<Users> pageInfo = userService.getUserByCondition(condition);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
}
