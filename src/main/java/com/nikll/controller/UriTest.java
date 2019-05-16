/**
 * @program: myautotest
 * @description: URI test
 * @author Nikll
 * @date 2019/5/15 22:30
 */
package com.nikll.controller;

import com.nikll.entity.User;
import com.nikll.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/5/15 22:30

 */
public class UriTest {
    @Autowired
    UserDao userDao;
//    @Autowired
//    SqlSession sqlSession;

    @Test(groups = "mytest",description = "查询/getUserList接口正向case")
    public void getUserListTest(){
        int total = userDao.getTotal();
        List<User> users = userDao.getUserlist(10,20);
        System.out.println(total);
        System.out.println(users);
    }

}