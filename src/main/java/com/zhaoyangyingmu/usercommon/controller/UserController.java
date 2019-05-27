package com.zhaoyangyingmu.usercommon.controller;

import com.zhaoyangyingmu.usercommon.entity.User;
import com.zhaoyangyingmu.usercommon.entity.UserRegisterRequest;
import com.zhaoyangyingmu.usercommon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.ApiResult;
import util.StringUtil;
import util.errorCode.ErrorCode;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/test", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String test() {
        return ApiResult.writeSuccess();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public Object register(@RequestBody User user){
        // TODO: 2019/5/27 持久化数据层
        if (StringUtil.isEmpty(user.getEmail()) || StringUtil.isEmpty(user.getPassword())
                || StringUtil.isEmpty(user.getPhone()) || StringUtil.isEmpty(user.getUsername())) {
            return ApiResult.writeError(ErrorCode.INFO_NOT_COMPLETE);
        }
        if (userService.register(user) != 1) {
            return ApiResult.writeError(ErrorCode.REGISTER_FAILED);
        }
        return ApiResult.writeData(user);
    }
}
