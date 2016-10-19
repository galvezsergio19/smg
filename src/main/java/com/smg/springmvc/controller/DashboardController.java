package com.smg.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smg.springmvc.model.Employee;
import com.smg.springmvc.model.Message;
import com.smg.springmvc.model.TodoList;
import com.smg.springmvc.service.DashboardService;
import com.smg.springmvc.service.TodolistService;
 
@Controller
@RequestMapping("/")
public class DashboardController {
     
	@Autowired
	DashboardService dashboardService;
	
	@Autowired
	TodolistService todolistService;
	
    @Autowired
    MessageSource messageSource;
    
    /*
     * This method will be called when login 
     *  was successful 
     */
    
    private static float MESSAGE_LIMIT = 1000;
    
    @RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
    public String showDashboard(ModelMap model, HttpSession session) {
    	
    	Employee employee = (Employee) session.getAttribute("employee");
    	if (employee == null) return "redirect:/login";
    	
    	model.addAttribute("employee", employee);
    	Float message_count = (float) dashboardService.countMessage();
    	Float message_count_convert = (message_count/MESSAGE_LIMIT) * new Long(100);
    	List<TodoList> todoLists = todolistService.getTodoList(employee.getUsername());
    	
    	model.addAttribute("message", new Message());
    	model.addAttribute("pageTitle", "Dashboard");
    	model.addAttribute("countRegistered", dashboardService.countRegistered());
    	model.addAttribute("countMessage", message_count_convert);
    	model.addAttribute("countTodoList", todoLists.size());
    	
    	return "dashboard";
    }
    
    /*
     * This method will be called when sign out  
     *  link was clicked
     */
    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String showLogout(ModelMap model, HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
 
}