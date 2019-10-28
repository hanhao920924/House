package cn.han.house.servies.impl;


import cn.han.house.entity.Users;
import cn.han.house.entity.UsersExample;
import cn.han.house.mapper.UsersMapper;
import cn.han.house.servies.UserService;
import cn.han.house.util.MD5Utils;
import cn.han.house.util.UserCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/17
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUserByCondition(UserCondition condition) {
        //开启分页
        PageHelper.startPage(condition.getPage(),condition.getRows());
        //查询
        UsersExample usersExample = new UsersExample();
        //用Criteria封装条件查询
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //注册  管理
        criteria.andIsadminEqualTo(0);
        if (condition.getName() != null){
            criteria.andNameLike("%"+condition.getName()+"%");
        }
        if (condition.getTelephone() != null){
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return new PageInfo<>(usersList);
    }

    @Override
    public int addUser(Users users) {
        //用MD5 对密码加密
        String s = MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(s);
        //设置isadmin默认为0
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    @Override
    public int checkUserName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //用户名条件
        criteria.andNameEqualTo(name);
        //执行
        List<Users> usersList = usersMapper.selectByExample(usersExample);

        return usersList.size();
    }

    @Override
    public Users login(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        //用户名和密码条件
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        //执行
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list.size()==0){
            return null;
        } else {
            return list.get(0);
        }
    }
}
