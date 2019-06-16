package com.daimabaike.biz.foo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;


@Controller
public class LineAController {

    @RequestMapping("page")
    public String page(Model model) {



        model.addAttribute("dateTime", new Date());
        return "page";
    }
}
