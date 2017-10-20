package cn.zzy.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zzy.demo.domain.Person;

/**
 * 测试代码是否畅通
 * @author Fairyland
 *
 */
@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/hello")
	public String isPass(Model model){
		model.addAttribute("key", "value");
		String time = new Date().toString();
		model.addAttribute("time", time);
		return "simple";
	}
	
	/**
	 * 参数名接受参数
	 * @param name
	 * @param weight
	 */
	@RequestMapping(value="/test1" ,method = RequestMethod.GET)
	public String getParm(String name, double weight ){
		System.out.println("名字"+name);
		System.out.println("体重"+weight+"Kg");
		return "success";
	}
	
	/**
	 * request接受参数
	 * @param req
	 */
	@RequestMapping(value="/test2" ,method = RequestMethod.GET)
	public String getParm(HttpServletRequest req){
		System.out.println("名字"+req.getParameter("name"));
		System.out.println("体重"+req.getParameter("weight")+"Kg");
		return "success";
	}
	
	/**
	 * 实体类接受参数
	 * @param p
	 */
	@RequestMapping(value="/test3" ,method = RequestMethod.GET)
	public String getParm(Person p){
		System.out.println(p);
		return "success";
	}
	
	
	
}
