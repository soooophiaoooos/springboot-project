package top.xuxuzhaozhao.demo.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xuxuzhaozhao.demo.core.ret.RetResponse;
import top.xuxuzhaozhao.demo.core.ret.ServiceException;
import top.xuxuzhaozhao.demo.domain.User;
import top.xuxuzhaozhao.demo.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"用户操作接口"}, description = "描述")
@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "query")
//    })
    @GetMapping("/api/user")
    public Object selectById(@RequestParam int id) {
        User info = userService.selectById(id);
        if (info == null) {
            throw new ServiceException("暂无该用户");
        }
        return RetResponse.makeOKRsp(info);
    }

    @PostMapping("/api/exception")
    public void testException(@RequestBody User user) {
        List<Integer> x = null;
        x.get(9);
    }

    @ApiOperation(value = "查询所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页码"),
            @ApiImplicitParam(name = "size",value = "每页显示条数")
    })
    @GetMapping("/api/selectAll")
    public Object selectAll(@RequestParam(defaultValue = "0")Integer page,@RequestParam(defaultValue = "1")Integer size){
        PageInfo<User> pageInfo = userService.selectAll(page,size);
        return RetResponse.makeOKRsp(pageInfo);
    }
}
