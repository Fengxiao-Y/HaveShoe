<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>登入页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <meta name="keywords" content="blog, business, clean, clear, cooporate, creative, design web, flat, marketing, minimal, portfolio, shop, shopping, unique">
    <meta name="author" content="MARTECH | Deer Creative Theme">
    <link rel="stylesheet"  href="../backAssets/css/add.css">
    <link rel="stylesheet" href="../backAssets/css/style.css">
    <link rel="stylesheet" href="../backAssets/css/custom_bootstrap.css">
    <link rel="stylesheet" href="../backAssets/css/bootstrap.css">
    <link rel="stylesheet" href="../backAssets/css/fontawesome.css">
	<style type="text/css">
	.account{
			background-image: url(../images/25.png) ;
			
			background-size: 100% 100%;
			/* background-repeat: no-repeat; */
			background-color: #D1EEEE;
			
		}
		.linsty{
			width:800px;
			border:1px solid white;
			margin:auto;
			background-repeat:no-repeat;
			background:#FAFAFA	;
		}
	</style>
	</head>
	<body>
	<%@ include file="header.jsp" %>
	<div class="account">
        <div class="container" >
         <div class="linsty" style="filter:alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;">
          <div class="row" >
            <div class="col-12 col-md-6 mx-auto" >
              <h1 class="title ">登录</h1>
      			<form  method="post" id="myform" onsubmit="return uSubmit()" class="form-horizontal" >
				<div class="form-group">
					<label for="empName" class="control-label col-sm-3 size18 " >用户名：</label>
					<div class="col-sm-9">	
						<input id="empName"  class="form-control" name="empName" required="required" placeholder="请输入用户名"/>
						<span class="help-block">&nbsp;</span> 
					</div>
				</div> 
				<div class="form-group">	
					<label for="empPwd" class="control-label col-sm-3 size18 ">密&nbsp;码：</label>
					<div class="col-sm-9">	
						<input id="empPwd" class="form-control" type="password" name="empPwd" required="required" placeholder="请输入密码"/>				
						<span id="ti" >&nbsp;</span>
					</div>
				</div>
				
				<div class=" text-center">
					 <input id="mybutton" class="btn btn-success col-sm-3 center-block" style="float: none;display: block;margin: 0 auto;" type="button" value="登录"/>
				</div>	
			</form>
            </div>
          </div>
          </div>
        </div>
        有<br>家<br>非<br>常<br>感<br>谢<br>你<br>们<br>的<br>努<br>力<br>和<br>奋<br>斗
      </div>
		
	</body>
	<script src="../backAssets/js/jquery.min.js"></script>
    <script src="../backAssets/js/jquery-ui.min.js"></script>
    <script src="../backAssets/js/jquery.countdown.min.js"></script>
    <script src="../backAssets/js/slick.min.js"></script>
    <script src="../backAssets/js/jquery.easing.js"></script>
    <script src="../backAssets/js/jquery.scrollUp.min.js"></script>
    <script src="../backAssets/js/jquery.zoom.min.js"></script>
    <script src="../backAssets/js/parallax.js"></script>
    <script src="../backAssets/js/jquery.fancybox.js"></script>
    <script src="../backAssets/js/numscroller-1.0.js"></script>
    <script src="../backAssets/js/vanilla-tilt.min.js"></script>
    <script src="../backAssets/js/main.js"></script>
    <script type="text/javascript">
    	
    	$(function(){	
    		$("#mybutton").click(function(){
    			login = false;
    			var empName = $("#empName").val();
    			var empPwd  = $("#empPwd").val();
    			$.ajax({
    				type:"post",                            
					url:"../LoginServlet?methoh=login",   
					async:true,                            
					data:{                                 
						'empName':empName,
						'empPwd':empPwd
					},
					success:function(data){
						var msg = JSON.parse(data);
						if(msg.state==0){
							$("#ti").text("用户名不存在");
						}else if(msg.state==1){
							$("#ti").text("账号密码错误");
						}else if(msg.state==2){
							
							window.location.href="http://localhost:8080/Youjia/back/youjiaShow.jsp";
						}
					}					
    			})
    		});
    	});
    </script>
    
</html>