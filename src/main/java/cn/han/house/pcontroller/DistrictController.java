package cn.han.house.pcontroller;

import cn.han.house.entity.District;
import cn.han.house.entity.Street;
import cn.han.house.servies.DistrictService;
import cn.han.house.servies.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/20
 * @Description:
 */
@Controller(value = "districtController2")
@RequestMapping("/page/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService streetService;

    //查询所有区域
    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        return districtService.getAllDistrict();
    }

    //通过区域编号查询街道
    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street> getStreetByDid(Integer did){
        return streetService.getStreetByDistrictId(did);
    }
}
