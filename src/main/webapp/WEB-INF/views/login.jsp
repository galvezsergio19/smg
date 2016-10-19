<%@ include file="fragments/header.jspf" %>
<body class="hold-transition login-page">
<div class="se-pre-con"></div>
	<div class="login-box">
	
		<div class="login-logo">
			<a href="#"><b>Login</b> Now</a>
		</div>
		
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
		
			<!-- Place Holders -->
			<spring:message code="view.label.username" var="username"/>
			<spring:message code="view.label.password" var="password"/>

			<div class="row-fluid">
				<form:form method="POST" modelAttribute="employee" id="loginForm">
				
					<c:if test="${message ne null}">
						<div class="alert alert-${alert}" role="alert">${message}</div>
					</c:if>
				
					<div class="form-group has-feedback">
						<form:input type="text" class="form-control" 
									path="username" id="username" 
									placeholder="${username}" value="${winUserName}"/>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					
					<div class="form-group has-feedback">
						<form:input type="password" class="form-control" 
									path="password" id="password" 
									placeholder="${password}"/>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					
					<div class="form-group has-feedback" align="right">
						<button type="button" id="btn_login" class="btn btn-primary btn-flat"
						data-loading-text="Loading...">
							<spring:message code="view.button.login"/>
						</button>
						<button type="button" id="btn_reset" class="btn btn-default btn-flat">
							<spring:message code="view.button.reset"/>
						</button>
					</div>
				</form:form>
			</div>
			
			<div class="row-fluid panel-footer">
				<a href="register" class="text-center">Register a new Account</a>
				<span><i class="fa fa-arrow-circle-right text-primary"></i></span>
				<div class="clearfix"></div>
			</div>
	
		</div>
	</div>


<script type="text/javascript">  
/*<![CDATA[*/
           
	$(document).ready(function(){
		//On-load script
	});
	
	function submitLogin() {
		var form = $("#loginForm");
		var $btn = $('#btn_login');
		$btn.html('Loading');

		setTimeout(function(){
			$(".se-pre-con").show();
			form.submit();
			$btn.button('reset');
		},1000)
	}
	
	$('#loginForm').find('input').keypress(function(e){
		  if (e.which == 13) { submitLogin(); }
	});
	
	$('#btn_login').on('click', function(){
		submitLogin();
	});
	
	$('#btn_reset').click(function(){	
		location.reload();
	});
	
/*]]>*/
</script>

<%@ include file="fragments/footer.jspf" %>
