package cn.han.house.pcontroller;

import cn.han.house.entity.House;
import cn.han.house.entity.Users;
import cn.han.house.servies.HouseService;
import cn.han.house.util.HouseCondition;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/20
 * @Description:
 */
@Controller(value = "houseController2")
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("addHouse")
    public String addHouse(House house
            , HttpSession session,
            @RequestParam(value = "pfile",required = false) MultipartFile pfile){
        try {
        String originalFilename = pfile.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String bh = System.currentTimeMillis()+"";
        String filename=bh+extName;
        String path="d:\\images\\"+filename;
        File savaFile = new File(path);
        pfile.transferTo(savaFile);
        house.setId(bh);
        house.setPath(filename);
        Users user = (Users) session.getAttribute("userinfo");
        house.setUserId(user.getId());
        houseService.addHouse(house);
        return "redirect:getUserHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("getUserHouse")
    public String getUserHouse(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("userinfo");
        List<House> houseList = houseService.getHouseByUserId(user.getId());
        model.addAttribute("houseList",houseList);
        return "guanli";
    }

    @RequestMapping("showHouse")
    public String showHouse(String id,Model model){
        House house = houseService.getHouseById(id);
        model.addAttribute("house",house);
        return "upfabu";
    }

    @RequestMapping("updateHouse")
    public String updateHouse(House house
            , String oldPic,
            @RequestParam(value = "pfile",required = false)
            MultipartFile pfile){
        try {
        if (!pfile.isEmpty()){
            String sourceFile = pfile.getOriginalFilename();
            String extName = sourceFile.substring(sourceFile.lastIndexOf("."));
            String bh=System.currentTimeMillis()+"";
            String filename=bh+extName;
            String path="d:\\images\\"+filename;
            File saveFile=new File(path);
            pfile.transferTo(saveFile);
            house.setPath(filename);
        }
        houseService.updateHouse(house);
        if (!pfile.isEmpty()){
            //删除旧的图片
            File file=new File("D:\\images\\"+oldPic);
            file.delete();
        }
        return "redirect:getUserHouse";
    }catch (Exception e){
        e.printStackTrace();
    }
        return "error";
    }

    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        int i = houseService.delHouse(id, 1);

        return "{\"result\":"+i+"}";
    }

    //查询用户浏览的出租房
    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition condition, Model model){
        //调用业务
        condition.setRows(3);  //页大小默认3条
        PageInfo<House> houses=houseService.getHouseByBroswer(condition);
        //填充信息到Model
        model.addAttribute("houses",houses);
        model.addAttribute("conditioin",condition);
        return "list";
    }
}
