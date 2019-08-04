package com.admin.service.Impl;

import com.admin.dao.saveSysLogDao;
import com.admin.domain.SysLog;
import com.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private saveSysLogDao saveSysLogDao;

    @Override
    public void saveSysLog(SysLog sysLog) throws Exception {
        saveSysLogDao.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {

        return  saveSysLogDao.findAll();
    }
}
