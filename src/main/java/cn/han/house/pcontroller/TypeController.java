package cn.han.house.pcontroller;

import cn.han.house.entity.Type;
import cn.han.house.servies.TypeService;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/13
 * @Description:
 */
@Controller(value = "typeController2")
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
        return typeService.getAllType();
    }



}
