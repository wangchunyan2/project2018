package com.myplate.service;


import com.myplate.pojo.BasalMetabolism;
import com.myplate.pojo.TbMkNutriEvaluate;
import com.myplate.pojo.TsPersonInfo;

import javax.servlet.http.HttpServletRequest;


public interface MyplateService {
     void save(HttpServletRequest request,TsPersonInfo tsPersonInfo);
     void save(HttpServletRequest request,TsPersonInfo tsPersonInfo,TbMkNutriEvaluate tbMkNutriEvaluate);
     void updateTb(TbMkNutriEvaluate tbMkNutriEvaluate);
      BasalMetabolism basalMetabolism(HttpServletRequest request, TsPersonInfo tsPersonInfo,String powerLevel);
}
