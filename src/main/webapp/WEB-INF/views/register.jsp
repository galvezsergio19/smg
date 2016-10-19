<%@ include file="fragments/header.jspf" %>
<body class="hold-transition login-page">
<div class="se-pre-con"></div>
	<div class="register-box">
	
		<div class="register-logo">
			<a href="#"><b>Register</b> Now</a>
		</div>
	
		<div class="register-box-body">
			<p class="login-box-msg">Register a new Account</p>
			
			<!-- Place Holders -->
			<spring:message code="view.label.full_name" var="full_name"/>
			<spring:message code="view.label.username" var="username"/>
			<spring:message code="view.label.password" var="password"/>
			<spring:message code="view.label.retype_password" var="retype_password"/>
			
			<div class="row-fluid">
				<form:form method="POST" modelAttribute="employee" id="registrationForm">
					<form:input type="hidden" path="id" id="id"/>
					
					<c:if test="${message ne null}">
						<div class="alert alert-${alert}" role="alert">${message}</div>
					</c:if>
					
					<div class="form-group has-feedback">
						<form:input type="text" path="full_name" id="full_name" 
									class="form-control" placeholder="${full_name}"
									data-toggle="tooltip" data-placement="right" 
									title="${full_name_error}"/>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="full_name" cssClass="well well-sm error"/>
					</div>
					<div class="form-group has-feedback">
						<form:input type="text" path="username" id="username" 
									class="form-control" placeholder="${username}"
									value="${winUserName}" readonly="true"/>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="username" cssClass="well well-sm error"/>
					</div>
					<div class="form-group has-feedback">
						<form:input type="password" path="password" id="password" 
									class="form-control" placeholder="${password}"/>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<form:errors path="password" cssClass="well well-sm error"/>
					</div>
					<div class="form-group has-feedback">
						<form:input type="password" path="retype_password" id="retype_password" 
									class="form-control" placeholder="${retype_password}"/>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<form:errors path="retype_password" cssClass="well well-sm error"/>
					</div>
					<div class="form-group has-feedback" align="right">
						<button type="button" id="btn_register" data-loading-text="Loading..."
						class="btn btn-primary btn-flat">
							<spring:message code="view.button.register"/>
						</button>
						<button type="reset" id="btn_reset" class="btn btn-default btn-flat">
							<spring:message code="view.button.reset"/>
						</button>
					</div>
				</form:form>
			</div>
			
			<div class="row-fluid panel-footer">
				<span><i class="fa fa-arrow-circle-left text-primary"></i></span>
				<a href="login" class="text-center">I am already a member</a>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

<script type="text/javascript">  
/*<![CDATA[*/
           
	$(document).ready(function(){
		//On-load script
		var alertType = "${alert}";
		if (alertType!="") {
			$('#registrationForm').find('input, textarea, button, select')
			.attr('disabled','disabled');
		}
		
	});
	
	$('#btn_register').on('click', function(){
		
		var form = $("#registrationForm");
		var $btn = $(this);
		$btn.button('loading...');
		
		setTimeout(function(){
			$(".se-pre-con").show();
			form.submit();
			$btn.button('reset');
		},1000)
	});
	
	$('#btn_reset').click(function(){	
		location.reload();
	});
	
/*]]>*/
</script>

<%@ include file="fragments/footer.jspf" %>