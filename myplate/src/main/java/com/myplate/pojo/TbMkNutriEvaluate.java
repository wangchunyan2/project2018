package com.myplate.pojo;

/**
 * Description:
 * Program Name:
 * author :john
 * Date:2018-10-2018/10/14  0:31  星期日
 * version 1.0
 */
public class TbMkNutriEvaluate {

    //基础代谢
    private  String basalMetabolism;
    //早餐供能
    private  String breakfastKcal;
    //午餐供能
    private  String lunchKcal;
    //晚餐供能
    private  String dinnarKcal;
    //活力水平
    private  String powerLevel;
    //早餐摄入量
    private  String breakfastFood;
    //午餐摄入量
    private  String lunchFood;
    //晚他摄入量
    private  String dinnaFrood;
    //其它摄入量
    private  String otherFood;
    //创建时间
    private  String cerateDate;
    //创建人
    private  String userType;

    public String getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(String basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public String getBreakfastKcal() {
        return breakfastKcal;
    }

    public void setBreakfastKcal(String breakfastKcal) {
        this.breakfastKcal = breakfastKcal;
    }

    public String getLunchKcal() {
        return lunchKcal;
    }

    public void setLunchKcal(String lunchKcal) {
        this.lunchKcal = lunchKcal;
    }

    public String getDinnarKcal() {
        return dinnarKcal;
    }

    public void setDinnarKcal(String dinnarKcal) {
        this.dinnarKcal = dinnarKcal;
    }

    public String getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(String powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getBreakfastFood() {
        return breakfastFood;
    }

    public void setBreakfastFood(String breakfastFood) {
        this.breakfastFood = breakfastFood;
    }

    public String getLunchFood() {
        return lunchFood;
    }

    public void setLunchFood(String lunchFood) {
        this.lunchFood = lunchFood;
    }

    public String getDinnaFrood() {
        return dinnaFrood;
    }

    public void setDinnaFrood(String dinnaFrood) {
        this.dinnaFrood = dinnaFrood;
    }

    public String getOtherFood() {
        return otherFood;
    }

    public void setOtherFood(String otherFood) {
        this.otherFood = otherFood;
    }

    public String getCerateDate() {
        return cerateDate;
    }

    public void setCerateDate(String cerateDate) {
        this.cerateDate = cerateDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "TbMkNutriEvaluate{" +
                "basalMetabolism='" + basalMetabolism + '\'' +
                ", breakfastKcal='" + breakfastKcal + '\'' +
                ", lunchKcal='" + lunchKcal + '\'' +
                ", dinnarKcal='" + dinnarKcal + '\'' +
                ", powerLevel='" + powerLevel + '\'' +
                ", breakfastFood='" + breakfastFood + '\'' +
                ", lunchFood='" + lunchFood + '\'' +
                ", dinnaFrood='" + dinnaFrood + '\'' +
                ", otherFood='" + otherFood + '\'' +
                ", cerateDate='" + cerateDate + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
