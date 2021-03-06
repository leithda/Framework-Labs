package cn.leithda.response;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 通用响应
 */
@ApiOperation(value = "response.BaseResult")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult implements Serializable {

    @ApiModelProperty("响应码")
    private String code;

    @ApiModelProperty("响应消息")
    private String msg;

    @ApiModelProperty("响应数据")
    private Object data;

    public BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取成功响应
     *
     * @param data 响应数据
     */
    public static BaseResult success(Object data) {
        BaseResult result = new BaseResult("200", "成功");
        result.data = data;
        return result;
    }

    /**
     * 获取失败响应
     *
     * @param code 响应码
     * @param msg  响应信息
     */
    public static BaseResult error(String code, String msg) {
        return new BaseResult(code, msg);
    }


}