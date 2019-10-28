package cn.han.house.servies;

import cn.han.house.entity.Type;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {
    List<Type> getAllType();

    //分页查询
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil);

    /**
     * 添加
     * @param Type
     * @return 添加成功与否
     */
    boolean insertType(Type Type);

    /**
     * 修改
     * @param Type
     * @return
     */
    boolean updateType(Type Type);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delType(Integer id);

    int delMores(String ids);



}
