package com.smg.springmvc.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smg.springmvc.dao.DashboardDao;
import com.smg.springmvc.dao.MessageDao;
 
@Service("dashboardService")
@Transactional
public class DashboardServiceImpl implements DashboardService {
 
    @Autowired
    private DashboardDao dao;
    
    @Autowired 
    private MessageDao messageDao;

    public Long countRegistered() {
        return dao.countRegistered();
    }
    
    public Long countMessage() {
    	return messageDao.countMessage();
    }
 
}