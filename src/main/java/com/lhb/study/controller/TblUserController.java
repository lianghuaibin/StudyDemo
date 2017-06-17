package com.lhb.study.controller;

import com.alibaba.fastjson.JSON;
import com.lhb.study.ibatisApi.domain.pojo.TblUser;
import com.lhb.study.ibatisApi.domain.query.TblUserQuery;
import com.lhb.study.ibatisApi.service.TblUserService;
import com.lhb.study.util.AjaxUtil;
import com.lhb.study.util.enumtype.SexEnum;
import com.lhb.study.util.frame.BeanResult;
import com.lhb.study.util.paging.PageKit;
import com.lhb.study.util.paging.PageListResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class TblUserController {

//    protected static final Logger log = LoggerFactory.getLogger(TblUserController.class);

    @Autowired
    TblUserService userServiceApi;

    @RequestMapping("/skipPage")
    public String skipPage(String view,ModelMap map){
        view="user/userIndex";
//        List<TblUser> userList = userServiceApi.find(new TblUserQuery());
//        map.addAttribute("userList",userList);
        return view;
    }
    @RequestMapping(value = "user_ajax", method =  {RequestMethod.GET, RequestMethod.POST})
    public void user_ajax(@ModelAttribute TblUserQuery query,  @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "pageSize", defaultValue = "2") int pageSize,
                                   @RequestParam(required = false, value = "rowCount", defaultValue = "0") int rowCount, HttpServletResponse response) throws IOException {
        log.info("user_ajax param>>{},{},{}",JSON.toJSONString(query),pageNo,rowCount);
        PageKit pageKit = new PageKit(pageNo,rowCount,pageSize);
        query.page(pageNo,pageSize);
        query.orderBy(new String[]{TblUser.COLUMN_ID+" DESC"});

        List<TblUser> list = userServiceApi.find(query);
        if (!CollectionUtils.isEmpty(list)){
            for (TblUser user :list){
                user.setSex(SexEnum.getValueByKey(user.getSex()));
            }
        }
        PageListResult pageListResult = new PageListResult();
        pageListResult.setValues(list);
        pageListResult.setPageKit(pageKit);
        AjaxUtil.writer(response, JSON.toJSONString(pageListResult));
    }
    @RequestMapping(value = "user_ajax_page", method =  {RequestMethod.GET, RequestMethod.POST})
    public void user_ajax_page(@ModelAttribute TblUserQuery query,  @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "pageSize", defaultValue = "2") int pageSize,
                                   @RequestParam(required = false, value = "rowCount", defaultValue = "0") int rowCount, HttpServletResponse response) throws IOException {
        BeanResult result = new BeanResult();
        if (rowCount==0){
            rowCount = userServiceApi.count(query);
        }
        PageKit pageKit = new PageKit(pageNo,rowCount,pageSize);
        result.setValue(pageKit);
        AjaxUtil.writer(response, JSON.toJSONString(result));
    }

}
