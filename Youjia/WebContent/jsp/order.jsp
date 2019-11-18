<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>【有家鞋店】订单</title>
		<script type="text/javascript" src="../js/jquery.js" ></script>
		<link rel="stylesheet" href="../css/base.css" />
		<link rel="stylesheet" href="../commonCss/footer.css" />
		<link rel="stylesheet" href="../commonCss/header.css" />
		<link rel="stylesheet" href="../css/shoppingCar.css" />
		<script type="text/javascript" src="../js/shoppingCar.js" ></script>
		<script type="text/javascript" src="../js/brand.js" ></script>
	</head>
	<body>
		<div id="headTop" class="t">
			<div id="topContent" class="c">
				<span class="topContentLeft l">
					<span class="a1">欢迎来到有家鞋店</span>
					<a class="pleaseLogin" href="#">184****2829</a>
					<em></em>
					<li></li>
					<a class="pleaseregister" href="index.html">退出</a>
				</span>
				<span class="topContentRight r">
					<span>
						<span class="icon1"></span>
						<a href="#" class="a1">我的YJ</a>
						<span class="icon2"></span>
						<ul class="icon2Hover">
							<li>
								<a href="#">我的订单</a>
							</li>
						</ul>
					</span>
					<span>
						<span class="icon3"></span>
						<a href="#" class="a1">会员俱乐部</a>
					</span>
					<span>
						<span class="icon4"></span>
						<a href="#" class="a1">手机YJ</a>
					</span>
					<span>
						<a href="#">帮助中心</a>
					</span>
				</span>
			</div>
		</div>
		<div id="carHeader">
			<div class="carHeaderInfo t">
				<div class="carHeaderInfoContent c">
					<div class="carHeaderContentLeft l">
						<a href="首页.html"><img src="../images/LOGO3.png"/></a>
					</div>
					<div class="carHeaderContentRight r">
						<div class="carHeaderContentRightBorder"></div>
						<div class="carHeaderRightStep l carHeaderRightStep4">
							<em class="checkoutStep"></em>
						</div>
						<div class="carHeaderRightStep l carHeaderRightStep5">
							<em class="checkoutStep"></em>
						</div>
						<div class="carHeaderRightStep l carHeaderRightStep3">
							<em class="checkoutStep"></em>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="checkoutPosition">
			<div class="checkoutPositionInfo t">
				<div class="checkoutPositionContent c">
					<div class="checkoutPositionContentP">您的购物车清单如含近效期产品，该近效期产品不支持7天无理由退货，近效期产品为页面有特别标示有效期信息的产品。</div>
				</div>
			</div>
		</div>
		
		
		<div id="chekoutBody">
			<div class="checkoutProduct t">
				<div class="checkoutProductInfo c">
					<h3 style="">确认订单地址</h3>
					<div class="checkoutTable">
						
			
						
						
			<div class="productBodyItem">
						<ul>
							<label><li style="padding-top: 15px;"><input type="radio" id="addredd" name="usAddress" checked="checked">${usAddress}</li></label>
						</ul>		
			</div>
			
		</div>
		<div id="chekoutBody">
			<div class="checkoutProduct t">
				<div class="checkoutProductInfo c">
					<h3 style="">确认订单信息</h3>
					<div class="checkoutTable">
						
			
						
						
			<div class="productBodyItem">
					<c:forEach items="${orderList}" var="mar">
									<div class="productBodyItemContent">
										<a class="itemImg" href=""><img src="${mar.marUrl}"/></a>
										<div class="itemInfo">
											<h5>ADIDAS</h5>
											<a href="">STAN SMITH ${mar.shoeName}</a>
											<div><span>${mar.shoeSize}码<i></i></span></div>
											<input type="hidden" value="${mar.id}" name="id" id="id"/>
											<input type="hidden" value="${mar.username}" name="username" id="username"/>
											<input type="hidden" value="${mar.price}" name=price id="price"/>
											<input type="hidden" value="${mar.store}" name=store id="store"/>
										</div>
										<div class="itemInfoUnion1">
											<span class="itemInfoUnionPice">${mar.price}</span>
										</div>
										<div class="itemInfoUnion2">
											<div class="itemInfoUnion2Module l">
												<i>x${mar.store}</i>
											</div>
										</div>
										<div class="itemInfoUnion3">
											<span class="sumNum">${mar.store*mar.price}</span>
											<input type="hidden" value="${mar.store*mar.price}" id="allPrice"/>
										</div>
									</div>
								</c:forEach>	
			</div>
			
		</div>
		
		<div id="checkSubmit" class="t">
			<div class="checkSubmitInfo c">
			<div class="checkSubmitInfoBooking">
				<div class="checkSubmitInfoLeft l">
					
					
				</div>
				<div class="checkSubmitInfoRight r">
					<ul>
						<li><span>合计<span class="pri" style="font-size: 14px;color: #000;"><i>${carPrice}</i></span></span></li>
						<li>
							<span>商品总额：<span class="pri" style="color: #000;">￥${carPrice}</span></span>
							<div class="rightSave"><i></i><span>共节省：￥0.00</span></div>
						</li>
					</ul>
					<div class="rightSubmit r" id="button">立即结算</div>
				</div>
			</div>
			</div>
		</div>
		<div id="checkTab">
			<div class="checkTabInfo t">
				<div class="checkTabInfoContent c">
					<div class="checkTabHeader">猜你喜欢</div>
					<div class="checkTabInfoContentBody c">
						<div class="longBox">
							<div class="longBoxContent">
								<!--<div class="longBoxContentLi l">
									<div class="longBoxContentLiImg">
										<img src="img/shoppingCar/shoppingbag_lunbo1.jpg"/>
									</div>
									<div class="longBoxContentLiInfo">
										<div class="infoTag">LANCOME</div>
										<div class="infoName">兰蔻眼部精华肌底液嘉年华礼盒...</div>
										<div class="infoPrice">￥680.00</div>
									</div>
								</div>-->
							</div>
						</div>
					</div>
					<div class="checkBtn">
						<div class="controlLeft l"></div>
						<div class="controlRight r"></div>
					</div>
				</div>
			</div>
		</div>
		<footer id="Footer">
			<!--封装-->
		</footer>
	</body>
	<script>
		//公共head
		$('header').load("commonHtml/header.html");
		//公共footer
		$('footer').load("commonHtml/footer.html");
	</script>
	<script type="text/javascript">
	
	$(function(){
		//绑定验证的点击事件
		$("#button").click(function(){
			alert("正在进行结算处理")
			 $.ajax({
	                type: "POST",
	                url:"../payMoney",
	                data: {
	                	 "store": $("#store").val(),
	                	 "price":$("#price").val(),
	                },
	                success: function (data) {
	                    if (data.status == "success") {
	                        window.location.href = "../index.jsp";
	                    } else {
	                    	window.location.href = "../index.jsp";
	                    }
	                },
	                error: function (data) {
	                    alert("出错了" + data.responseText);
	                }
	            });
		})
	})
	</script>
</html>
