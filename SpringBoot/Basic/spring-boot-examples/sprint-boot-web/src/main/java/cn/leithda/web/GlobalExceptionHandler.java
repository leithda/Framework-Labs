package cn.leithda.web;

import cn.leithda.exception.BusiException;
import cn.leithda.response.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 全局异常处理
 */
@ControllerAdvice(basePackages = "cn.leithda.controller")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResult> handleBusiException(BusiException e){
        // 错误日志登记
        // log.error(e.getMessage(),e)
        BaseResult result = new BaseResult(e.getCode(), e.getMessage());
        return ResponseEntity.ok(result);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResult> handleException(Exception e){
        // 错误日志登记
        // log.error(e.getMessage(),e)
        BaseResult result = new BaseResult("1000", e.getMessage());
        return ResponseEntity.ok(result);
    }
}
