package cn.han.house.controller;

import cn.han.house.entity.District;
import cn.han.house.entity.Street;
import cn.han.house.servies.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){

        return districtService.getAllDistrict();
    }

    //前端  datagrid 自动传参
    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        PageInfo<District> pageInfo = districtService.getDistrictByPage(pageUtil);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public HashMap<String, Object> addDistrict(District record){
        boolean list = districtService.insertDistrict(record);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result",list);
        return map;
    }

    @RequestMapping("upDistrict")
    @ResponseBody
    public HashMap<String, Object> upDistrict(District district){
        boolean list = districtService.updateDistrict(district);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result",list);
        return map;
    }

    //删除区域
    @RequestMapping("delDistrict")
    @ResponseBody
    public Map<String,Object> upDistrict(Integer id){
        //调用业务
        boolean b = districtService.delDistrict(id);
        //使用map封装返回的数据

        Map<String,Object> map=new HashMap<>();
        map.put("result",b);  //自动将对象转化为json
        return map;
    }

    @RequestMapping("delMoreDis")
    @ResponseBody
    public Map<String,Object> delMore(String ids){
        //调用业务
        int i = districtService.delMores(ids);
        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",i);  //自动将对象转化为json
        return map;
    }

    @RequestMapping("streetShow")
    @ResponseBody
    public Map<String,Object> streetShow(PageUtil pageUtil,Integer id){
        //调用业务
        PageInfo<Street> pageInfo = districtService.streeInfo(pageUtil, id);
        //使用map封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

}
