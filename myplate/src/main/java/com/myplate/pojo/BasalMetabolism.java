package com.myplate.pojo;


public class BasalMetabolism {
    //基础代谢
    private String basalMetabolism;
    //能量摄入水平
    private String recommendUptake;
    //早餐供能
    private String breakfastKcal;
    //午餐供能
    private String lunchKcal;
    //晚餐供能
    private String dinnarKcal;

    public String getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(String basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public String getRecommendUptake() {
        return recommendUptake;
    }

    public void setRecommendUptake(String recommendUptake) {
        this.recommendUptake = recommendUptake;
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

    @Override
    public String toString() {
        return "BasalMetabolism{" +
                "basalMetabolism='" + basalMetabolism + '\'' +
                ", recommendUptake='" + recommendUptake + '\'' +
                ", breakfastKcal='" + breakfastKcal + '\'' +
                ", lunchKcal='" + lunchKcal + '\'' +
                ", dinnarKcal='" + dinnarKcal + '\'' +
                '}';
    }
}
