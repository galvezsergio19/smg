package com.smg.springmvc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smg.springmvc.model.Employee;
import com.smg.springmvc.model.TodoList;
import com.smg.springmvc.service.DashboardService;
import com.smg.springmvc.service.TodolistService;
 
@Controller
@RequestMapping("/")
public class TodolistController {
     
	@Autowired
	TodolistService todolistService;
	
	@Autowired
	DashboardService dashboardService;
	
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = "/todoList", method = RequestMethod.GET)
    public @ResponseBody
    String getTodoList(HttpSession session) {
    	
    	String result = "";
    	Employee employee = (Employee) session.getAttribute("employee");
    	List<TodoList> todoLists = todolistService.getTodoList(employee.getUsername());
    	
    	for (TodoList todoList : todoLists) {
    		
    		int priority = todoList.getPriority();
    		String priority_class = "";
    		
    		switch(priority) {
    			case 1: priority_class = "box box-success box-solid"; break;
    			case 2: priority_class = "box box-info box-solid"; break;
    			case 3: priority_class = "box box-warning box-solid"; break;
    			default: priority_class = "box box-warning box-solid"; break;
    		}
    		
    		result += 
    				"<li class=\"" + priority_class + " " 
    				+	(todoList.getStatus()==1?"done":"") + "\">" 
    				+ "<span class=\"handle\">" 
		            + "<i class=\"fa fa-ellipsis-v\"></i>" 
		            + "<i class=\"fa fa-ellipsis-v\"></i>" 
	                + "</span>" 
	                + "<input type=\"checkbox\" value=\"\" "
	                + (todoList.getStatus()==1?"checked ":"")
	                + "id=\"" + "chk" + todoList.getOrderid() + "\" onclick=\"status_update($(this).attr('id'))\">" 
				    + "<span class=\"text\">" + todoList.getTitle() + "</span>" 
	                + "<small class=\"label label-danger\"><i class=\"fa fa-clock-o\"></i> "
				    + date_diff(todoList.getCreate_date())
	                + "</small>" 
	                + "<div class=\"tools\">"  
	                + "<i class=\"fa fa-edit\"></i>" 
	                + "<i class=\"fa fa-trash-o\"></i>" 
	                + "</div>" 
                	+ "</li>";
    	}
    	
    	return result;
    }
    
    @RequestMapping(value = "/todoList_count", method = RequestMethod.GET)
    public @ResponseBody
    String getTodoListCount(HttpSession session) {
    	
    	int counter = 0;
    	Employee employee = (Employee) session.getAttribute("employee");
    	List<TodoList> todoLists = todolistService.getTodoList(employee.getUsername());
    	for (TodoList todoList : todoLists) {
    		if (todoList.getStatus()==0) counter++;
    	}
    	return String.valueOf(counter);
    }
    
    @RequestMapping(value = "/updateTodoStatus", method = RequestMethod.POST)
    public @ResponseBody
    String updateOnlineStatus(@RequestParam(value = "todo_status", required = true) String status,
    		@RequestParam(value = "orderid", required = true) int orderid,
    		ModelMap model, HttpSession session) {
    	int status_equiv = 0;
    	if (status.equals("todo")) status_equiv=1;
    	Employee employee = (Employee) session.getAttribute("employee");
    	todolistService.updateTodoStatus(employee.getUsername(), orderid, status_equiv);
    	return "forward:/dashboard";
    }
     
    
    public String date_diff(Date d2) {
		String result = "";
		try {
			
			long diff = new Date().getTime() - d2.getTime(); 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			long diffWeeks = diff / (60 * 60 * 1000 * 24 * 7);
		    long diffMonths = (long) (diff / (60 * 60 * 1000 * 24 * 30.41666666));
		    long diffYears = (long)(diff / (1000L * 60L * 60L * 24L * 365L));

		    if (diffYears!=0) result = String.valueOf(diffYears)  + " year(s)";
			else if (diffMonths!=0) result = String.valueOf(diffMonths)  + " month(s)";
			else if (diffWeeks!=0) result = String.valueOf(diffWeeks)  + " week(s)";
			else if (diffDays!=0) result = String.valueOf(diffDays)  + " day(s)";
			else if (diffHours!=0) result = String.valueOf(diffHours)  + " hour(s)";
			else if (diffMinutes!=0) result = String.valueOf(diffMinutes)  + " minutes(s)";
			else if (diffSeconds!=0) result = String.valueOf(diffSeconds)  + " second(s)";

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
    }
    
    
}