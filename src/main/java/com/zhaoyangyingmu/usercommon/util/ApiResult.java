package com.zhaoyangyingmu.usercommon.util;

import com.alibaba.fastjson.JSONObject;
import com.zhaoyangyingmu.usercommon.util.errorCode.ErrorCode;
import com.zhaoyangyingmu.usercommon.util.errorCode.ErrorCodeException;

public class ApiResult {
	public static String writeSuccess() {
		JSONObject ret = new JSONObject();
		ret.put("errorCode", ErrorCode.SUCCESS.getErrorCode());
		ret.put("message", ErrorCode.SUCCESS.getType());
		return ApiJson.toJson(ret);
	}

	/**
	 * data可以是
	 * Record, writeData(userService.selectByPrimaryKey(user_phone));
	 * List<Record> writeData(userService.selectAll());
	 * */
	public static String writeData(Object data){
		JsonWithNull ret = new JsonWithNull();
		ret.put("errorCode", ErrorCode.SUCCESS.getErrorCode());
		ret.put("message", ErrorCode.SUCCESS.getType());
		ret.put("data", data);
		return ret.toString();
	}

	/**
	 * List数据
	 */
	public static String writeData(Object data, int total){
		JsonWithNull ret = new JsonWithNull();
		ret.put("errorCode", ErrorCode.SUCCESS.getErrorCode());
		ret.put("message", ErrorCode.SUCCESS.getType());
		ret.put("data", data);
		ret.put("total", total);
		return ret.toString();
	}


	private static String writeError(int errorCode, String msg){
		JSONObject ret = new JSONObject();
		ret.put("errorCode", errorCode);
		ret.put("message", msg);
		return ApiJson.toJson(ret);
	}

	// exception中存储了详细信息
	public static String writeError(ErrorCodeException exception){
		return writeError(exception.getErrCode(), exception.getType() + "：" + exception.getDetails());
	}

	public static String writeError(ErrorCode errorCode) {
		return writeError(errorCode.getErrorCode(), errorCode.getType());
	}
}
