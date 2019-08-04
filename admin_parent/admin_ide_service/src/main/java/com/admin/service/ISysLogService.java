package com.admin.service;

import com.admin.domain.SysLog;

import java.util.List;

public interface ISysLogService {

   void  saveSysLog(SysLog sysLog) throws Exception;

   List<SysLog> findAll() throws Exception;
}
