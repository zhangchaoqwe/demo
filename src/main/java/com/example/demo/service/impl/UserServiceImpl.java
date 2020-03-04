package com.example.demo.service.impl;



import com.example.demo.dao.UserDao;
import com.example.demo.entity.Commodity;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserDao user;

    public User user(String name,String pass) {
        return user.user(name,pass);
    }

    @Override
    public synchronized int addcommodity(Consumption consumption) {
        System.out.println("消费线程启动");
        return user.addcommodity(consumption);//添加消费记录
    }

    @Override
    public synchronized int updatenum(int id, int num) {
        System.out.println("库存线程启动");
        Commodity commodity=user.commodity(id);
        int num2=commodity.getCommoditynum()-num;//减库存
        return user.updatenum(id,num2);//修改库存
    }


    @Override
    public Object call() throws Exception {


        return null;
    }
}
