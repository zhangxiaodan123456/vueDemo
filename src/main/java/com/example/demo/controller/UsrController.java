package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.util.PageBean;
import com.example.demo.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



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
		Map mp=new HashMap<String,String>();
		mp.put("en", "英文");
		mp.put("ch", "中国");
		String usrNam=null==m.get("usrNam")?"":m.get("usrNam").trim();
 		String usrId=null==m.get("userId")?"":m.get("userId").trim();
 		Integer page=null==m.get("page")?0:Integer.parseInt(m.get("page").trim());
 		Integer pageSize=null==m.get("pageSize")?10:Integer.parseInt(m.get("pageSize").trim());
		Map mapParam=new HashMap<String,Object>();
		mapParam.put("usrNam", usrNam);
		mapParam.put("userId", usrId);
		PageHelper.startPage(page, pageSize);
		List<User> list= userService.list(mapParam);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		Map map=new HashMap<String,Object>();
        map.put("users", pageInfo);
        map.put("gj", mp);
        String str=net.sf.json.JSONSerializer.toJSON(list).toString();
        JSONObject r = new JSONObject(); 
        r.put("data", map);
        return r;
    }
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/removeUser",method=RequestMethod.POST)  
    public JSONObject removeUser(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		String code="";
		String id=null==m.get("id")?"":m.get("id").trim();
		try {
    		userService.delete(id);
    		code="200";
		} catch (Exception e) {
			e.printStackTrace();
			code="error";
		}
        JSONObject r = new JSONObject(); 
        r.put("code", code);
        return r;
    }
	
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/editUser",method=RequestMethod.POST)  
    public JSONObject editUser(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		System.out.println(m.toString());
		String code="";
		try {
    		userService.edit(m);
    		code="200";
		} catch (Exception e) {
			e.printStackTrace();
			code="error";
		}
        JSONObject r = new JSONObject(); 
        r.put("code", code);
        return r;
    }
	
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/addUser",method=RequestMethod.POST)  
    public JSONObject addUser(@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		String 	code="";
		String imgUrl="";
		try{
			String file=m.get("imgUrl");
			System.out.println(file);
			/*
			net.sf.json.JSONArray json=net.sf.json.JSONArray.fromObject(file);
			if(json.length()>0){
				  for(int i=0;i<json.length();i++){
				    net.sf.json.JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    imgUrl+=job.getString("url")+",";
				  }
				  imgUrl=imgUrl.substring(0, imgUrl.length()-1);
				  m.put("imgUrl", imgUrl);
			}*/
			m.put("userId", "P033");
		  //  userService.add(m);
			code="200";
		} catch (Exception e) {
			e.printStackTrace();
			code="error";
		}
		    JSONObject r = new JSONObject(); 
		    r.put("code", code);
		    return r;
    }
	
	@CrossOrigin(origins="*")//允许跨域请求  
    @RequestMapping(value="/batchRemoveUser",method=RequestMethod.POST)  
    public JSONObject batchRemoveUser(User user,@RequestBody Map<String,String> m,HttpServletResponse response) throws IOException{ 
		String code="";
		String id=null==m.get("ids")?"":m.get("ids").trim();
		System.out.println(id);
		try {
    	//	userService.delete(id);
    		code="200";
		} catch (Exception e) {
			e.printStackTrace();
			code="error";
		}
        JSONObject r = new JSONObject(); 
        r.put("code", code);
        return r;
	}	
}
