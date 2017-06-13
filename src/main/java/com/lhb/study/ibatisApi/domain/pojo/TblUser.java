/*
* Copyright (c) 117, lhb All Rights Reserved.
*/
package com.lhb.study.ibatisApi.domain.pojo;

import com.lhb.plug.dynamicibatis.domain.BasePojo;

import java.math.BigDecimal;
import java.util.Date;

/**
* 用户表实体类
*
* @author lianghuaibin
* @since 2017/06/13
*/
public class TblUser extends BasePojo {

    /**
     * 用户账号
     */
    public final static String COLUMN_ACCOUNT = "ACCOUNT";
    /**
     * 用户姓名
     */
    public final static String COLUMN_USERNAME = "USERNAME";
    /**
     * 登陆密码
     */
    public final static String COLUMN_PASSWORD = "PASSWORD";
    /**
     * 性别0女1男
     */
    public final static String COLUMN_SEX = "SEX";
    /**
     * 年龄
     */
    public final static String COLUMN_AGE = "AGE";
    /**
     * 最后修改时间
     */
    public final static String COLUMN_MODIFIED_TIME = "MODIFIED_TIME";

    private String account;    //用户账号
    private String username;    //用户姓名
    private String password;    //登陆密码
    private String sex;    //性别0女1男
    private Integer age;    //年龄
    private Date modifiedTime;    //最后修改时间

    /**
     * 用户账号
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 用户账号
     * @return account
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * 用户姓名
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户姓名
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 登陆密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 登陆密码
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 性别0女1男
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 性别0女1男
     * @return sex
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 年龄
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 年龄
     * @return age
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 最后修改时间
     * @param modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 最后修改时间
     * @return modifiedTime
     */
    public Date getModifiedTime() {
        return this.modifiedTime;
    }


}