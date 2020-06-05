package com.offcn.controller;

import com.offcn.pojo.Car;
import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> list = new ArrayList<>();

    @ApiOperation(value="新增用户", notes="新增用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息实体user", required = true, dataType = "pojo包下的User类")
    @PostMapping("/")
    public List<User> add(@RequestBody User user) {
        list.add(user);
        return list;
    }


    @GetMapping("/")
    public List<User> all() {
        return list;
    }


    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") Long userId) {
        for (User user : list) {
            if(user.getId().longValue() == userId.longValue()) {
                return user;
            }
        }
        return null;
    }

    @PutMapping("/")
    public List<User> update(@RequestBody User user) {
        for (User temp : list) {
            if(temp.getId().longValue() == user.getId().longValue()) {
                temp.setName(user.getName());
                temp.setAge(user.getAge());
            }
        }
        return list;
    }

    @DeleteMapping("/{id}")
    public List<User> del(@PathVariable("id") Long userId) {
        List<User> newList = new ArrayList<>();

        for (User temp : list) {
            if(temp.getId().longValue() != userId.longValue()) {
                newList.add(temp);
            }
        }
        list = newList;

        return list;
    }


}
