package com.zhaoyangyingmu.usercommon.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonWithNull extends JSONObject {
    @Override
    public String toString() {
        return toJSONString(this, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty);
    }
}
