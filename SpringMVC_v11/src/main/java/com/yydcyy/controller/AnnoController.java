package com.yydcyy.controller;

import com.yydcyy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import java.io.IOException;


/**
 * @author YYDCYY
 * @create 2019-10-04
 */
@Controller
@RequestMapping(value="anno")
@SessionAttributes(value={"msgFlag"})   // 把 msgFlag 存入到session域对中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("执行了...");
        System.out.println(username);
        return "success";

    }

    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping(value="/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header) throws IOException {
        System.out.println("执行了...");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @return
     */
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    /*@RequestMapping(value="/testModelAttribute")
    public String testModelAttribute( User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }
*/
    /*@ModelAttribute
    public User showUser(String uname,Integer age){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * ModelAttribute注解
     * @return
     */
 /*   @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("我是token") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        //Map<别名 String, 对象 User>
        System.out.println("showUser执行了...return void, 存入 Map 方式");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("我是token",user);
    }*/
        /*showUser 一直预执行, 就被备注了. 需要解除备注*/

    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msgFlag","狭路相逢勇者胜");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msgFlag");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes...");
        status.setComplete();
        return "success";
    }

}
