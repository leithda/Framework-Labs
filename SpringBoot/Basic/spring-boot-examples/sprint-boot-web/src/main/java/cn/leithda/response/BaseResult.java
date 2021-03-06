package cn.leithda.response;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/5
 * Description: Base Response
 */

public class BaseResult implements Serializable {

    /**
     * errcode
     */
    private String code;

    /**
     * err msg
     */
    private String msg;

    /**
     * response data
     */
    private Object data;

    public BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取成功响应
     * @param data 响应数据
     */
    public static BaseResult success(Object data) {
        BaseResult result = new BaseResult("200", "成功");
        result.data = data;
        return result;
    }


}
