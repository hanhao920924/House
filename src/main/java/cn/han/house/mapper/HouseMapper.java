package cn.han.house.mapper;

import cn.han.house.entity.House;
import cn.han.house.entity.HouseExample;
import cn.han.house.util.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> getHouseByUserId(Integer id);

    /**
     * 查询某条出租房信息
     * @param id
     * @return
     */
    House getHouseById(String id);

    /**
     * 查询所有未/已审核的出租房
     * @param state 状态 是否审核
     * @return
     */
    List<House> getHouseByPassState(Integer state);

    /**
     * 实现浏览出租房   插件分页，无需考虑分页
     * @param condition
     * @return
     */
    List<House> getHouseByBroswer(HouseCondition condition);

}