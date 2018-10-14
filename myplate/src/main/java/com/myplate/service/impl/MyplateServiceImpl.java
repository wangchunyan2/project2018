package com.myplate.service.impl;

import com.myplate.dao.TbMkNutriEvaluateMapper;
import com.myplate.dao.TsPersonInfoMapper;
import com.myplate.pojo.BasalMetabolism;
import com.myplate.pojo.TbMkNutriEvaluate;
import com.myplate.pojo.TsPersonInfo;
import com.myplate.service.MyplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
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
       BasalMetabolism metabolism = basalMetabolism(request, tsPersonInfo, tb.getPowerLevel());
       tb.setBasalMetabolism(metabolism.getBasalMetabolism());
       tb.setRecommendUptake(metabolism.getRecommendUptake());
       tb.setBreakfastKcal(metabolism.getLunchKcal());
       tb.setLunchKcal(metabolism.getDinnarKcal());
       tb.setDinnarKcal(metabolism.getDinnarKcal());
       tb.setCreateBy(tsPersonInfo.getId());
       tbMkNutriEvaluateMapper.insert(tb);
       request.getSession().setAttribute("tbMkNutriEvaluate", tb);
    }

    public void updateTb(TbMkNutriEvaluate tbMkNutriEvaluate) {
        tbMkNutriEvaluateMapper.updateByPrimaryKey(tbMkNutriEvaluate);
    }

    public BasalMetabolism basalMetabolism(HttpServletRequest request,TsPersonInfo tsPersonInfo, String powerLevel) {
        DecimalFormat df  = new DecimalFormat("######0.00");
        double power =0;
        double  basalMetabolism = 0;
        double  recommendUptake  = 0;
        double  userAge = tsPersonInfo.getUserAge();
        double  userHeight =  Double.parseDouble(tsPersonInfo.getUserHeight());
        double  userWeight = Double.parseDouble(tsPersonInfo.getUserWeight());

        if("1".equals(powerLevel)){
            power = 0.2;

        }else if("2".equals(powerLevel)){
            power = 0.35;
        }else{
            power = 0.7;
        }
        if("male".equals(tsPersonInfo.getUserSex())){
            basalMetabolism = (13.7 * userWeight ) + (5 * userHeight) -  (6.8 * userAge ) + 66.47;
        }else{
            basalMetabolism =  (9.6 * userWeight ) + (1.8 * userHeight) -(4.7 * userAge ) + 655.1;
        }
        basalMetabolism = basalMetabolism * power;
        recommendUptake = 1500 + basalMetabolism;

        BasalMetabolism basalMetabolism1 = new BasalMetabolism();
        basalMetabolism1.setBasalMetabolism(df.format(basalMetabolism));
        basalMetabolism1.setRecommendUptake(df.format(recommendUptake));
        basalMetabolism1.setBreakfastKcal(df.format(recommendUptake*0.25));
        basalMetabolism1.setLunchKcal(df.format(recommendUptake*0.40));
        basalMetabolism1.setDinnarKcal(df.format(recommendUptake*0.35));
        return basalMetabolism1;
    }
}
