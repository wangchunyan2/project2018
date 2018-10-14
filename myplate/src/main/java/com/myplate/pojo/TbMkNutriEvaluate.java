package com.myplate.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_mk_nutri_evaluate")
public class TbMkNutriEvaluate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 基础代谢
     */
    @Column(name = "basal_metabolism")
    private String basalMetabolism;

    /**
     * 早餐供能
     */
    @Column(name = "breakfast_kcal")
    private String breakfastKcal;

    /**
     * 午餐供能
     */
    @Column(name = "lunch_kcal")
    private String lunchKcal;

    /**
     * 晚餐供能
     */
    @Column(name = "dinnar_kcal")
    private String dinnarKcal;

    /**
     * 活力水平
     */
    @Column(name = "power_Level")
    private String powerLevel;

    /**
     * 早餐摄入量
     */
    @Column(name = "breakfast_food")
    private String breakfastFood;

    /**
     * 午餐摄入量
     */
    @Column(name = "lunch_food")
    private String lunchFood;

    /**
     * 晚他摄入量
     */
    @Column(name = "dinnar_food")
    private String dinnarFood;

    /**
     * 其它摄入量
     */
    @Column(name = "other_food")
    private String otherFood;

    /**
     * 创建时间
     */
    @Column(name = "cerate_date")
    private Date cerateDate;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Integer createBy;
    /**
     * 能量摄入水平
     */
    @Transient
    private String recommendUptake;

    public String getRecommendUptake() {
        return recommendUptake;
    }

    public void setRecommendUptake(String recommendUptake) {
        this.recommendUptake = recommendUptake;
    }

    private static final long serialVersionUID = 1L;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取基础代谢
     *
     * @return basal_metabolism - 基础代谢
     */
    public String getBasalMetabolism() {
        return basalMetabolism;
    }

    /**
     * 设置基础代谢
     *
     * @param basalMetabolism 基础代谢
     */
    public void setBasalMetabolism(String basalMetabolism) {
        this.basalMetabolism = basalMetabolism == null ? null : basalMetabolism.trim();
    }

    /**
     * 获取早餐供能
     *
     * @return breakfast_kcal - 早餐供能
     */
    public String getBreakfastKcal() {
        return breakfastKcal;
    }

    /**
     * 设置早餐供能
     *
     * @param breakfastKcal 早餐供能
     */
    public void setBreakfastKcal(String breakfastKcal) {
        this.breakfastKcal = breakfastKcal == null ? null : breakfastKcal.trim();
    }

    /**
     * 获取午餐供能
     *
     * @return lunch_kcal - 午餐供能
     */
    public String getLunchKcal() {
        return lunchKcal;
    }

    /**
     * 设置午餐供能
     *
     * @param lunchKcal 午餐供能
     */
    public void setLunchKcal(String lunchKcal) {
        this.lunchKcal = lunchKcal == null ? null : lunchKcal.trim();
    }

    /**
     * 获取晚餐供能
     *
     * @return dinnar_kcal - 晚餐供能
     */
    public String getDinnarKcal() {
        return dinnarKcal;
    }

    /**
     * 设置晚餐供能
     *
     * @param dinnarKcal 晚餐供能
     */
    public void setDinnarKcal(String dinnarKcal) {
        this.dinnarKcal = dinnarKcal == null ? null : dinnarKcal.trim();
    }

    /**
     * 获取活力水平
     *
     * @return power_Level - 活力水平
     */
    public String getPowerLevel() {
        return powerLevel;
    }

    /**
     * 设置活力水平
     *
     * @param powerLevel 活力水平
     */
    public void setPowerLevel(String powerLevel) {
        this.powerLevel = powerLevel == null ? null : powerLevel.trim();
    }

    /**
     * 获取早餐摄入量
     *
     * @return breakfast_food - 早餐摄入量
     */
    public String getBreakfastFood() {
        return breakfastFood;
    }

    /**
     * 设置早餐摄入量
     *
     * @param breakfastFood 早餐摄入量
     */
    public void setBreakfastFood(String breakfastFood) {
        this.breakfastFood = breakfastFood == null ? null : breakfastFood.trim();
    }

    /**
     * 获取午餐摄入量
     *
     * @return lunch_food - 午餐摄入量
     */
    public String getLunchFood() {
        return lunchFood;
    }

    /**
     * 设置午餐摄入量
     *
     * @param lunchFood 午餐摄入量
     */
    public void setLunchFood(String lunchFood) {
        this.lunchFood = lunchFood == null ? null : lunchFood.trim();
    }

    /**
     * 获取晚他摄入量
     *
     * @return dinnar_food - 晚他摄入量
     */
    public String getDinnarFood() {
        return dinnarFood;
    }

    /**
     * 设置晚他摄入量
     *
     * @param dinnarFood 晚他摄入量
     */
    public void setDinnarFood(String dinnarFood) {
        this.dinnarFood = dinnarFood == null ? null : dinnarFood.trim();
    }

    /**
     * 获取其它摄入量
     *
     * @return other_food - 其它摄入量
     */
    public String getOtherFood() {
        return otherFood;
    }

    /**
     * 设置其它摄入量
     *
     * @param otherFood 其它摄入量
     */
    public void setOtherFood(String otherFood) {
        this.otherFood = otherFood == null ? null : otherFood.trim();
    }

    /**
     * 获取创建时间
     *
     * @return cerate_date - 创建时间
     */
    public Date getCerateDate() {
        return cerateDate;
    }

    /**
     * 设置创建时间
     *
     * @param cerateDate 创建时间
     */
    public void setCerateDate(Date cerateDate) {
        this.cerateDate = cerateDate;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", basalMetabolism=").append(basalMetabolism);
        sb.append(", breakfastKcal=").append(breakfastKcal);
        sb.append(", lunchKcal=").append(lunchKcal);
        sb.append(", dinnarKcal=").append(dinnarKcal);
        sb.append(", powerLevel=").append(powerLevel);
        sb.append(", breakfastFood=").append(breakfastFood);
        sb.append(", lunchFood=").append(lunchFood);
        sb.append(", dinnarFood=").append(dinnarFood);
        sb.append(", otherFood=").append(otherFood);
        sb.append(", cerateDate=").append(cerateDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", recommendUptake=").append(recommendUptake);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}