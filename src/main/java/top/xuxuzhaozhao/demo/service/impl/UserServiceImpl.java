package top.xuxuzhaozhao.demo.service.impl;

import org.springframework.stereotype.Service;
import top.xuxuzhaozhao.demo.dao.IUserDao;
import top.xuxuzhaozhao.demo.domain.User;
import top.xuxuzhaozhao.demo.service.IUserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }
}
