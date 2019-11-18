<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>【有家鞋店】购物车</title>
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
						<div class="carHeaderRightStep l carHeaderRightStep1">
							<em class="checkoutStep"></em>
						</div>
						<div class="carHeaderRightStep l carHeaderRightStep2">
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
					<div class="checkoutTable">
						<em class="checkBox checkIcon"></em>
						<ul class="checkoutTableHeader">
							<li>全选</li>
							<li>商品信息</li>
							<li>单价（元）</li>
							<li>数量</li>
							<li>小计（元）</li>
							<li>操作</li>
						</ul>
						<div class="checkoutProductBody">
							<div class="productBodyItem">
								<c:if test="${carPrice>=0}">
								<c:forEach items="${carList}" var="mar">
									<div class="productBodyItemContent">
										<em class="checkBox checkIcon" oc="0"></em>
										<a class="itemImg" href=""><img src="${mar.marUrl}"/></a>
										<div class="itemInfo">
											<h5>ADIDAS</h5>
											<a href="">STAN SMITH ${mar.shoeName}</a>
											<div><span>${mar.shoeSize}码<i></i></span></div>
											<input type="hidden" value="${mar.id}" name="id" id="id"/>
											<input type="hidden" value="${mar.username}" name="username" id="username"/>
											<input type="hidden" value="${mar.price}" name=price id="price"/>
											<input type="hidden" value="${mar.shoeName}" name="shoeName" id="shoeName"/>
										</div>
										<div class="itemInfoUnion1">
											<span class="itemInfoUnionPice">${mar.price}</span>
										</div>
										<div class="itemInfoUnion2">
											<div class="itemInfoUnion2Module l">
												<i class="itemInfoUnion2ModuleI l itemInfoUnion2ModuleI1">-</i>
												<!--<span class="itemInfoUnion2ModuleNum l">1</span>-->
												<input type="text" class="itemInfoUnion2ModuleNum l" name="store" id="store" value="${mar.store}"/>
												<i class="itemInfoUnion2ModuleI l itemInfoUnion2ModuleI2">+</i>
											</div>
										</div>
										<div class="itemInfoUnion3">
											<span class="sumNum">${mar.store*mar.price}</span>
											<input type="hidden" value="${mar.store*mar.price}" id="allPrice"/>
										</div>
										<div class="itemInfoUnion4">
											<i class="delete"></i>
										</div>
									</div>
								</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="checkoutCoupons">
			<div class="checkoutCouponsInfo t">
				<div class="CouponsInfoContent c">
					<p class="CouponsInfoContentH c">
						<span class="sp1">优惠券</span>
						<span class="sp2">*了解优惠券</span>
						<span class="sp3">使用规则</span>
						<input type="button" value="+ 输入优惠码" />
					</p>
					<div class="CouponsInfoContentBody">
						<div class="couponBody">
							<div class="couponNone"></div>
							<span>您目前没有优惠券</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="checkSubmit" class="t">
			<div class="checkSubmitInfo c">
			<div class="checkSubmitInfoBooking">
				<div class="checkSubmitInfoLeft l">
					<em class="checkBox checkIcon l"></em>
					<a class="allClick">全选</a>
					<a class="allDelete">批量删除</a>
					<div class="split"></div>
					<a class="callService">联系客服</a>
				</div>
				<div class="checkSubmitInfoRight r">
					<ul>
						<li><span>已选0件商品，合计<span class="pri" style="font-size: 14px;color: #000;">￥${carPrice}</span></span></li>
						<li>
							<span>商品总额：<span class="pri" style="color: #000;" id="ls">￥${carPrice}</span></span>
							<div class="rightSave"><i></i><span>共节省：￥0.00</span></div>
						</li>
					</ul>
					<div class="rightSubmit r" id="toA"><a href="../toOrder">立即结算</a></div> 
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
	  $("#toA").click(function(){
		  $.ajax({
              type: "POST",
              contentType: "application/x-www-form-urlencoded",
              url: "../toOrder",
              data: {
                  "store": $("#store").val(),
              },
              xhrFields: {withCredentials: true},
              success: function (data) {
                  if (data.status == "success") {
                      alert("快去结算吧！")
                      window.location.href = "order.jsp?store="+$(this).data("store");
                  } else {
                      alert("似乎出了什么错误" + data.data.errMsg);
                  }
              },
              error: function (data) {
                  alert("似乎出了什么错误" + data.responseText);
              }
          });
		  
	  	})
	</script>
</html>