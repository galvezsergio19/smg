<%@ include file="fragments/header.jspf" %>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper box box-info">
<%@ include file="fragments/top-header.jspf" %>
<%-- <%@ include file="fragments/sidebar.jspf" %> --%>
<div class="se-pre-con"></div>

	<div class="content-wrapper">
		<section class="content-header">
			<h1><spring:message code="view.label.dashboard"/><small>
			<spring:message code="view.label.control_panel"/></small></h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 
				<spring:message code="view.label.home"/></a></li>
				<li class="active"><spring:message code="view.label.dashboard"/></li>
			</ol>
		</section>

		<section class="content">
	
			<div class="row">
				<div class="col-lg-3 col-xs-6">
					<div class="small-box bg-aqua">
						<div class="inner"><h3>${countRegistered}</h3><p>Registered Employee</p></div>
						<div class="icon"><i class="ion ion-ios-people"></i></div>
					</div>
				</div>
	
		        <div class="col-lg-3 col-xs-6">
					<div class="small-box bg-green">
						<div class="inner"><h3>${countMessage}<sup style="font-size: 20px">%</sup></h3><p>Overall Message Limit Consumed</p></div>
						<div class="icon"><i class="ion ion-stats-bars"></i></div>
		          </div>
		        </div>
	
	        	<div class="col-lg-3 col-xs-6">
					<div class="small-box bg-yellow">
						<div class="inner"> <h3>44</h3><p>User Registrations</p></div>
						<div class="icon"><i class="ion ion-person-add"></i></div>
	          		</div>
	        	</div>
	
				<div class="col-lg-3 col-xs-6">
					<div class="small-box bg-red">
						<div class="inner"><h3>${countTodoList}</h3><p>To-do List / Tasks</p></div>
						<div class="icon"><i class="ion ion-pie-graph"></i></div>
	          		</div>
	        	</div>
			</div>
	      
			<div class="row">
	
				<section class="col-lg-4">
					
					<spring:message var="enter_placeholder" code="view.label.press_enter"/>
					<div class="box box-primary direct-chat direct-chat-primary" id="chat">
						<div class="box-header with-border">
							<i class="fa fa-comments-o"></i>
							<h3 class="box-title" id="box_title">Chat: All</h3>
							<div class="box-tools pull-right">
								<div class="btn-grouup" style="display: inline;">
									<c:if test="${employee.username eq 'admin'}">
										<button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" 
										title="Delete all" id="btn_delete">
										<i class="fa fa-trash text-red"></i>
									</button>
									</c:if>
									<button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" 
									title="Contacts" data-widget="chat-pane-toggle">
										<i class="fa fa-comments text-blue"></i>
									</button>
								</div>
								<div class="btn-group" data-toggle="btn-toggle">
									<button type="button" class="btn btn-default btn-sm" id="btn_online">
										<i class="fa fa-square text-green"></i>
									</button>
									<button type="button" class="btn btn-default btn-sm" id="btn_offline">
										<i class="fa fa-square text-red"></i>
									</button>
								</div>
							</div>
						</div>

						<div class="box-body" style="overflow:hidden;">
							<div class="direct-chat-messages" id="chat-box">
								<!-- Chat Message goes here -->
							</div>
							
							 <div class="direct-chat-contacts">
							 	<input type="hidden" id="txt_contact"/>
				                <ul class="contacts-list" id="contact_list">
	              					<!-- Contact List goes here -->
				                </ul>
							</div>
							
			            </div>
			            
						<div class="box-footer">
							<div class="input-group">
								<textarea class="form-control" rows="3" id="txt_msg"
								placeholder="${enter_placeholder}" style="resize:none"></textarea>
								<span class="input-group-addon btn btn btn-primary btn-flaty"
								id="btn_send"><spring:message code="view.button.send"/></span>
							</div>
						</div>
					</div>
		
		        </section>
	        
				<section class="col-lg-4">
					<div class="box box-primary">
						<div class="box-header">
							<i class="fa fa-calendar"></i>
							<h3 class="box-title">Calendar</h3>
							<div class="pull-right box-tools">
								<div class="btn-group">
									<a href="#" type="button" class="btn btn-success btn-sm dropdown-toggle" 
									data-toggle="dropdown">View Calendar</a>
				                </div>
							</div>
						</div>
            			<div class="box-body no-padding">
							<div id="calendar" style="width: 100%"></div>
						</div>
					</div>
				</section>
				
				<section class="col-md-4">
					<div class="box box-primary">
            			<div class="box-header">
              				<i class="ion ion-clipboard"></i>
							<h3 class="box-title">To Do List</h3>
							<div class="box-tools pull-right">
								<span class="label label-danger" id="todo-list-count"><!-- Todo List Count --></span>
								<div class="btn-group">
                  					<button type="button" class="btn btn-info btn-sm dropdown-toggle" 
                  					data-toggle="dropdown">
                    				<i class="fa fa-bars"></i></button>
                 					<ul class="dropdown-menu pull-right" role="menu" style="min-width:225px;">
                 						<li><a><input type="checkbox" class="flat-red">  
                 							<spring:message code="view.label.todo"/>
                 						</a></li>
                   						<li><a><input type="checkbox" class="flat-red">  
                   							<spring:message code="view.label.completed"/>
                   						</a></li>
                 						<li class="divider"></li>
                   						<li><a><input type="checkbox" class="flat-red">  
											<spring:message code="view.label.high_priority"/>
										</a></li>
                   						<li><a><input type="checkbox" class="flat-red">  
											<spring:message code="view.label.med_priority"/>
										</a></li>
                   						<li><a><input type="checkbox" class="flat-red">  
                   							<spring:message code="view.label.low_priority"/>
                   						</a></li>
                  					</ul>
                				</div>
<!-- 								<ul class="pagination pagination-sm inline"> -->
<!-- 				                  <li><a href="#">&laquo;</a></li> -->
<!-- 				                  <li><a href="#">1</a></li> -->
<!-- 				                  <li><a href="#">2</a></li> -->
<!-- 				                  <li><a href="#">3</a></li> -->
<!-- 				                  <li><a href="#">&raquo;</a></li> -->
<!--                 				</ul> -->
              				</div>
            			</div>

						<div class="box-body">
              				<ul class="todo-list" id="todo-list">
               					<!-- To-do List goes here -->
              				</ul>
            			</div>

            			<div class="box-footer clearfix no-border">
              				<button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
            			</div>
          			</div>
				</section>
				
			</div>
	    </section>
	</div>
<%@ include file="fragments/copyright.jspf" %>
</div>

<script type="text/javascript">

	$(document).ready(function() {
    	var intervalId = 0;
    	intervalId = setInterval(reload_ajax, 3000);
	});

	$('#txt_msg').keypress(function(e){
		txt_msg = $('#txt_msg').val();
		
		if (e.which == 13 && e.shiftKey) {
			e.preventDefault();
			$('#txt_msg').val($('#txt_msg').val() + '\n');
		}
		
		if (e.which == 13 && !e.shiftKey) {
			txt_msg_noline = txt_msg.replace(/\n/g, "");
			if (txt_msg_noline!=""){
				e.preventDefault();
				$('#txt_msg').val(txt_msg.replace(/\n/g, "<br>"));
				$('#btn_send').click();
				$('#txt_msg').val('');
			}
		}
	});
	
	$('#btn_send').on('click', function(){ submitMessage(); });
	$('#btn_online').on('click', function(){ updateOnlineStatus(1); })
	$('#btn_offline').on('click', function(){ updateOnlineStatus(0); })
	$('#btn_delete').on('click', function(){ deleteMessage(); });
	
	function submitMessage() {
		var param = "message=" + $('#txt_msg').val() 
					 + "&recepient=" + $('#txt_contact').val();
		$.ajax({
			type: "POST",
            url : "sendMessage?" + param,
            success : function(data) {}
   		});
	}

	function reload_ajax(){
		
		getOnlineStatus();
    	getContacts();
    	reloadChat();
    	reloadTodoList();
    	reloadTodoListCounts();
	}
	
    function reloadChat() {
    	
    	var chat_box = $('#chat-box');
    	var txt_contact = $('#txt_contact');
    	var oldscrollHeight = chat_box[0].scrollHeight;
    	var oldchatData = chat_box.html();
    	
    	var param = ( txt_contact.val()!=null || txt_contact.val().length>0 ) ?
    			param="contact=" + txt_contact.val() : param="";
    			
        $.ajax({
        	type: "GET",
            url : 'chatMessage?' + param,
            success : function(data) {
            	
            	// replace not yet working
            	oldchatData = oldchatData.replace('class=\"collapsed\" aria-expanded=\"false\"',""); 
            	var shouldScroll = chat_box[0].clientHeight + chat_box[0].scrollTop === 
                	chat_box[0].scrollHeight;
            	if (oldchatData!=data) chat_box.html(data);
            	if (shouldScroll) {
            		chat_box.slimscroll({ scrollTo : $("#chat-box")[0].scrollHeight });
            	}
				
            }
		});
    }

    function getOnlineStatus() {
    	$.ajax({
        	type: "GET",
            url : 'getOnlineStatus',
            success : function(data) {
            	if (data=="0") {
            		$('#btn_offline').addClass("active");
            		$('#btn_online').removeClass("active");
            	} else {
            		$('#btn_online').addClass("active");
            		$('#btn_offline').removeClass("active");
            	}
            }
		});
    }
    
    function updateOnlineStatus(status) {
		var param = "status=" + status;
		$.ajax({
			type: "POST",
            url : "updateOnlineStatus?" + param,
            success : function(data) {}
   		});
	}
    
    function deleteMessage() {
    	$.ajax({
        	type: "GET",
            url : 'deleteMessage',
            success : function(data) {}
		});
    }
    
    function getContacts() {
    	var contact_list = $('#contact_list');
        $.ajax({
        	type: "GET",
            url : 'getContacts',
            success : function(data) {
            	contact_list.html(data);
            }
		});
    }
    
    function passRecepient(recepient) {
    	$('#chat').removeClass('direct-chat-contacts-open');
    	$('#box_title').html('Chat: ' + recepient);
    	if (recepient=='All') {
    		$('#txt_contact').val(''); 
    	} else {
    		$('#txt_contact').val(recepient);
    	}
    }
    
	function reloadTodoList() {
    	var todo_list = $('#todo-list');
        $.ajax({
        	type: "GET",
            url : 'todoList',
            success : function(data) {
            	todo_list.html(data);
            }
		});
    }
	
	function reloadTodoListCounts() {
    	
    	var todo_list_count = $('#todo-list-count');
        $.ajax({
        	type: "GET",
            url : 'todoList_count',
            success : function(data) {
            	todo_list_count.html(data + ' active record(s)');
            }
		});
        
    }
	
	function status_update(id) {
		
		var status = "todo";
		var param = "orderid=" + id.replace('chk',"") + "&&" + 
					"todo_status=" + status;
		alert(id);
		if ($('#'+id).is("checked")) status = "completed";
		alert(status);
		$.ajax({
			type: "POST",
            url : "updateTodoStatus?" + param,
            success : function(data) {}
   		});
	}
	

</script>

<%@ include file="fragments/footer.jspf" %>