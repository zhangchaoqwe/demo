package com.example.demo.dao;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public User user(@Param("name") String name, @Param("pass")String pass);//登录
    public int addcommodity(Consumption consumption);//添加消费记录
    public Commodity commodity(@Param("id")int id);//根据id获取商品详情
    public int updatenum(@Param("id")int id,@Param("num")int num);//修改库存
}
