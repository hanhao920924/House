package cn.han.house.servies;

import cn.han.house.entity.Street;

import java.util.List;

public interface StreetService {
    List<Street> getStreetByDistrictId(Integer disstrictId);


}
