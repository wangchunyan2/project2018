package com.myplate.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ts_person_info")
public class TsPersonInfo implements Serializable {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 身高
     */
    @Column(name = "user_height")
    private String userHeight;

    /**
     * 体重
     */
    @Column(name = "user_weight")
    private String userWeight;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private String userSex;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取年龄
     *
     * @return user_age - 年龄
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * 设置年龄
     *
     * @param userAge 年龄
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取身高
     *
     * @return user_height - 身高
     */
    public String getUserHeight() {
        return userHeight;
    }

    /**
     * 设置身高
     *
     * @param userHeight 身高
     */
    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight == null ? null : userHeight.trim();
    }

    /**
     * 获取体重
     *
     * @return user_weight - 体重
     */
    public String getUserWeight() {
        return userWeight;
    }

    /**
     * 设置体重
     *
     * @param userWeight 体重
     */
    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight == null ? null : userWeight.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userAge=").append(userAge);
        sb.append(", userHeight=").append(userHeight);
        sb.append(", userWeight=").append(userWeight);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", userSex=").append(userSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}