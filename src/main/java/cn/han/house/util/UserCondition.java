package cn.han.house.util;

/**
 * @Auther: Hanhao
 * @Date: 2019/10/17
 * @Description:
 * 封装用户查询条件实体
 */
public class UserCondition extends PageUtil{
    private String name;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
