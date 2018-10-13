package com.myplate.controller;

import com.myplate.pojo.TbMkNutriEvaluate;
import com.myplate.pojo.TsPersonInfo;
import com.myplate.pojo.User;
import com.myplate.service.IUserService;
import com.myplate.service.MyplateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class MyplateController {
	private Logger log = Logger.getLogger(MyplateController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private MyplateService myplateService;

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

	@RequestMapping("/startBodyTest")
	public String startBodyTest(HttpServletRequest request, String userId, String nickname, String sex, String bodyHeight,
								String bodyWeight, Integer age){
		TsPersonInfo tsPersonInfo = new TsPersonInfo();
		tsPersonInfo.setCreateBy(request.getSession().getAttribute("id").toString() );
		tsPersonInfo.setCreateDate(new Date());
		tsPersonInfo.setUserAge(age);
		tsPersonInfo.setUserHeight(bodyHeight);
		tsPersonInfo.setUserWeight(bodyWeight);
		tsPersonInfo.setUsersex(sex);
		myplateService.save(tsPersonInfo);
		return "/nutr_evaluate";
	}

	@RequestMapping("/foodConfigure")
	public String foodConfigure(HttpServletRequest request, String powerLevel){
		TbMkNutriEvaluate tbMkNutriEvaluate =new TbMkNutriEvaluate();
		tbMkNutriEvaluate.setPowerLevel(powerLevel);
		return "/nutr_evaluate";
	}
	@RequestMapping("/nutrEvaluate")
	public String nutrEvaluate(HttpServletRequest request, String powerLevel){
		TbMkNutriEvaluate tbMkNutriEvaluate =new TbMkNutriEvaluate();
		tbMkNutriEvaluate.setPowerLevel(powerLevel);
		return "/nutr_evaluate";
	}

}
