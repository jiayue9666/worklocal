package com.example.webdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demoController {

    @RequestMapping("/")
    public String myfirstcontroller() {
        return "你好";
    }
}
