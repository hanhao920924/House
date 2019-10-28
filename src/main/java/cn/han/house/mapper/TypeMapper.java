package cn.han.house.mapper;


import cn.han.house.entity.Type;
import cn.han.house.entity.TypeExample;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    //批量删除类型
    int delMoreType(Integer[] mid);
}