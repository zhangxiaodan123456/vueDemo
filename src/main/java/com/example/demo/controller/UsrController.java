package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.util.TokenUtil;

@RestController  
@RequestMapping("/user")
public class UsrController {
	@Autowired
    private UserService userService;
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/login",method=RequestMethod.POST)  
    public JSONObject login(@RequestBody Map<String,String> map){  
		String username=map.get("username");
        String password=map.get("password");
        System.out.println(password);
		JSONObject r = new JSONObject();  
        if("admin".equals(username) && "123456".equals(password))   {  
            r.put("code", "200");  
            r.put("msg", "登录成功"); 
            r.put("tickname", "管理员");
            r.put("token", TokenUtil.getToken(username));  
        }else{  
            r.put("code", "500");  
            r.put("msg", "登录失败");  
        }  
        return r;  
    }
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/getUserList",method=RequestMethod.POST)  
    public JSONObject getUserList(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException, InterruptedException{ 
		Map map=new HashMap<String,Object>();
		List<User> list= userService.list(map);
		for(User u:list) 
		{
			System.out.println(u.toString());
		}
		Map mp=new HashMap<String,String>();
		mp.put("en", "英文");
		mp.put("ch", "中国");
        map.put("total", list.size());
        map.put("users", list);
        map.put("gj", mp);
        String str=net.sf.json.JSONSerializer.toJSON(list).toString();
        JSONObject r = new JSONObject(); 
        r.put("data", map);
        return r;
    }
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/removeUser",method=RequestMethod.POST)  
    public JSONObject removeUser(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		System.out.println("ddd");
		System.out.println(m.get("id"));
        JSONObject r = new JSONObject(); 
        r.put("code", "200");
        return r;
    }
	
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/getEdit",method=RequestMethod.POST)  
    public JSONObject getEdit(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		System.out.println(m.get("id"));
		Map map=new HashMap<>();
    	User user=new User();
    	
        map.put("user", user);
        JSONObject r = new JSONObject(); 
        r.put("data", map);
        return r;
    }
	
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/addUser",method=RequestMethod.POST)  
    public JSONObject addUser(User user,@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		userService.add(m);
		System.out.println(m.toString());
        JSONObject r = new JSONObject(); 
        r.put("code", "success");
        return r;
    }
}
