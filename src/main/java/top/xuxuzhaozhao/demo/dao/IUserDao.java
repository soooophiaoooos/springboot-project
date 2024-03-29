package top.xuxuzhaozhao.demo.dao;

import org.apache.ibatis.annotations.Param;
import top.xuxuzhaozhao.demo.domain.User;

import java.util.List;

public interface IUserDao {
    User selectById(@Param("id") int id);

    List<User> selectAll();
}
