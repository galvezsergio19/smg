//package com.smg.springmvc.dao;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
// 
//@Repository("fileUploadDao")
//public class FileUploadDaoImpl implements FileUploadDAO { 
//    
//	@Autowired
//    private SessionFactory sessionFactory;
// 
//    @Override
//    @Transactional
//    public void save(UploadFile uploadFile) {
//        sessionFactory.getCurrentSession().save(uploadFile);
//    }
// 
//}