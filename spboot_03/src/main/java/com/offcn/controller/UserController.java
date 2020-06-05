package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 跳转到新增用户的界面
     * @return
     */
    @GetMapping("/toAdd")
    public String toadd() {
        return "user/userAdd";
    }

    /***
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public String createUser(User user) {
        userService.add(user);
        return "redirect:/user/";
    }


    /**
     * 删除指定id用户
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/user/";

    }



    /**
     * 修改用户, 修改完成后跳转到用户列表页面
     * @param user
     * @return
     */
    @PutMapping("/edit")
    public String edit(User user) {
        userService.update(user);
        return "redirect:/user/";
    }



    /***
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/")
    public String getUserList(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("page", list);
        return "user/list";
    }

    /**
     * 根据id获取单个用户
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id") Long id) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

}
