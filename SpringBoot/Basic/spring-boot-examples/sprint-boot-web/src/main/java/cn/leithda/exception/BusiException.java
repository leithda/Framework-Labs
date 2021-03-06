package cn.leithda.exception;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 封装业务异常.推荐使用枚举设置错误码及信息
 */
public class BusiException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;

    public BusiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
