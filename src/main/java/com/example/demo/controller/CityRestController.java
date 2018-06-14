package com.example.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.City;
import com.example.demo.domain.LoginInfo;
import com.example.demo.service.CityService;
import com.example.demo.service.LoginInfoService;
import com.example.demo.service.impl.RedisService;

/**
 * Created by bysocket on 07/02/2017.
 */
 
@RestController
@RequestMapping("/city")
public class CityRestController {
	
    @Autowired
    private CityService cityService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private LoginInfoService loginInfoService;

    @RequestMapping("/haha")
    public String haha(ModelAndView m) {
    	redisService.setValue("dan", "yqr");
    	//redisService.setValue("dan", "yqr");
    	 return (String) redisService.getValue("zhang");
    }  

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView m) {
    	 redisService.setValue("dan", "yqr");
    	 System.out.println(redisService.getValue("dan"));
    	 List<City> list= cityService.list();
         System.out.println(list.toString());
         m.setViewName("index");
         m.addObject("list",list);
         return m;
    }
    
    @RequestMapping("/log")
    public String log() {
    	 List<LoginInfo> list= loginInfoService.list();
         System.out.println(list.toString());
         return null;
    }
    
    
    @RequestMapping("/test")
    public String test(HttpServletRequest request,HttpServletResponse response) {
    	String aplIdd=request.getParameter("aplIdd");
    	return aplIdd;
    }
    
   
    
   
}
