package com.yydcyy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SysExceptionResolver
 * @author YYDCYY
 * @create 2019-10-08
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     *  处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        // 获取到异常对象
        SysException e = null;
        if (ex instanceof SysException){
            e = (SysException) ex;
        }else
            e = new SysException("系统维护中呢....");

        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
