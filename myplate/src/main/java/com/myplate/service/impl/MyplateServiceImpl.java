package com.myplate.service.impl;

import com.myplate.dao.TbMkNutriEvaluateMapper;
import com.myplate.dao.TsPersonInfoMapper;
import com.myplate.pojo.TbMkNutriEvaluate;
import com.myplate.pojo.TsPersonInfo;
import com.myplate.service.MyplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Description:
 * Program Name:
 * author :john
 * Date:2018-10-2018/10/14  0:08  星期日
 * version 1.0
 */

@Transactional
@Service("myplateService")
public class MyplateServiceImpl implements MyplateService{
    @Resource
    TsPersonInfoMapper tsPersonInfoMapper;

    @Resource
    TbMkNutriEvaluateMapper tbMkNutriEvaluateMapper;


    public void save(HttpServletRequest request,TsPersonInfo tsPersonInfo) {
        tsPersonInfoMapper.insert(tsPersonInfo);
        //保存数据到session
        request.getSession().setAttribute("tsPersonInfo", tsPersonInfo);
    }
   public void save(HttpServletRequest request,TsPersonInfo tsPersonInfo,TbMkNutriEvaluate tb) {
       tb.setCerateDate(new Date());
       tb.setBasalMetabolism("188");
       tb.setBreakfastKcal("166");
       tb.setLunchKcal("122");
       tb.setDinnarKcal("133");
       tb.setCreateBy(tsPersonInfo.getId());
       tbMkNutriEvaluateMapper.insert(tb);
       request.getSession().setAttribute("tbMkNutriEvaluate", tb);
    }
}
