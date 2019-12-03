package top.xuxuzhaozhao.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.xuxuzhaozhao.demo.dao.IUserDao;
import top.xuxuzhaozhao.demo.domain.User;
import top.xuxuzhaozhao.demo.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<User> selectAll(Integer page, Integer size) {
        // 紧跟PageHelper的第二行语句才具备分页功能
        PageHelper.startPage(page,size);
        List<User> userList = userDao.selectAll();
        return new PageInfo<>(userList);
    }
}
