package com.lhb.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @RequestMapping("/welcome")
    public String welcome(ModelMap map,String str){
        map.addAttribute("username", "freemarker");
        map.addAttribute("message","我会用你了！");
        map.addAttribute("str",str);
        return "welcome";
    }

    @RequestMapping("/dynamic/{str}")
    public String view(ModelMap map,@PathVariable("str") String str) {
        map.addAttribute("str",str);
        return "welcome";
    }

}
