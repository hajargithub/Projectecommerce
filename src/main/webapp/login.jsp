<!DOCTYPE html>
<html lang="en"> 
<head>
    <title>Login</title>
    
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" content="Login">
    <meta name="author" content="Group1">    
    <link rel="shortcut icon" href="favicon.ico"> 
    
    <!-- FontAwesome JS-->
    <script defer src="assets/plugins/fontawesome/js/all.min.js"></script>
    
    <!-- App CSS -->  
    <link id="theme-style" rel="stylesheet" href="assets/css/portal.css">

</head> 

<body class="app app-login p-0">    	
    <div class="row g-0 app-auth-wrapper">
	    <div class="col-12 col-md-7 col-lg-6 auth-main-col text-center p-5">
		    <div class="d-flex flex-column align-content-end">
			    <div class="app-auth-body mx-auto">	
				    <div class="app-branding"><img class="logo-icon me-2" src="assets/images/l1.png" alt="logo"></div>
					<h2 class="auth-heading text-center mb-5"></h2>
			        <div class="auth-form-container text-start">
						<form action="loginServlet" method="post" class="auth-form login-form">         
							<div class="email mb-3">
								<label class="sr-only" for="email">Email</label>
								<input id="email" name="email" type="email" class="form-control signin-email" placeholder="Email address" required="required">
							</div><!--//form-group-->
							<div class="password mb-3">
								<label class="sr-only" for="password">Password</label>
								<input id="password" name="password" type="password" class="form-control signin-password" placeholder="Password" required="required">
								<div class="extra mt-3 row justify-content-between">
									<div class="col-6">
									</div><!--//col-6-->
									<div class="col-6">
									</div><!--//col-6-->
								</div><!--//extra-->
							</div><!--//form-group-->
							<div class="text-center">
								<button type="submit" class="btn app-btn-primary w-100 theme-btn mx-auto">Log In</button>
							</div>
						</form>
												<div class="auth-option text-center pt-5">Créer un compte? <a class="text-link" href="signup.jsp" >Sign up</a></div>
						
						
					</div><!--//auth-form-container-->	

			    </div><!--//auth-body-->
		    
		    </div><!--//flex-column-->   
	    </div><!--//auth-main-col-->
	    <div class="col-12 col-md-5 col-lg-6 h-100 auth-background-col">
		    <div class="auth-background-holder">
		    </div>
		    <div class="auth-background-mask"></div>
	    </div><!--//auth-background-col-->
    
    </div><!--//row-->


</body>
</html> 

