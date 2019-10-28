package cn.han.house.servies;


import cn.han.house.entity.Users;
import cn.han.house.util.UserCondition;
import com.github.pagehelper.PageInfo;

public interface UserService {

    //条件查询 分页
    PageInfo<Users> getUserByCondition(UserCondition condition);

    /**
     * 注册新用户  添加
     * @param users 用户实体
     * @return 影响行数
     */
    int addUser(Users users);

    /**
     * 检查用户是否存在
     * @param name 用户名
     * @return 返回0可用  返回不为0的数不可用
     */
    int checkUserName(String name);

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return 用户信息
     */
    Users login(String name,String password);
}
