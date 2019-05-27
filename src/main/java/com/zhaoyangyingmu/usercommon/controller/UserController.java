package com.zhaoyangyingmu.usercommon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @RequestMapping(value = "/test", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String test() {
        return "success";
    }
}
