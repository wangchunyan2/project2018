package com.myplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyplateController {
	//首页
	@RequestMapping("/buildMenu")
	public String buildMenu(){
		return "/buildMenu";
	}
	//用户个人信息页面
	@RequestMapping("/toInforPage")
	public String toMealTestPage(){
		return "/user_information";
	}
	
	@RequestMapping("/toBmiTestPage")
	public String toBmiTestPage(){
		return "/bmi_test";
	}
	//食谱配置页面
	@RequestMapping("/toFoodConfPage")
	public String toGuidePage(){
		return "/food_configure";
	}
	//营养配置页面
	@RequestMapping("/toNutrEvaluatePage")
	public String toWhrPage(){
		return "/nutr_evaluate";
	}
	
	//管理员页面
	@RequestMapping("/toAdminPage")
	public String toAdminPage(){
		return "/admin";
	}
	
	@RequestMapping("/toKnowledgeExpanPage")
	public String toAboutUsPage(){
		return "/knowledge_expan";
	}

}
