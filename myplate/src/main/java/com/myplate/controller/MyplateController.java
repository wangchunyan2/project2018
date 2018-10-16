package com.myplate.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.myplate.pojo.BasalMetabolism;
import com.myplate.pojo.QueryConsumer;
import com.myplate.pojo.TbMkNutriEvaluate;
import com.myplate.pojo.TsPersonInfo;
import com.myplate.service.IMyplateService;
import com.myplate.service.IUserService;
import com.myplate.service.MyplateService;

@Controller
public class MyplateController {
	private Logger log = Logger.getLogger(MyplateController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private MyplateService myplateService;

    @Autowired
    private IMyplateService imyplateService;

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

	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName){
		// 动态跳转页面
		return formName;
	}
	//管理员页面
	@RequestMapping("/toAdminPage")
	public ModelAndView toAdminPage(HttpServletRequest request,HttpSession session){
		return queryInfo(request,session);
	}
	
	@RequestMapping("/toKnowledgeExpanPage")
	public String toAboutUsPage(){
		return "/knowledge_expan";
	}

	@RequestMapping("/startBodyTest")
	@ResponseBody
	public ModelAndView startBodyTest(HttpServletRequest request, String userId, String nickname, String sex, String bodyHeight,
								String bodyWeight, Integer age){
		ModelAndView mv = new ModelAndView();
		TsPersonInfo tsPersonInfo = new TsPersonInfo();
		tsPersonInfo.setCreateBy(request.getSession().getAttribute("id").toString() );
		tsPersonInfo.setCreateDate(new Date());
		tsPersonInfo.setUserAge(Integer.parseInt(request.getParameter("age")));
		tsPersonInfo.setUserHeight(request.getParameter("bodyHeight"));
		tsPersonInfo.setUserWeight(request.getParameter("bodyWeight"));
		tsPersonInfo.setUserSex(request.getParameter("sex"));
		tsPersonInfo.setUserName(request.getParameter("nickname"));
		myplateService.save(request,tsPersonInfo);
		
		BasalMetabolism metabolism = myplateService.basalMetabolism(request, tsPersonInfo, "1");
		mv.addObject("metabolism",metabolism);
		mv.setViewName("/food_configure");
		
		return mv;
	}

	@RequestMapping("/foodConfigure")
	public String foodConfigure(HttpServletRequest request, String powerLevel){
		TsPersonInfo tsPersonInfo = (TsPersonInfo)request.getSession().getAttribute("tsPersonInfo");
		powerLevel = request.getParameter("powerLevel");
		TbMkNutriEvaluate tbMkNutriEvaluate =new TbMkNutriEvaluate();
		tbMkNutriEvaluate.setPowerLevel(powerLevel);
		myplateService.save(request,tsPersonInfo,tbMkNutriEvaluate);
		return "/nutr_evaluate";
	}
	@RequestMapping("/nutrEvaluate")
	@ResponseBody
	public String nutrEvaluate(HttpServletRequest request, String breakfast, String lunch, String dinner, String other){
		TbMkNutriEvaluate tbMkNutriEvaluate = (TbMkNutriEvaluate)request.getSession().getAttribute("tbMkNutriEvaluate");
		tbMkNutriEvaluate.setBreakfastFood(breakfast);
		tbMkNutriEvaluate.setLunchFood(lunch);
		tbMkNutriEvaluate.setDinnarFood(dinner);
		tbMkNutriEvaluate.setOtherFood(other);
		myplateService.updateTb(tbMkNutriEvaluate);
		
		double recommendUptake=Double.parseDouble(tbMkNutriEvaluate.getRecommendUptake());
		double actualUptake=Double.parseDouble(breakfast)+Double.parseDouble(lunch)+Double.parseDouble(dinner)+Double.parseDouble(other);
		
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
		String preUptake = df.format((actualUptake/recommendUptake)*100)+"%";//
		JSONObject result=new JSONObject();
		result.put("preUptake", preUptake);
		result.put("recommendUptake", recommendUptake);
		
		return result.toString();
	}


	@RequestMapping("/queryInfo")
	//@ResponseBody
	public ModelAndView queryInfo(HttpServletRequest request,HttpSession session){
		ModelAndView mv = new ModelAndView();
		String createBy = request.getParameter("create_by");
		String female = request.getParameter("female");
		String power_level = request.getParameter("power_level");
		List<QueryConsumer> queryList = imyplateService.queryInfo(createBy, female, power_level);
		mv.addObject("queryList", queryList);
		mv.setViewName("/admin");
		return mv;
	}

	@RequestMapping("/basalMetabolism")
	@ResponseBody
	public BasalMetabolism basalMetabolism(HttpServletRequest request,String powerLevel){
		powerLevel=request.getParameter("powerLevel");
		TsPersonInfo tsPersonInfo = (TsPersonInfo)request.getSession().getAttribute("tsPersonInfo");
		BasalMetabolism metabolism = myplateService.basalMetabolism(request, tsPersonInfo, powerLevel);
		return  metabolism;
	}
}
