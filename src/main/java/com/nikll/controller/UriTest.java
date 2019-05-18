/**
 * @program: myautotest
 * @description: URI test
 * @author Nikll
 * @date 2019/5/15 22:30
 */
package com.nikll.controller;

import com.nikll.entity.User;
import com.nikll.mapper.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/5/15 22:30

 */
public class UriTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    SqlSession sqlSession;
//    初始化加载
//    @BeforeMethod
//    public void iocInit(){
//        SpringApplication.run(Application.class);
//    }

    @Test(groups = "mytest",description = "查询/getUserList接口正向case")
    public void getUserListTest(){
        List<User> userList = sqlSession.selectList("getUserlist");
        System.out.println(userList);
        int total = userDao.getTotal();
        System.out.println(userDao);
        System.out.println(total);
        System.out.println(userDao.getUser(10));
        userDao.getUserlist(10,20);
        List<User> users = userDao.getUserlist(10,20);
        System.out.println(users);
    }

}