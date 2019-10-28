package cn.han.house.servies;

import cn.han.house.entity.District;
import cn.han.house.entity.Street;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DistrictService {
    List<District> getAllDistrict();

    //分页查询
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil);

    /**
     * 添加
     * @param district
     * @return 添加成功与否
     */
    boolean insertDistrict(District district);

    /**
     * 修改
     * @param district
     * @return
     */
    boolean updateDistrict(District district);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delDistrict(Integer id);

    int delMores(String ids);

    PageInfo<Street> streeInfo(PageUtil pageUtil,Integer id);

}
