package com.example.demo.service;




import com.example.demo.entity.Commodity;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.Callable;


public interface UserService extends Callable<Object> {
    public User user(String name,String pass);
    public int addcommodity(Consumption consumption);//添加消费记录
    public int updatenum(int id,int num);//修改库存
}
