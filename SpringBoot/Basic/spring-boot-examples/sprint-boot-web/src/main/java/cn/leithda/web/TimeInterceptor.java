package cn.leithda.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 自定义拦截器
 */
public class TimeInterceptor extends HandlerInterceptorAdapter {

    private Integer startTime;
    private Integer stopTime;

    public TimeInterceptor() {
        // 初始化 startTime 及 stopTime
    }

    /**
     * 在控制器处理请求前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // 获取当前时间
        if (startTime <= hour && hour < stopTime) { // 判断当前是否处于工作时间段内
            return true;
        } else {
            response.sendRedirect("/outofWorkTime.html"); // 返回提示页面
            return false;
        }

    }

    /**
     * 在控制器处理请求后拦截
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在DispatcherServlet完全处理完后进行拦截
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
