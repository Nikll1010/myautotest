/**
 * @program: myautotest
 * @description: MyController
 * @author Nikll
 * @date 2019/5/20 21:40
 */
package com.nikll.controller;

import com.nikll.entity.User;
import com.nikll.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/5/20 21:40

 */
@RestController
@RequestMapping
public class MyController {
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public User getuser(@RequestParam int id){
        return userDao.getUser(id);
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<User> getuserList(@RequestParam int start, @RequestParam int end){
        return userDao.getUserlist(start,end);
    }
}