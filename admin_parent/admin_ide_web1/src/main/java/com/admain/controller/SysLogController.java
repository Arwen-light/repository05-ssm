package com.admain.controller;

import com.admin.domain.SysLog;
import com.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
///sysLog/findAll.do
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService iSysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView fingAllSysLog() throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> logsList = iSysLogService.findAll();
        modelAndView.addObject("sysLogs", logsList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;

    }

}
