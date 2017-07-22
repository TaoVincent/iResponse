package com.iresponse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	 @RequestMapping("/hello.do")
	    public @ResponseBody String hello(){
	        return "Hello World!";
	    } 
}
