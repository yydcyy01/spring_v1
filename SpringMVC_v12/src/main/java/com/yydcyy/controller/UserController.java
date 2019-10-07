package com.yydcyy.controller;

import com.yydcyy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YYDCYY
 * @create 2019-10-05
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美特斯邦威");
        user.setPassword("whocare");
        user.setAge(18);
        // model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 是void
     * 请求转发一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        // 编写请求转发的程序
         //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向
         //response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接会进行响应
        response.getWriter().print("你好啊, 羽扬");

        //return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("user   --    testModelAndView");
        user.setPassword("password");
        user.setAge(30);

        // 把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user",user);

        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");

        // 请求的转发
         //return "forward:/WEB-INF/pages/success.jsp"; //写全 ok, 没问题  跳转成功, 地址栏地址没变


         //return "forward:/success.jsp";  forward 不可省地址. 404:Description The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.

        // 重定向
        return "redirect:/index.jsp";//可以不加项目名, (redirect 关键字自动补全)
    }

    /**
     * 模拟异步请求响应
     */
   /* @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body){
        System.out.println("testAjax方法执行了...");
        System.out.println(body);

    }*/
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
         System.out.println(user);

        // 做响应，模拟查询数据库
         user.setUsername("羽扬");
         user.setPassword("password_JLKJLJ");
         user.setAge(40);

        // 做响应
        return user;
    }

}
