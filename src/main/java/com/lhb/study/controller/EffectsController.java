package com.lhb.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lianghuaibin
 * @since 2017/6/9
 */
@Controller
@RequestMapping("/effects")
public class EffectsController {

    @RequestMapping("/nest")
    public String canvasNest() {
        return "effects/canvasNest/canvasNest";
    }

    @RequestMapping("/star")
    public String canvasStar() {
        return "effects/canvasStar/index";
    }



}
