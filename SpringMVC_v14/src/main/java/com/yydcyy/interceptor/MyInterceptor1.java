package com.yydcyy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YYDCYY
 * @create 2019-10-08
 */
public class MyInterceptor1 implements HandlerInterceptor {


    /**
     * 预处理，controller方法执行前
     *      * return true 放行，执行下一个拦截器，如果没有，执行controller中的方法
     *      * return false不放行
     *     用于 eg : 登录时候预检测, 当前状态没登录, 跳转至登录页面类似这样
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了...前1111");

        return true;
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行之前
     * eg : 用于退出后 跳转至登录页面等
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了...后1111");

    }

    /**
     * eg : 结束后资源释放等
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyIntercept⁄or1执行了...最后1111");
    }
}
