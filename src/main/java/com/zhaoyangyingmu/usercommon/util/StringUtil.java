package com.zhaoyangyingmu.usercommon.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class StringUtil {
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() < 1;
    }

    public static boolean isInfoComplete(List<String> keys, JSONObject jsonParam) {
        for (String key: keys) {
            if (isEmpty(jsonParam.getString(key))) {
                return false;
            }
        }
        return true;
    }
}
