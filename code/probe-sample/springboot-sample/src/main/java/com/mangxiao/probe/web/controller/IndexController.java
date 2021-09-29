package com.mangxiao.probe.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/p")
@RestController
public class IndexController {

    private static final Log log = LogFactory.getLog(IndexController.class);

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(@RequestParam("id") Long id){
        log.info("welcome id : " + id);
        return String.valueOf(id);
    }
}
