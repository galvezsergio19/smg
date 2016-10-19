package com.smg.springmvc.controller;

import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.smg.springmvc.model.Employee;
import com.smg.springmvc.service.RegistrationService;
import com.smg.springmvc.utility.PasswordValidator;
 
@Controller
@RequestMapping("/")
public class RegistrationController {
 
    @Autowired
    RegistrationService registerService;
     
    @Autowired
    MessageSource messageSource;
    
    private String winUserName = System.getProperty("user.name");
    private PasswordValidator passwordValidator;
 
    private String INVALID_EMPLOYEE_PASSWORD = "Invalid.employee.password";
    private String INVALID_EMPLOYEE_RETYPE_PASSWORD = "Invalid.employee.retype_password";
    private String SUCCESS_EMPLOYEE_REGISTRATION = "Success.employee.registration";
    private String INVALID_EMPLOYEE_REGISTRATION = "Invalid.employee.registration";
    
    private String PROFILE_PICTURE = "profile.picture";
    
    /*
     * This method will be called calling the link
     *  for registration page/screen
     */
    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String showRegister(ModelMap model) {
    	model.addAttribute("pageTitle", "Registration");
        model.addAttribute("employee", new Employee());
        model.addAttribute("winUserName", winUserName);
        
        // Check DB if user name exists
        Employee employee = registerService.findEmployeeByUsername(winUserName);
        if (employee!=null) {
        	model.addAttribute("alert", "danger");
        	model.addAttribute("message", messageSource.getMessage(
        			INVALID_EMPLOYEE_REGISTRATION, null, Locale.getDefault()));
        }
    	return "register";
    }
    
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String saveRegistration(
    		@Valid Employee employee, BindingResult result,
    		ModelMap model) {
    	model.addAttribute("pageTitle", "Register");
    	
    	// Binding validation check (@Size)
    	if (result.hasErrors()) {
    		return "register";
    	}
    	
    	// Check Password complexity
    	passwordValidator = new PasswordValidator();
    	if (!passwordValidator.validate(employee.getPassword())) {
    		FieldError password_error =new FieldError("employee","password",
    				messageSource.getMessage(INVALID_EMPLOYEE_PASSWORD, null, Locale.getDefault()));
    		result.addError(password_error);
    		return "register";
    	}
    	
    	// Checking if Password and Retype Password same
    	if (!employee.getPassword().equals("") && !employee.getRetype_password().equals("") &&
    			!employee.getPassword().equals(employee.getRetype_password())) {
    		
    		FieldError retype_password_error =new FieldError("employee","retype_password",
    				messageSource.getMessage(INVALID_EMPLOYEE_RETYPE_PASSWORD, null, Locale.getDefault()));
    		result.addError(retype_password_error);
    		return "register";
    	}
       
    	// Save information to DB
    	employee.setRegister_date(new Date());
    	employee.setProfile_picture(messageSource.getMessage(PROFILE_PICTURE, 
    			null, Locale.getDefault()));
    	registerService.saveEmployee(employee);
    	model.addAttribute("message", messageSource.getMessage(SUCCESS_EMPLOYEE_REGISTRATION, 
    			new String[]{employee.getFull_name()}, Locale.getDefault()));
    	model.addAttribute("alert", "success");
    	return "register";
  }
 
}