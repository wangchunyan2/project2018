package com.myplate.pojo;

import java.util.Date;

/**
 * Description:
 * Program Name:
 * author :john
 * Date:2018-10-2018/10/13  23:55  星期六
 * version 1.0
 */
public class TsPersonInfo {

    private  Integer id;
    //昵称
    private  String userName;
    //年龄
    private  Integer userAge;
    //身高
    private  String userHeight;
    //体重
    private  String userWeight;
    //创建日期
    private Date createDate;
    //创建人
    private  String createBy;
    //性别
    private  String usersex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }


    @Override
    public String toString() {
        return "TsPersonInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userHeight='" + userHeight + '\'' +
                ", userWeight='" + userWeight + '\'' +
                ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }
}
