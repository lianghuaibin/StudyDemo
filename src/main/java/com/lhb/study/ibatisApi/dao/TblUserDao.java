/*
 * Copyright (c) 117, lhb All Rights Reserved.
 */
package com.lhb.study.ibatisApi.dao;

import com.lhb.study.ibatisApi.domain.pojo.TblUser;
import com.lhb.study.ibatisApi.domain.query.TblUserQuery;
import com.lhb.plug.dynamicibatis.impl.ApiBaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * 用户表Dao层
 *
 * @author lianghuaibin
 * @since 2017/06/13
 */
@Repository("apiTblUserDao")
public class TblUserDao extends ApiBaseDaoImpl<TblUser,TblUserQuery> {

    /**
     * 构造函数
     */
    public TblUserDao() {
        super(TblUser.class);
    }
}
