package cn.han.house.servies.impl;

import cn.han.house.entity.Street;
import cn.han.house.entity.StreetExample;
import cn.han.house.mapper.StreetMapper;
import cn.han.house.servies.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/20
 * @Description:
 */
@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public List<Street> getStreetByDistrictId(Integer disstrictId) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(disstrictId);
        List<Street> streetList = streetMapper.selectByExample(streetExample);
        return streetList;
    }
}
