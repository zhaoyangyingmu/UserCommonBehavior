package com.zhaoyangyingmu.usercommon.controller;

import com.zhaoyangyingmu.usercommon.entity.User;
import com.zhaoyangyingmu.usercommon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.ApiResult;
import util.StringUtil;
import util.errorCode.ErrorCode;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/test", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String test() {
        return ApiResult.writeSuccess();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String register(@RequestBody User user){
        if (StringUtil.isEmpty(user.getEmail()) || StringUtil.isEmpty(user.getPassword())
                || StringUtil.isEmpty(user.getPhone()) || StringUtil.isEmpty(user.getUsername())) {
            return ApiResult.writeError(ErrorCode.INFO_NOT_COMPLETE);
        }
        try {
            if (userService.register(user) != 1) {
                return ApiResult.writeError(ErrorCode.REGISTER_FAILED);
            }
        }
        catch (DuplicateKeyException e) {
            return ApiResult.writeError(ErrorCode.DUPLICATE_USERNAME);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user_id", user.getUserId());
        data.put("username", user.getUsername());
        return ApiResult.writeData(data);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public String login(@RequestBody User user) {
        // 只需要username和password就好了
        if ( StringUtil.isEmpty(user.getPassword()) || StringUtil.isEmpty(user.getUsername())) {
            return ApiResult.writeError(ErrorCode.INFO_NOT_COMPLETE);
        }

        // 错误处理
        if (userService.authenticate(user) == 1) {
            return ApiResult.writeSuccess();
        }
        return ApiResult.writeError(ErrorCode.LOGIN_FAILED);
    }
}
