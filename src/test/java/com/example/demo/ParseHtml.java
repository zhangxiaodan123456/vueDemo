package com.example.demo;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ParseHtml {
	
	public static void main(String[] args) throws IOException {
		String url = "https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.2.1a7d19ee0FctTq&id=565248018167&skuId=3607087777233&areaId=440300&user_id=173275708&cat_id=53384001&is_b=1&rn=6bae17e9e56367ae4eaa8c8833c67662";
		Connection con = Jsoup.connect(url);
		Document doc = con.get();
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");   
        Matcher m = p.matcher(doc.html());   
        String strNoBlank = m.replaceAll("");     
		String rgex = "TShop.Setup\\((.*?)\\)\\;";
		String str = getMatches(strNoBlank, rgex);
		System.out.println(str);
		
	}
	
	public static String getMatches(String soap, String rgex){
		Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
        Matcher m = pattern.matcher(soap);    
        if (m.find()) {    
            return m.group(1); 
        }
        return null;
	}
}
