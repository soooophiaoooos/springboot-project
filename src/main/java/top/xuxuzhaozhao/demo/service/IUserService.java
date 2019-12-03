package top.xuxuzhaozhao.demo.service;

import com.github.pagehelper.PageInfo;
import top.xuxuzhaozhao.demo.domain.User;

public interface IUserService {
    User selectById(int id);

    PageInfo<User> selectAll(Integer page,Integer size);
}
