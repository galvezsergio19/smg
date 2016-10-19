package com.smg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.smg.springmvc.service.MessageService;
 
@Controller
@RequestMapping("/")
public class ProfileController {
     
	@Autowired
	MessageService messageService;
	
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = "/uploadProfile", method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) {
    	
//    	if (fileUpload != null && fileUpload.length > 0) {
//            for (CommonsMultipartFile aFile : fileUpload){
//
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//                UploadFile uploadFile = new UploadFile();
//                uploadFile.setFileName(aFile.getOriginalFilename());
//                uploadFile.setData(aFile.getBytes());
//                fileUploadDao.save(uploadFile);               
//            }
//        }
  
        return "Success";
    }
    
}