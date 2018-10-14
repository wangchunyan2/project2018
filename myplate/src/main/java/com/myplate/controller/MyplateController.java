package com.myplate.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myplate.pojo.QueryConsumer;
import com.myplate.service.IMyplateService;

@Controller
public class MyplateController {
	@Autowired
	private IMyplateService myplateService;
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
	public String toAdminPage(Model model,HttpServletRequest request,HttpSession session){
		return queryInfo(model,request,session);
	}
	
	@RequestMapping("/toKnowledgeExpanPage")
	public String toAboutUsPage(){
		return "/knowledge_expan";
	}
	
	@RequestMapping("/queryInfo")
	public String queryInfo(Model model,HttpServletRequest request,HttpSession session){
		ModelAndView mv = new ModelAndView();
		String createBy = request.getParameter("create_by");
		String female = request.getParameter("female");
		String power_level = request.getParameter("power_level");
		System.out.println(createBy+"---"+female+"---"+power_level);
		List<Map<String,String>> queryList = myplateService.queryInfo(createBy, female, power_level);
		List<QueryConsumer> resList=new ArrayList<QueryConsumer>();
		for (int i = 0; i < queryList.size(); i++) {
			QueryConsumer queryDto = new QueryConsumer();
			queryDto.setUser_name(queryList.get(i).get("user_name"));
			queryDto.setNickname(queryList.get(i).get("nickName"));
			queryDto.setUser_sex(queryList.get(i).get("user_sex")=="male"?"男":"女");
			queryDto.setUser_height(queryList.get(i).get("user_height"));
			queryDto.setUser_weight(queryList.get(i).get("user_weight"));
			String power_Level = queryList.get(i).get("power_Level");
			if(power_Level.equals("1")){
				queryDto.setPower_Level("轻活力水平");
			}else if(power_Level.equals("2")){
				queryDto.setPower_Level("中活力水平");
			}else if(power_Level.equals("3")){
				queryDto.setPower_Level("重活力水平");
			}
			queryDto.setBasal_metabolism(queryList.get(i).get("basal_metabolism"));
			resList.add(queryDto);
			
		}
		mv.addObject("resultList", resList);
		return "/admin";
	}
}

