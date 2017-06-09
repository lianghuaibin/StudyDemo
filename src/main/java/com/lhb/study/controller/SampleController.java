package com.lhb.study.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
@RestController
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/dynamic/{str}")
    public String view(@PathVariable("str") String str) {
        return "Hello World:"+str;
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    String home() {
        return "Hello World!";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

}
