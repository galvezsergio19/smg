package com.smg.springmvc.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smg.springmvc.model.Employee;
import com.smg.springmvc.service.LoginService;
 
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;
     
    @Autowired
    MessageSource messageSource;
    
    private String winUserName = System.getProperty("user.name");
    private String INVALID_EMPLOYEE_LOGIN = "Invalid.employee.login";
    private String FAILED_EMPLOYEE_LOGIN = "Failed.employee.login";
    
    /*
     * This method will be called calling the link
     *  for login page/screen
     */
    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public String showLogin(ModelMap model, HttpSession session) {
    	
    	Employee employee = (Employee) session.getAttribute("employee");
    	model.addAttribute("employee", employee);
    	if (employee != null) return "redirect:/dashboard";
    	
    	model.addAttribute("pageTitle", "Login");
    	model.addAttribute("employee", new Employee());
    	model.addAttribute("winUserName", winUserName);
    	return "login";
    }
    
    /*
     * This method will be called calling the submission
     *  for login credentials. User will be validated.
     */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
    public String showDashboard(@ModelAttribute Employee employee, 
    		BindingResult result, ModelMap model, HttpSession session) {
		
    	Employee employeeUsername = loginService.findEmployeeByUsername(employee.getUsername());
        Employee employeeUsernamePassword = loginService.findEmployeeByUsernamePassword(
    			employee.getUsername(),employee.getPassword());
    	
    	if (employeeUsernamePassword!=null) {
    		session.setAttribute("employee", employeeUsernamePassword);
    		loginService.updateLoginDate(employeeUsernamePassword.getUsername(), new Date());
    		return "redirect:/dashboard"; 
    		
    	} else {
        	model.addAttribute("alert", "danger");
        	model.addAttribute("message", messageSource.getMessage(
        			FAILED_EMPLOYEE_LOGIN, null, Locale.getDefault()));
        }
    	
    	if (employeeUsername==null) {
    		model.addAttribute("alert", "danger");
        	model.addAttribute("message", messageSource.getMessage(
        			INVALID_EMPLOYEE_LOGIN, null, Locale.getDefault()));
    	}
    	
    	model.addAttribute("pageTitle", "Login"); 
        return "login";
    }    
    
 
}