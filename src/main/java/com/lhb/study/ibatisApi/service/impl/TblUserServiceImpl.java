/*
 * Copyright (c) 117, lhb All Rights Reserved.
 */
package com.lhb.study.ibatisApi.service.impl;

import com.lhb.plug.dynamicibatis.ApiBaseDao;
import com.lhb.plug.dynamicibatis.impl.ApiBaseServiceImpl ;
import com.lhb.study.ibatisApi.dao.TblUserDao;
import com.lhb.study.ibatisApi.domain.pojo.TblUser;
import com.lhb.study.ibatisApi.domain.query.TblUserQuery;
import com.lhb.study.ibatisApi.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表Service实现
 *
 * @author lianghuaibin
 * @since 2017/06/13
 */
@Service("apiTblUserService")
public class TblUserServiceImpl extends ApiBaseServiceImpl<TblUser, TblUserQuery> implements TblUserService {

    @Autowired
    private TblUserDao tblUserDao;

    @Override
    public ApiBaseDao<TblUser, TblUserQuery> getApiBaseDao() {
        return tblUserDao;
    }
}
