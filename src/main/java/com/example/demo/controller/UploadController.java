package com.example.demo.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {
	@Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
	
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/file")
    public Object file(MultipartFile file) throws IOException {
    	if (Objects.isNull(file) || file.isEmpty()) {
             logger.error("文件为空");
             return "文件为空，请重新上传";
         }

        try {
            byte[] bytes = file.getBytes();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd");
            String pt=sdf.format(new Date());
            Path path = Paths.get(UPLOAD_FOLDER +"/"+pt+"/"+ file.getOriginalFilename());
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER+"/"+pt));
            }
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
    
    
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public Object test(@RequestBody JSONObject obj,HttpServletRequest request) throws IOException {
    	
    	Enumeration<String> e = request.getParameterNames();
    	while(e.hasMoreElements()){
    		System.out.println(e.nextElement());
    	}
         return "SUCCESS"; 
    }
    
    @RequestMapping(value="/file1",method=RequestMethod.POST)  
    public Object file1(@RequestBody JSONArray arr) throws IOException {
    	for(Object o : arr){
    		System.out.println(o.toString());
    	}
         return "文件上传成功"; 
    }
}
