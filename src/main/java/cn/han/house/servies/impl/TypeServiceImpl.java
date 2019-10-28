package cn.han.house.servies.impl;


import cn.han.house.entity.Type;
import cn.han.house.entity.TypeExample;
import cn.han.house.mapper.TypeMapper;
import cn.han.house.servies.TypeService;
import cn.han.house.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/13
 * @Description:
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询所有
        TypeExample TypeExample = new TypeExample();
        List<Type> TypeList = typeMapper.selectByExample(TypeExample);
        //获取分页信息
        PageInfo<Type> pageInfo = new PageInfo(TypeList);
        return pageInfo;
    }

    @Override
    public boolean insertType(Type Type) {
        int i = typeMapper.insertSelective(Type);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateType(Type Type) {
        int i = typeMapper.updateByPrimaryKeySelective(Type);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delType(Integer id) {
        int i = typeMapper.deleteByPrimaryKey(id);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public int delMores(String ids) {
        String[] split = ids.split(",");
        Integer[] idss=new Integer[split.length];
        for (int i = 0; i < idss.length; i++) {
            idss[i]=Integer.valueOf(split[i]);
        }
        int r = typeMapper.delMoreType(idss);
        return r;
    }
}
