/*
* Copyright (c) 117, lhb All Rights Reserved.
*/
package com.lhb.study.ibatisApi.domain.query;

import com.lhb.plug.dynamicibatis.domain.BaseQuery;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表查询实体类
 *
 * @author lianghuaibin
 * @since 2017/06/13
 */
public class TblUserQuery extends BaseQuery<TblUserQuery> {

    private static final long serialVersionUID = 1L;

    private String account;    //用户账号
    private String[] account_IN;   //用户账号 IN查询
    private String account_NE;   //用户账号 不等于
    private String account_LK;   //用户账号 LIKE查询
    private String username;    //用户姓名
    private String[] username_IN;   //用户姓名 IN查询
    private String username_NE;   //用户姓名 不等于
    private String username_LK;   //用户姓名 LIKE查询
    private String password;    //登陆密码
    private String[] password_IN;   //登陆密码 IN查询
    private String password_NE;   //登陆密码 不等于
    private String password_LK;   //登陆密码 LIKE查询
    private String sex;    //性别0女1男
    private String[] sex_IN;   //性别0女1男 IN查询
    private String sex_NE;   //性别0女1男 不等于
    private String sex_LK;   //性别0女1男 LIKE查询
    private Integer age;    //年龄
    private Integer[] age_IN;   //年龄 IN查询
    private Integer age_NE;   //年龄 不等于
    private Integer age_LT;   //年龄 小于
    private Integer age_LE;   //年龄 小于等于
    private Integer age_GT;   //年龄 大于
    private Integer age_GE;   //年龄 大于等于
    private Date modifiedTime;    //最后修改时间
    private Date[] modifiedTime_IN;   //最后修改时间 IN查询
    private Date modifiedTime_NE;   //最后修改时间 不等于
    private Date modifiedTime_LT;   //最后修改时间 小于
    private Date modifiedTime_LE;   //最后修改时间 小于等于
    private Date modifiedTime_GT;   //最后修改时间 大于
    private Date modifiedTime_GE;   //最后修改时间 大于等于

    /**
     * 用户账号
     * @return
     */
    public String getAccount() {
        return account;
    }

    /**
     * 用户账号
     * @return
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 用户账号 IN查询
     * @return
     */
    public String[] getAccount_IN() {
        return account_IN;
    }

    /**
     * 用户账号 IN查询
     * @return
     */
    public void setAccount_IN(String[] account_IN) {
        this.account_IN = account_IN;
    }

    /**
     * 用户账号 不等于
     * @return
     */
    public String getAccount_NE() {
        return account_NE;
    }

    /**
     * 用户账号 不等于
     * @return
     */
    public void setAccount_NE(String account_NE) {
        this.account_NE = account_NE;
    }


	/**
     * 用户账号 LIKE查询
     * @return
     */
    public String getAccount_LK() {
        return account_LK;
    }

    /**
     * 用户账号 LIKE查询
     * @return
     */
    public void setAccount_LK(String account_LK) {
        this.account_LK = account_LK;
    }

    /**
     * 用户姓名
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户姓名
     * @return
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户姓名 IN查询
     * @return
     */
    public String[] getUsername_IN() {
        return username_IN;
    }

    /**
     * 用户姓名 IN查询
     * @return
     */
    public void setUsername_IN(String[] username_IN) {
        this.username_IN = username_IN;
    }

    /**
     * 用户姓名 不等于
     * @return
     */
    public String getUsername_NE() {
        return username_NE;
    }

    /**
     * 用户姓名 不等于
     * @return
     */
    public void setUsername_NE(String username_NE) {
        this.username_NE = username_NE;
    }


	/**
     * 用户姓名 LIKE查询
     * @return
     */
    public String getUsername_LK() {
        return username_LK;
    }

    /**
     * 用户姓名 LIKE查询
     * @return
     */
    public void setUsername_LK(String username_LK) {
        this.username_LK = username_LK;
    }

    /**
     * 登陆密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登陆密码
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 登陆密码 IN查询
     * @return
     */
    public String[] getPassword_IN() {
        return password_IN;
    }

    /**
     * 登陆密码 IN查询
     * @return
     */
    public void setPassword_IN(String[] password_IN) {
        this.password_IN = password_IN;
    }

    /**
     * 登陆密码 不等于
     * @return
     */
    public String getPassword_NE() {
        return password_NE;
    }

    /**
     * 登陆密码 不等于
     * @return
     */
    public void setPassword_NE(String password_NE) {
        this.password_NE = password_NE;
    }


	/**
     * 登陆密码 LIKE查询
     * @return
     */
    public String getPassword_LK() {
        return password_LK;
    }

    /**
     * 登陆密码 LIKE查询
     * @return
     */
    public void setPassword_LK(String password_LK) {
        this.password_LK = password_LK;
    }

    /**
     * 性别0女1男
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别0女1男
     * @return
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 性别0女1男 IN查询
     * @return
     */
    public String[] getSex_IN() {
        return sex_IN;
    }

    /**
     * 性别0女1男 IN查询
     * @return
     */
    public void setSex_IN(String[] sex_IN) {
        this.sex_IN = sex_IN;
    }

    /**
     * 性别0女1男 不等于
     * @return
     */
    public String getSex_NE() {
        return sex_NE;
    }

    /**
     * 性别0女1男 不等于
     * @return
     */
    public void setSex_NE(String sex_NE) {
        this.sex_NE = sex_NE;
    }


	/**
     * 性别0女1男 LIKE查询
     * @return
     */
    public String getSex_LK() {
        return sex_LK;
    }

    /**
     * 性别0女1男 LIKE查询
     * @return
     */
    public void setSex_LK(String sex_LK) {
        this.sex_LK = sex_LK;
    }

    /**
     * 年龄
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @return
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 年龄 IN查询
     * @return
     */
    public Integer[] getAge_IN() {
        return age_IN;
    }

    /**
     * 年龄 IN查询
     * @return
     */
    public void setAge_IN(Integer[] age_IN) {
        this.age_IN = age_IN;
    }

    /**
     * 年龄 不等于
     * @return
     */
    public Integer getAge_NE() {
        return age_NE;
    }

    /**
     * 年龄 不等于
     * @return
     */
    public void setAge_NE(Integer age_NE) {
        this.age_NE = age_NE;
    }

    /**
     * 年龄 小于
     * @return
     */
    public Integer getAge_LT() {
        return age_LT;
    }

    /**
     * 年龄 小于
     * @return
     */
    public void setAge_LT(Integer age_LT) {
        this.age_LT = age_LT;
    }

    /**
     * 年龄 小于等于
     * @return
     */
    public Integer getAge_LE() {
        return age_LE;
    }

    /**
     * 年龄 小于等于
     * @return
     */
    public void setAge_LE(Integer age_LE) {
        this.age_LE = age_LE;
    }

    /**
     * 年龄 大于
     * @return
     */
    public Integer getAge_GT() {
        return age_GT;
    }

    /**
     * 年龄 大于
     * @return
     */
    public void setAge_GT(Integer age_GT) {
        this.age_GT = age_GT;
    }

    /**
     * 年龄 大于等于
     * @return
     */
    public Integer getAge_GE() {
        return age_GE;
    }

    /**
     * 年龄 大于等于
     * @return
     */
    public void setAge_GE(Integer age_GE) {
        this.age_GE = age_GE;
    }


    /**
     * 最后修改时间
     * @return
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 最后修改时间
     * @return
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * 最后修改时间 IN查询
     * @return
     */
    public Date[] getModifiedTime_IN() {
        return modifiedTime_IN;
    }

    /**
     * 最后修改时间 IN查询
     * @return
     */
    public void setModifiedTime_IN(Date[] modifiedTime_IN) {
        this.modifiedTime_IN = modifiedTime_IN;
    }

    /**
     * 最后修改时间 不等于
     * @return
     */
    public Date getModifiedTime_NE() {
        return modifiedTime_NE;
    }

    /**
     * 最后修改时间 不等于
     * @return
     */
    public void setModifiedTime_NE(Date modifiedTime_NE) {
        this.modifiedTime_NE = modifiedTime_NE;
    }

    /**
     * 最后修改时间 小于
     * @return
     */
    public Date getModifiedTime_LT() {
        return modifiedTime_LT;
    }

    /**
     * 最后修改时间 小于
     * @return
     */
    public void setModifiedTime_LT(Date modifiedTime_LT) {
        this.modifiedTime_LT = modifiedTime_LT;
    }

    /**
     * 最后修改时间 小于等于
     * @return
     */
    public Date getModifiedTime_LE() {
        return modifiedTime_LE;
    }

    /**
     * 最后修改时间 小于等于
     * @return
     */
    public void setModifiedTime_LE(Date modifiedTime_LE) {
        this.modifiedTime_LE = modifiedTime_LE;
    }

    /**
     * 最后修改时间 大于
     * @return
     */
    public Date getModifiedTime_GT() {
        return modifiedTime_GT;
    }

    /**
     * 最后修改时间 大于
     * @return
     */
    public void setModifiedTime_GT(Date modifiedTime_GT) {
        this.modifiedTime_GT = modifiedTime_GT;
    }

    /**
     * 最后修改时间 大于等于
     * @return
     */
    public Date getModifiedTime_GE() {
        return modifiedTime_GE;
    }

    /**
     * 最后修改时间 大于等于
     * @return
     */
    public void setModifiedTime_GE(Date modifiedTime_GE) {
        this.modifiedTime_GE = modifiedTime_GE;
    }



}