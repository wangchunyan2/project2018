package com.myplate.service.impl;

import com.myplate.dao.TsPersonInfoMapper;
import com.myplate.pojo.TsPersonInfo;
import com.myplate.service.MyplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


  /*  @Resource
    TbMkNutriEvaluateMapper tbMkNutriEvaluateMapper;
    @Autowired
    private TbMkNutriEvaluateMapper TbMkNutriEvaluateDao;*/


    public void save(TsPersonInfo tsPersonInfo) {
        tsPersonInfoMapper.insert(tsPersonInfo);
    }
  /*  public void save(TbMkNutriEvaluate tbMkNutriEvaluate) {
        TbMkNutriEvaluateDao.save(tbMkNutriEvaluate);
    }*/
}
