/**
 * @program: myautotest
 * @description: UserDao
 * @author Nikll
 * @date 2019/5/16 21:07
 */
package com.nikll.mapper;

import com.nikll.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author Nikll

 * @date 2019/5/16 21:07

 */
@Mapper
public interface UserDao {
    int getTotal();
    List<User> getUserlist(int start,int end);
}