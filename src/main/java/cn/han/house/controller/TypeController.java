package cn.han.house.controller;

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
@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getAllType")
    @ResponseBody
    public List<Type> getAllType(){
        return typeService.getAllType();
    }

    //前端  datagrid 自动传参
    @RequestMapping("getTypeByPage")
    @ResponseBody
    public Map<String,Object> getTypeByPage(PageUtil pageUtil){
        PageInfo<Type> pageInfo = typeService.getTypeByPage(pageUtil);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("addType")
    @ResponseBody
    public HashMap<String, Object> addType(Type record){
        boolean list = typeService.insertType(record);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result",list);
        return map;
    }

    @RequestMapping("upType")
    @ResponseBody
    public HashMap<String, Object> upType(Type type){
        boolean list = typeService.updateType(type);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result",list);
        return map;
    }

    //删除区域
    @RequestMapping("delType")
    @ResponseBody
    public Map<String,Object> delType(Integer id){
        //调用业务
        boolean b = typeService.delType(id);
        //使用map封装返回的数据

        Map<String,Object> map=new HashMap<>();
        map.put("result",b);  //自动将对象转化为json
        return map;
    }

    @RequestMapping("delMore")
    @ResponseBody
    public Map<String,Object> delMore(String ids){
        //调用业务
        int i = typeService.delMores(ids);
        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",i);  //自动将对象转化为json
        return map;
    }

}
