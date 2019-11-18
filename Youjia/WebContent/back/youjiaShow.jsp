<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>有家商城后台管理页面</title>
		<!-- 导入easyui样式 -->
		<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" /> 
		<!--字体图标库-->
		<link rel="stylesheet" href="../font-awesome/css/font-awesome.min.css">
		<!-- 导入easyui相关的js库文件(函数) -->
		<script type="text/javascript" src="../easyui/jquery.min.js"></script>
		<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script> 
			<style type="text/css">
			/*清除元素默认的内边距和外边距*/
			*{                                
			  margin:0px;
			  padding:0px;
			}
			/*清除所有a标签的格式*/
			a{                                
			  text-decoration:none;
			  color:rgb(0,0,0);
			}
			/*清除无序列表的格式*/
			ul{                               
			  list-style:none; 
			}
			ul li{
				padding: 10px 30px; 
				font-size: 14px;
			}
			ul li:hover{
				background-color: #CCCCCC;
				cursor: pointer;
			}
			/*表格区域显示颜色*/
			#tt{
				background-color:#EBEBEB;
			}
			/*系统设置等界面颜色*/
			.accordion .accordion-header{
				background:	#737373;
			}
			/*选中项颜色*/
			.accordion .accordion-header-selected {
    			background: #D1EEEE;
			}
			/*选中字体颜色*/
			.accordion .accordion-header-selected .panel-title {
    			color: #EE7600;
			}
			/*后端字体颜色*/
			.panel-title{
				color: #FFFFFF;
			}
			/*div2上部底色*/
			.panel-header{
				background:linear-gradient(to bottom,#737373 0,#737373 100%);
				height: 20px;
			}
			/*div3上部底色*/
			.tabs-header,
			.tabs-tool {
			  background-color: 	#737373;
			}
			/*未选中的颜色*/
			.layout-expand {
			    background-color: #A52A2A;
			}
			.tabs-panels{
				background-image: url(../images/111.jpg);
				background-size: 100% 100%;
				background-repeat: no-repeat;
  				background-color: #D1EEEE;
			}
		</style>
		
		<script type="text/javascript">
		/*选项卡*/
		$(function() {
			bindEvent();
			});
			//绑定事件
			function bindEvent() {
			$(".opt").click(function() {
			var title = $(this).text();
			var url = $(this).attr("url");
			var isExt = $('#tt').tabs('exists', title);
			//判断页签是否已经存在 选项卡,如果不存在则新建选选项卡；存在则显示该选项卡
			if (!isExt) {
			$('#tt').tabs('add', {
			title : title,
			width : $("#tt").parent().width(),//起源 父亲
			height : "auto",
			content : createContent(url),//内容
			closable : true
			});
			}else{
			$('#tt').tabs('select', title);
			return;
			}	
			});
			}
			function createContent(url) {
			var strPath = '<iframe src="' + url + '" scrolling="no" frameborder="0" width="100%" height="100%"></iframe>';
			return strPath;
			}	
		</script>
	</head>
	<body style="width: 100%; height: 100%;" class="easyui-layout" >  
	    <div data-options="region:'north'" style="height:80px;background-color:#f5f5f5">
	    	<div style="width:auto;height:80px;float: left; padding-left: 20px;">
	    		<img  src="../images/LOGO3.png" alt="logo"  title="logo" style="margin-top: 20px;"/>
	    	</div>
	    	<div style="width:auto;height:80px;float: left;font-size: 20px;font-weight:bold ; line-height:80px ;">
	    		<span >后台管理系统</span>
	    	</div>
	    	<div style="width:200px;height:70px;float: right;line-height:60px ;">管理员： <% if(session.getAttribute("empName")!=null){
                	  out.print("<a href='../LoginServlet?methoh=myPIM'>"+session.getAttribute("empName")+"</a>");
                  }else{ out.print("登录"); } %>&nbsp;登录系统！</div>
	    </div>
	    <div data-options="region:'west',title:'后台管理主菜单'" style="width:185px;">
	    	<!--下拉菜单-->
	    	<div id="menu" class="easyui-accordion" fit="true" border="false" style="background-color:#f5f5f5">   
				<div title="商品详情" style="overflow: auto;" data-options="iconCls:'icon-shezhi'">
					<ul>
						<li class="opt" url="aboutPage/Marque.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;商品类型</li>
						<li class="opt" url="aboutPage/CommodityType.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;商品种类</li>
					</ul>
				</div>
				<div title="库存情况" style="overflow: auto;" data-options="iconCls:'icon-shezhi'">
					<ul>
						<li class="opt" url="aboutPage/Inventory.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;库存情况</li>
						<li class="opt" url="aboutPage/Outbound.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;出库情况</li>
						<li class="opt" url="aboutPage/Proin.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;入库情况</li>
					</ul>
				</div>
				<div title="销售采购" style="overflow: auto;" data-options="iconCls:'icon-shezhi'">
					<ul>
						<li class="opt" url="aboutPage/SalesOrder.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;销售订单</li>
						<li class="opt" url="aboutPage/Supplier.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;供应商表</li>
						<li class="opt" url="aboutPage/PurchaseOrder.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;采购订单</li>
					</ul>
				</div>
				<div title="财务系统" style="overflow: auto;" data-options="iconCls:'icon-shezhi'">
					<ul>
						<li class="opt" url="aboutPage/SalesOrder.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;财政收入</li>
						<!-- <li class="opt" url="aboutPage/FiscalRevenueCrud.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;财政收入</li> -->
						<li class="opt" url="aboutPage/FiscalExpendCrud.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;财政支出</li>
						<!-- <li class="opt" url=""><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;财政总表</li> -->
					</ul>
				</div>
				<div title="员工管理" style="overflow: auto;" data-options="iconCls:'icon-shezhi'">
					<ul>
						<li class="opt" url="aboutPage/Employee.html"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;员工管理</li>
					</ul>
				</div>
			</div> 
	    </div>   
	    <div data-options="region:'center'" style="background-image: url('../images/tabsbg.jpg'); background-size: 100% 100%">
	    	<!--选项卡 -->
	    	<div class="easyui-tabs" id="tt" data-options="fit:true,border:false" >
	    		
	    	</div>
	    </div>
	    <div data-options="region:'south'" style="height:50px;text-align: center;line-height: 40px;background-color:#f5f5f5">COPYRIGHT&copy;2019-2026 版权所有<b>@</b></div>
	</body>
</html>