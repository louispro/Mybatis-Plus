package com.louis.mp.controller;

import com.louis.mp.entity.User;
import com.louis.mp.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-07-12 23:56:48
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }
    
    /**
    * 通过条件查询
    *
    * @param user 条件
    */
    @PostMapping("/queryAll")
    public List<User> queryAll(@RequestBody User user){
        return this.userService.queryAll(user);
    }
    
    /**
    * 新增数据
    *
    * @param user 数据
    */
    @PostMapping("/insert")
    public void insertUser(@RequestBody User user){
        this.userService.insert(user);
    }

    
    /**
    * 更新数据
    *
    * @param user 主键
    */
    @PostMapping("/update")
    public void updateUser(@RequestBody User user){
        this.userService.update(user);
    }

}