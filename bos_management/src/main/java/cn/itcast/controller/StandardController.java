package cn.itcast.controller;


import cn.itcast.domain.Standard;

import cn.itcast.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.PageFormat;
import java.util.HashMap;
import java.util.Map;


@Controller
public class StandardController {

    @Autowired
    private StandardService standardService;

    @RequestMapping("/standard_save")
    public String save(Standard standard){
        standardService.save(standard);
        return "redirect:/pages/base/standard.html";
    }

    @RequestMapping("/standard_pageQuery")
    @ResponseBody
    public Map pageQuery(int page,int rows){
        Page<Standard> pages = standardService.pageQuery(page, rows);
        Map map= new HashMap<>();
        map.put("total",pages.getTotalElements());
        map.put("rows",pages.getContent());
        return map;
    }
}
