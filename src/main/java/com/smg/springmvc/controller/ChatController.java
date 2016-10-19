package com.smg.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.smg.springmvc.model.Message;
import com.smg.springmvc.service.MessageService;
 
@Controller
@RequestMapping("/")
public class ChatController {
     
	@Autowired
	MessageService messageService;
	
    @Autowired
    MessageSource messageSource;
    
    private static String PROJECT_PATH = "/springexample";
    
    @RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
    public @ResponseBody
    String showLogin(@RequestParam(value = "message", required = true) String messageText,
    		@RequestParam(value = "recepient", required = false) String recepient,
    		ModelMap model, HttpSession session) {
    	
    	if(recepient.equals("All")) recepient="";
    	Message message = new Message();
    	Employee employee = (Employee) session.getAttribute("employee");
    	message.setUsername(employee.getUsername());
    	message.setMessage(messageText);
    	message.setCreatedate(new Date());
    	message.setRecepient(recepient);
    	messageService.saveMessage(message);
    	return "forward:/dashboard";
    }
    
    
    @RequestMapping(value = "/chatMessage", method = RequestMethod.GET)
    public @ResponseBody
    String getMessage(@RequestParam(value = "contact", required = false) String recepient,
    		HttpSession session) throws ParseException {
    	
    	String chat_message = "";
    	String result = "";
    	List<Message> messages = null;
    	Date previousDate = null;
    	Date currentDate = null;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
    	Employee sessionEmployee = (Employee) session.getAttribute("employee");
    	
    	String collapsible_end = "</div></div></div>";
    	
        if ( recepient.equals("")) messages = messageService.getMessage();
        if (!recepient.equals("")) messages = messageService.getMessageByContact(
        		sessionEmployee.getUsername(), recepient);
        for (Message message : messages) {
        	
        	String[] chat_display = new String[]{"", "pull-left", "pull-right"};
        	if (message.getUsername()!=null &&
        		sessionEmployee.getUsername().equals(message.getUsername())) { 
        		chat_display = new String[]{"right", "pull-right", "pull-left"}; }
        	Employee employee = messageService.getFullName(message.getUsername());
        	currentDate = sdf.parse(sdf.format(message.getCreatedate()));
    		
    		chat_message = 
        			"<div class=\"direct-chat-msg " + chat_display[0] + "\">" +
			        "<div class=\"direct-chat-info clearfix\">" +
			        "<span class=\"direct-chat-name " + chat_display[1] + "\">" + 
			        employee.getFull_name() + "</span>" +
			        "<span class=\"direct-chat-timestamp " + chat_display[2] + "\">" + message.getCreatedate() + "</span>" +
			        "</div>" +
			        "<img class=\"direct-chat-img\" src=\"" + PROJECT_PATH + 
			        employee.getProfile_picture() +"\" "
			        	+ "alt=\"message user image\">" +
			        "<div class=\"direct-chat-text " + chat_display[1] + "\" "
			        		+ "style=\"word-break: break-all; width: 75%;\">" +
			        message.getMessage() +
			        "</div></div>";
        	
    		// Start
    		if (previousDate==null) {
    			result += collapsible_start(currentDate) + chat_message;
    			
    		} else {
    		
	    		// Chat Message
	    		if (currentDate.compareTo(previousDate)==0) {
	    			result += chat_message;
	    		}
	    		
    			//End 
				if (currentDate.compareTo(previousDate)!=0) {
					result += collapsible_end;
					result += collapsible_start(currentDate) + chat_message;
					previousDate = null;
				}
				
    		}
			
        	previousDate = sdf.parse(sdf.format(message.getCreatedate()));
		}
        
        result += collapsible_end;
        return result;
    }
    
    
    @RequestMapping(value = "/getOnlineStatus", method = RequestMethod.GET)
    public @ResponseBody
    String getOnlineStatus(HttpSession session) {
    	
    	Integer result = 0;
    	String resultString = "";
    	Employee sessionEmployee = (Employee) session.getAttribute("employee");
    	result = sessionEmployee.getOnline_status();
    	resultString = String.valueOf(result);
    	return resultString;
    }
    
    @RequestMapping(value = "/updateOnlineStatus", method = RequestMethod.POST)
    public @ResponseBody
    String updateOnlineStatus(@RequestParam(value = "status", required = true) int status,
    		ModelMap model, HttpSession session) {
    	Employee employee = (Employee) session.getAttribute("employee");
    	employee.setOnline_status(status);
    	messageService.updateOnlineStatus(employee.getUsername(), employee.getOnline_status());
    	return "forward:/dashboard";
    }
    
    @RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
    public @ResponseBody
    String deleteMessage(HttpSession session) {
    	String result = "";
    	messageService.deleteMessage();
    	return result;
    }
    
    @RequestMapping(value = "/getContacts", method = RequestMethod.GET)
    public @ResponseBody
    String getContacts(HttpSession session) {
    	
    	String result = "";
        Employee sessionEmployee = (Employee) session.getAttribute("employee");
        List<Employee> contacts = messageService.getContacts(sessionEmployee.getUsername());
        
        result = "<li><button class=\"btn-block btn-link\" style=\"text-align: left;\" " +
        		"value=\"all\" " +
        		"onclick=\"passRecepient('All')\">" +
    			"<img class=\"contacts-list-img\" "  +
    			"src=\"/springexample/resources/dist/img/user1-128x128.jpg\" alt=\"User Image\">" +
				"<div class=\"contacts-list-info\">" +
                "<span class=\"contacts-list-name\">" +
                "GROUP Chat" +
                "<i class=\"fa fa-square text-green pull-right\"></i>" +
                "</span>" +
            	"<span class=\"contacts-list-msg\">Email for everyone</span>" +
          		"</div></button></li>";
        
        for (Employee contact : contacts) {
        	
        	String onine_status = "red";
        	if (contact.getOnline_status()==1 &&
        			contact.getOnline_status()!=null) onine_status = "green";
        	Employee employee = messageService.getFullName(contact.getUsername());
        	
        	result+= 
        			"<li>" +
        			"<button class=\"btn-block btn-link\" style=\"text-align: left;\" " +
        			"value=\"" + contact.getUsername() + "\" " +
        			"onclick=\"passRecepient($(this).val())\">" +
        			"<img class=\"contacts-list-img\" src=\"" +
        			PROJECT_PATH + employee.getProfile_picture() + "\" " + 
        			"alt=\"User Image\">" +
        			"<div class=\"contacts-list-info\">" +
        			"<span class=\"contacts-list-name\">" +
        			contact.getFull_name() +
  					"<i class=\"fa fa-square " +
  					"text-" + onine_status +
  					" pull-right\"></i>" + 
  					"</span>" +
  					"<span class=\"contacts-list-msg\">" + 
  					"How have you been? I was..." + "</span>" +
  					"</div>" +
  					"</button>" +
  					"</li>";
		}
        return result;
    }
    
    public String collapsible_start(Date collapse_date) {
    	
    	return 	"<div class=\"panel box box-primary\">" +
				"<div class=\"box-header with-border\">" +
				"<h4 class=\"box-title\">" +
				"<a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#" +
				new SimpleDateFormat("MMddyyyy").format(collapse_date) + "\">" +
				new SimpleDateFormat("MMMMM dd, yyyy").format(collapse_date) +
				"</a></h4></div><div id=\"" +
				new SimpleDateFormat("MMddyyyy").format(collapse_date) + "\" " +
				"class=\"panel-collapse collapse in\">" +
				"<div class=\"box-body\">";
    }
    
    
}