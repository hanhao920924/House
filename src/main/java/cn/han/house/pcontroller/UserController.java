package cn.han.house.pcontroller;


import cn.han.house.entity.Users;
import cn.han.house.servies.UserService;
import cn.han.house.util.UserCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/13
 * @Description:
 */
@Controller(value = "userController2")
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public String reg(Users users){
        int i = userService.addUser(users);
        if (i>0){
            return "login";
        }else {
            return "regs";
        }
    }

    //检查用户名
    @RequestMapping("checkName")
    @ResponseBody  //{"result":1|0}
    public String checkName(String name){
        //调用业务
        int i=userService.checkUserName(name);
        return "{\"result\":"+i+"}";
    }

    //注册
    @RequestMapping("loginAction")
    public String loginAction(String name, String password, HttpSession session){
        Users user=userService.login(name,password);
        if(user!=null) {
            //就使用session保存登入的人
            session.setAttribute("userinfo",user);
            //设置session的有效期
            session.setMaxInactiveInterval(600);  //10分钟
            return "redirect:getUserHouse";  //后台管理页
        }else
            return "login";  //登入页
    }
}
