package cn.han.house.servies;

import cn.han.house.entity.House;
import cn.han.house.util.HouseCondition;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {
    /**
     * 发布出租房
     * @param house  实体
     * @return 影响行数
     */
    public int addHouse(House house);

    public List<House> getHouseByUserId(Integer id);

    /**
     * 查询某条出租房信息
     * @param id 出租房编号
     * @return 出租房实体
     */
    public House getHouseById(String id);

    /**
     * 修改出租房
     * @param house
     * @return  影响行数
     */
    public int updateHouse(House house);

    /**
     * 修改出租房状态
     * @param id 出租房编号
     * @param state 出租房状态  1 删除    0还原
     * @return  影响行数
     */
    public int delHouse(String id,Integer state);

    /**
     * 查询已审核|未审核的出租房信息
     * @param state 状态 0表示未审核 1表示审核通过
     * @return 所有的出租房信息
     */
    public PageInfo<House> getHouseByPassSate(Integer state, PageUtil pageUtil);

    /**
     * 修改出租房的审核状态
     * @param id 出租房编号
     * @param state 出租房状态 0未审核  1已审核
     * @return 影响行数
     */
    public int updateHousePassState(String id,Integer state);

    /**
     * 查询所有浏览出租房信息
     * @param condition  查询条件  分页page,rows
     * @return
     */
    PageInfo<House> getHouseByBroswer(HouseCondition condition);
}
