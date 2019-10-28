package cn.han.house.mapper;


import cn.han.house.entity.District;
import cn.han.house.entity.DistrictExample;
import cn.han.house.entity.Street;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //删除区域下的街道
    int deleteStreetByDistrict(Integer id);

    int delMore(Integer[] mid);

    int delMoreDis(Integer[] mid);

    @Select("select * from street where DISTRICT_ID = #{id}")
    List<Street> selectStreet(Integer id);
}