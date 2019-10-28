package cn.han.house.servies.impl;

import cn.han.house.entity.House;
import cn.han.house.mapper.HouseMapper;
import cn.han.house.servies.HouseService;
import cn.han.house.util.HouseCondition;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/20
 * @Description:
 */

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        house.setIsdel(0);
        house.setIspass(0);
        return houseMapper.insertSelective(house);
    }

    @Override
    public List<House> getHouseByUserId(Integer id) {
        return houseMapper.getHouseByUserId(id);
    }

    @Override
    public House getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id,Integer state) {
        House house = new House();
        house.setId(id);
        house.setIsdel(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> list=houseMapper.getHouseByPassState(state);
        return new PageInfo<House>(list);
    }

    @Override
    public int updateHousePassState(String id, Integer state) {
        House  house=new House();
        house.setId(id);
        house.setIspass(state);
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByBroswer(HouseCondition condition) {
        //开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //查询
        List<House> list=houseMapper.getHouseByBroswer(condition);
        //获取分页信息
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
