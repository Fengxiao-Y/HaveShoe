<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>注册页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <meta name="keywords" content="blog, business, clean, clear, cooporate, creative, design web, flat, marketing, minimal, portfolio, shop, shopping, unique">
    <meta name="author" content="MARTECH | Deer Creative Theme">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/custom_bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/elegant.css">
    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/scroll.css">
    <link rel="stylesheet" href="assets/css/icomoon.css">
    <link rel="stylesheet" href="assets/css/jquery.fancybox.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/register.css"/>
	<link href="../WEB-INF/login.css" />
	<script src="../jQuery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="assets/js/jquery-ui.min.js"></script>
    <script src="assets/js/jquery.countdown.min.js"></script>
    <script src="assets/js/slick.min.js"></script>
    <script src="assets/js/jquery.easing.js"></script>
    <script src="assets/js/jquery.scrollUp.min.js"></script>
    <script src="assets/js/jquery.zoom.min.js"></script>
    <script src="assets/js/parallax.js"></script>
    <script src="assets/js/jquery.fancybox.js"></script>
    <script src="assets/js/numscroller-1.0.js"></script>
    <script src="assets/js/vanilla-tilt.min.js"></script>
    <script src="assets/js/main.js"></script>
	<link href="../WEB-INF/login.css" />
	<script type="text/javascript">
	//验证用户名
		$(function(){
			var uSersbool=false;
			var uPwdbool=false;
			var repswbool=false;
			var uTelbool=false;
			var uEmailbool=false;
			var uNamebool=false;
			var xingm=false;
			
			$("#uSers").blur(function(){
				uSersbool=false;
				var name=$(this).val().trim();
				if(name==""){
					$(this).next().html("<font color='red'>用户输入不能为空</font>");
				}else{
					var names=$(this).val();
					$.ajax({
						type:"get",
						url:"../UsersServlet?methoh=ofSers",
						async:true,
						data:{
							'uSers':names							
						},
						success:function(data){
							var msg = JSON.parse(data)
							if (msg.state==1) {
								uSersbool=true;
								$("#uSerssp").html("<font color='green'>用户名可用</font>");
							} else{
								$("#uSerssp").html("<font color='red'>用户名已存在</font>");
							}
						}
					});
				}
			})
			//密码
			$("#uPwd").blur(function(){
				uPwdbool=false;
				var pwd=$(this).val().trim();
				if(pwd==""){
					$(this).next().html("<font color='red'>密码不能为空</font>");
				}else if(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,15}$/.test(pwd)){
					uPwdbool=true;
					$("#uPwd").next().html("<font color='green'>输入正确</font>");
				}else{
					$('#uPwd').next().html("<font color='red'>密码错误,必须为：英文＋数字 8至15位</font>");
				}
				});
				//确认密码
				$("#repsw").blur(function(){
					repswbool=false;
					var psws=$("#repsw").val().trim();
					var pwds=$("#uPwd").val();
					if(psws==pwds&&pwds.length!=0){
						repswbool=true;
					$("#repsw").next().html("<font color='green'>输入正确</font>");	
					}else{
						$("#repsw").next().html("<font color='red'>密码输入错误与上面不一致</font>");
					}
				});
				//验证电话号码
				$("#uTel").blur(function(){
					uTelbool=false;
					var phone=$("#uTel").val().trim();
					if (phone=="") {
						uTelbool=false;
					}else if(/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(phone)){
						uTelbool=true;
						$("#uTel").next().html("<font color='green'>输入正确</font>");	
					} else{
						$("#uTel").next().html("<font color='red'>电话输入格式输入不正确</font>");
					}
				});
				//邮箱
				$("#uEmail").blur(function(){
					uEmailbool=false;
					var email=$("#uEmail").val();
					if(email==""){	
						uEmailbool=true;
						$('#uEmailS').next().html("选填项");
					}else if(/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/.test(email)){
						uEmailbool=true;
						$("#uEmailS").html("<font color='green'>输入正确</font>")
					}else{
						$("#uEmailS").html("<font color='red'>邮箱输入格式输入不正确</font>")
					}
				});
				//姓名
				$("#uName").blur(function(){
					xingm=false;
					var sname=$('#uName').val();
					var xmx=/^[\u4e00-\u9fa5]{2,4}$/;
					$('#uName').next().html("必填项");
					if(xmx.test(sname)){
						$('#uName').next().html("<font color='green' >输入正确</font>");
						xingm=true;
					}else{
						$('#uName').next().html("<font color='red' >只支持2~4位数的中文</font>");
						xingm=false;
					}
				});
			function uSubmit(){
				if(uSersbool&&uPwdbool&&repswbool&&uTelbool&&uEmailbool&&uNamebool&&xingm){
					return true;
				}else{
					return false;
				}
			}
		});
	</script>
	
	</head>
	<body>
		<%-- <%@ include file="youjiaShow.jsp"%> --%>
	<div class="ogami-breadcrumb">
        <div class="container">
          <ul>
            <li> <a class="breadcrumb-link" href="../IndexServlet?methoh=index"> <i class="fas fa-home"></i>首页</a></li>
            <li> <a class="breadcrumb-link active" href="#">注册</a></li>
          </ul>
        </div>
    </div>
		
		
		<div class="account">
        <div class="container" >
          <div class="row">
            <div class="col-12 col-md-6 mx-auto">
		<form action="../UsersServlet?methoh=add" method="post" id="myform" onsubmit="return uSubmit()" class="form-horizontal"> 
				<div class="form-group">
					<label for="uSers" class="control-label col-sm-3 size18" >用户名:</label>
					<div class="col-sm-9">	
						<input id="uSers"  class="form-control" name="uSers" required="required" placeholder="请输入用户名"/>
						<span id="uSerssp" class="help-block">字母下划线3-8位</span>
					</div>
				</div>
				<div class="form-group">	
					<label for="uPwd" class="control-label col-sm-3 size18">密码：</label>
					<div class="col-sm-9">	
						<input id="uPwd" class="form-control" type="password" name="uPwd" required="required" placeholder="请输入密码"/>				
						<span class="help-block">字母下划线3-8位</span>
					</div>
				</div>
				<div class="form-group">
					<label for="repsw" class="control-label col-sm-3 size18">确认密码：</label>
					<div class="col-sm-9">	
						<input id="repsw" class="form-control" type="password" name="repsw" required="required" placeholder="请再次输入密码"/>
						<span class="help-block">两次密码必须一致</span>
					</div>
				</div>
				<div class="form-group">
					<label for="uTel" class="control-label col-sm-3 size18">手机号：</label>
					<div class="col-sm-9">	
						<input id="uTel" class="form-control" type="text" name="uTel" required="required" placeholder="请输入手机号"/>
						<span class="help-block">必须输入您的手机号</span>
					</div>
				</div>
				<div class="form-group">					
					<label for="uEmail" class="control-label col-sm-3 size18">邮箱：</label>
					<div class="col-sm-9">	
						<input id="uEmail" class="form-control" type="text" name="uEmail"  placeholder="请输入您的邮箱"/>
						<span id="uEmailS" class="help-block">选填项</span>
					</div>
				</div>
				<div class="form-group">
					<label for="uName" class="control-label col-sm-3 size18">姓名：</label>
					<div class="col-sm-9">
						<input id="uName" class="form-control" type="text" name="uName"  placeholder="请输入您的姓名"/>
						<span class="help-block">必选项</span>
					</div>
				</div>
				<div class="form-group">					
					<label for="uName" class="control-label col-sm-3 size18">性别：</label>
					<div class="col-sm-9">
					<select class="form-control" style="width:100px">
					  <option value="">请选择</option>
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
					<span class="help-block">选填项</span>
					</div>
				</div>
				<div class=" text-center">
					 <input id="mybutton" class="btn btn-success col-sm-3 center-block" style="float: none;display: block;margin: 0 auto;" type="submit" value="注册"/>
				</div>	
				<div class="account-function margin10">
	                   		<a class="create-account" href="login.jsp">返回登录</a>
	            </div>		
		</form>
		 </div>
          </div>
        </div>
      </div>
	<%-- <%@ include file="youjiaShow.jsp" %> --%>
	</body>
	
</html>
