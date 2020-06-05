package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThController {

    @RequestMapping("/index")
    public String index(Model m) {
        m.addAttribute("title", "我是H3中的内容");
        m.addAttribute("userName", "我有没有显示到文本框中？");
        m.addAttribute("btnName", "我是按钮上面的字");
        m.addAttribute("girlSrc", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591263772678&di=d77cd9b8544075880983ad68e82d8cc5&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170302%2F20170302175831_60d0bdb330cce5b513693b0bae920101_5.jpeg");

        List<User> list = new ArrayList<User>();
        User u1 = new User(1L, "八戒", 480, "abg");
        list.add(u1);

        User u2 = new User(2L, "嫦娥", 893, "abg");
        list.add(u2);

        User u3 = new User(3L, "吴刚", 112, "abg");
        list.add(u3);

        User u4 = new User(4L, "空空", 500, "abg");
        list.add(u4);

        User u5 = new User(5L, "后羿", 88, "abg");
        list.add(u5);


        m.addAttribute("userList", list);

        return "index";
    }

}
