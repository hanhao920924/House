package cn.han.house.servies.impl;


import cn.han.house.entity.District;
import cn.han.house.entity.DistrictExample;
import cn.han.house.entity.Street;
import cn.han.house.mapper.DistrictMapper;
import cn.han.house.servies.DistrictService;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/13
 * @Description:
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getAllDistrict() {

        return districtMapper.selectByExample(new DistrictExample());
    }

    @Override
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询所有
        DistrictExample districtExample = new DistrictExample();
        List<District> districtList = districtMapper.selectByExample(districtExample);
        //获取分页信息
        PageInfo<District> pageInfo = new PageInfo(districtList);
        return pageInfo;
    }

    @Override
    public boolean insertDistrict(District district) {
        int i = districtMapper.insertSelective(district);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDistrict(District district) {
        int i = districtMapper.updateByPrimaryKeySelective(district);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delDistrict(Integer id) {
        districtMapper.deleteStreetByDistrict(id);
        districtMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public int delMores(String ids) {
        String[] split = ids.split(",");
        Integer[] idss=new Integer[split.length];
        for (int i = 0; i < idss.length; i++) {
            idss[i]=Integer.valueOf(split[i]);
        }
        int i = districtMapper.delMore(idss);
        int r = districtMapper.delMoreDis(idss);
        return r;
    }

    @Override
    public PageInfo<Street> streeInfo(PageUtil pageUtil, Integer id) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<Street> streets = districtMapper.selectStreet(id);
        return new PageInfo<>(streets);
    }
}
