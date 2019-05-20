/**
 * @program: myautotest
 * @description: UserDao
 * @author Nikll
 * @date 2019/5/16 21:07
 */
package com.nikll.mapper;

import com.nikll.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/5/16 21:07

 */
@Mapper
@Component
public interface UserDao {
    int getTotal();
    User getUser(int id);
    List<User> getUserlist(@Param("start") int start,@Param("end") int end);
}