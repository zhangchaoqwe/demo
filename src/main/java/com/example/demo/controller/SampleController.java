package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


@Controller
public class SampleController {
    @Autowired
    private UserService UserService;

    /**
     * 登录
     *
     * @param session
     * @param name
     * @param pass
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Object pic(HttpSession session, String name, String pass) {

        User user = UserService.user(name, pass);
        //存入session
        session.setAttribute("user", user);
        return "登录成功";
    }

    @RequestMapping("srg1")

    @ResponseBody
    public Object pi(HttpSession session, int sid, int num) {

        User user = (User) session.getAttribute("user");
        Consumption consumption = new Consumption(0, user.getId(), sid, num);
        FutureTask<Object> futureTask = new FutureTask<Object>(() ->
                UserService.addcommodity(consumption));
        FutureTask<Object> futureTask2 = new FutureTask<Object>(() ->
                UserService.updatenum(sid, num));
        /*Lock lock = new ReentrantLock(false);//公平锁*/

        Thread thread = new Thread(futureTask);//创建线程,添加消费记录
        Thread thread2 = new Thread(futureTask2);//创建线程，减库存
        /*CountDownLatch latch=new CountDownLatch(2);*/
        thread.start();//m1启动
        thread2.start();//m2启动
        int i = 0;
        try {
            i += Integer.parseInt(futureTask.get().toString());
            i += Integer.parseInt(futureTask2.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(i==2){
            return "购买成功！";
        }
        return "购买失败！";

    }

}
