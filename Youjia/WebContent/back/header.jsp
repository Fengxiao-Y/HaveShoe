<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script src="assets/js/jquery.min.js"></script>
	<!-- <script type="text/javascript">
	/* 	/*$(function()
		{
			/* 执行ajax代码 */
			var url="../HeadServlet";
			var params="method=findAdd";
			/* 
				$.get
				$.post
					url: servlet的访问路径
					params: 要带给servlet的参数
					function(d):响应成功要执行的函数  d:服务器返回的值   ===response.getWriter().print(json);
					type: 要把返回的数据结果转换的类型  默认是字符串   "json":把数据转换成json
			
			*/
			$.post(url,params,function(data)
			{
				// a: 是索引   b:是当前索引的内容
				var j = 1;
				for(i in data){
					$("#oneType").append("<li><a href='../GoodsShowServlet?mothoh=ontType&otid="+data[i].otid+"&rows=9&page=1'> <i class='icon-"+j+"'></i>"+data[i].otName+"</a></li>");
					j++;
				}
			},"json")	
			
		}) */
	
	</script> -->

   
		<header> 
        <div class="header-block d-flex align-items-center">
          <div class="container">
            <div class="row">
              <div class="col-12 col-md-6">
               
              </div>
              <div class="col-12 col-md-6">
                <div class="header-right d-flex flex-column flex-md-row justify-content-md-end justify-content-center align-items-center">
                
                  <div class="login d-flex"><i class="fas fa-user"></i><a href="<% if(session.getAttribute("empName")!=null){
                	  out.print("1");
                 	}else{ out.print("login.jsp"); } %>">
                  <% if(session.getAttribute("empName")!=null){
                	  out.print("<a href='../LoginServlet?methoh=myPIM'>"+session.getAttribute("empName")+"</a>");
                  }else{ out.print("登录"); } %>
                  </a></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        </header>
      