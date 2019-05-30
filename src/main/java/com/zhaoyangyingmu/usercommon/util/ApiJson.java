package com.zhaoyangyingmu.usercommon.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeSet;

public class ApiJson {
	public static String toJson(Object obj){
		return JSONObject.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
	}

	public static Collection<String> listKeys(JSONObject ele){
		Collection<String> ret = new TreeSet<String>();
		if (null != ele){
			for(Entry<String, Object> entry: ele.entrySet()){
				ret.add(entry.getKey());
			}
		}
		return ret;
	}
}
