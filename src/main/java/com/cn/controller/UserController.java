package com.cn.controller;


import com.cn.entity.User;
import com.cn.service.UserService;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.annotations.Param;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserController{
    @Autowired
    private UserService userService;
    private static Logger logger=Logger.getLogger(UserController.class); // 获取logger实例


    /**\
     * 常量调用
     */
    @Value("${num}")
    private Integer number;

    @Value("${enum}")
    private String ennum;


    /**
     * 设置首页跳转
     * @return
     */
    @RequestMapping("/")
    public String Index(){
        return "show";
    }


    /**
     *数据的插入
     * @param name
     * @param age
     * @return
     */

    @Transactional          //事物回滚  如果下面有一句出错  则会回滚  数据库操作的动作自然也就不会执行  例如那个1/0
    @RequestMapping(value = "/insert",produces="text/plain;charset=UTF-8")
    public String InsertOne(String name,Integer age){
        String ids=RandomStringUtils.randomAlphanumeric(15);

        logger.info("信息："+name+","+age+","+ids);
        userService.InsertOne(ids,name,age);

        System.out.println(number+"此处是常量的打印" +
                ""+ ennum);
        return "success";
    }

    @RequestMapping("/showall")
    public String GetAll(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpServletRequest request){
        //需要显示的第几个页面，每个页面显示的数量
        PageHelper.startPage(pn,4);
        List<User> listuser=userService.getAll();
        PageInfo<User> pageInfo=new PageInfo<User>(listuser);
        request.setAttribute("pageInfo",pageInfo);
        return "showall";
    }

    @RequestMapping("/del")
    public ModelAndView Delete(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("redirect:showall?pn=1");
        String id=request.getParameter("id");
        userService.deleteById(id);
        return modelAndView;
    }

    @RequestMapping("/viewMap")
    public String getMap(HttpServletRequest request){
        return "viewmap";
    }



}


