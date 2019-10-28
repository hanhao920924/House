package cn.han.house.controller;

import cn.han.house.entity.House;
import cn.han.house.servies.HouseService;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/24
 * @Description:
 */
@Controller
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("getHouseNoPass")
    @ResponseBody
    public Map<String,Object> getHouseNoPass(PageUtil page){
        //调用业务    0表示未审核
        PageInfo<House> house=this.houseService.getHouseByPassSate(0,page);
        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHousePass")
    @ResponseBody
    public String goHousePass(String id){
        //调用业务审核 1表示通过审核
        int temp=this.houseService.updateHousePassState(id,1);
        return "{\"result\":"+temp+"}";
    }


    @RequestMapping("getHousePass")  //eastui datagrid自动传page,rows
    @ResponseBody
    public Map<String,Object> getHousePass(PageUtil page){
        //调用业务    0表示未审核
        PageInfo<House> house=this.houseService.getHouseByPassSate(1,page);
        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHouseNotPass")
    @ResponseBody
    public String goHouseNotPass(String id){
        //调用业务审核 1表示通过审核
        int temp=this.houseService.updateHousePassState(id,0);
        return "{\"result\":"+temp+"}";
    }

}
