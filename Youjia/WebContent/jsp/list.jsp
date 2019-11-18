<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>【有家鞋店】商品列表</title>
		<script type="text/javascript" src="../js/jquery.js" ></script>
		<link rel="stylesheet" href="../css/base.css" />
		<link rel="stylesheet" href="../css/注册head.css" />
		<link rel="stylesheet" href="../commonCss/FixedRight.css" />
		<link rel="stylesheet" href="../commonCss/footer.css" />
		<link rel="stylesheet" href="../commonCss/header.css" />
		<link rel="stylesheet" href="../css/list.css" />
		<script type="text/javascript" src="../js/brand.js" ></script>
		<script type="text/javascript" src="../js/list.js" ></script>
		<script type="text/javascript" src="../js/vue.js" ></script>
	</head>
	<body>
		<header>
			<!--公共头-->
		</header>
		<div class="head_top">
		<a href="商品详情.html" target="_blank"><div class="top_background"></div></a>
		<div class="head_center">
							<image src="../images/LOGO3.png" style="margin-left:300px;">
							<a href="男鞋.html" target="_blank">男子</a>
							<a href="">女子</a>
							<a href="">儿童</a>
							<a href="">运动</a>
							<a>|</a>
							<a href="">品牌</a>
							<a href="">精选系列</a>
							<input type="text" class="head_search" placeholder="请输入搜索内容" style="margin-left:200px;">
							<a class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
							</input>
	</div>
	<div class="head_bottom">
		<a href="">全场免运费</a>
		<a href="">尊享当日达、次日达、次晨达</a>
		<a href="">注册会员支持货到付款</a>
	</div>
	</div>
		<div id="productCategory" class="t">
			<div class="brandNav c">
				<ul class="navLeft l">
					<li><a href="首页.html">首页</a></li>
					<li>></li>
					<li><a href="#">潮鞋大全</a></li>
				</ul>
				<div class="navRight r">共<b>316</b>件商品</div>
			</div>
			<ul class="listBrand c">
				<li class="b" >分类</li>
				<li class="liRelative">
					<a href="#">男鞋</a>
					<div class="dropDown">
						<div class="dropDownContentT l">
							<a href="#">全部</a>
						</div>
						<ul class="l">
							<li><a href="#">跑步</a></li>
							<li><a href="#">帆布/滑板</a></li>
							<li><a href="#">拖鞋/凉鞋</a></li>
							<li><a href="#">复古/老爹鞋</a></li>
							<li><a href="#">篮球</a></li>
							<li><a href="#">足球</a></li>
							<li><a href="#">户外</a></li>
						</ul>
					</div>
				</li>
				<li class="liRelative">
					<a href="#">女鞋</a>
					<div class="dropDown">
						<div class="dropDownContentT l">
							<a href="#">全部</a>
						</div>
						<ul class="l">
							<li><a href="#">跑步</a></li>
							<li><a href="#">小白鞋</a></li>
							<li><a href="#">复古</a></li>
							<li><a href="#">拖鞋/凉鞋</a></li>
							<li><a href="#">户外</a></li>
						</ul>
					</div>
				</li>
				<li class="liRelative">
					<a href="#">童鞋</a>
					<div class="dropDown">
						<div class="dropDownContentT l">
							<a href="#">全部</a>
						</div>
						<ul class="l">
							<li><a href="#">拖鞋</a></li>
							<li><a href="#">户外</a></li>
							<li><a href="#">运动鞋</a></li>
						</ul>
					</div>
				</li>
				<li class="liRelative">
					<a href="#">品牌</a>
					<div class="dropDown">
						<div class="dropDownContentT l">
							<a href="#">全部</a>
						</div>
						<ul class="l">
							<li><a href="#">ADIDAS</a></li>
							<li><a href="#">NIKE</a></li>
							<li><a href="#">特步</a></li>
							<li><a href="#">PEAK</a></li>
							<li><a href="#">李宁</a></li>
							<li><a href="#">乔丹</a></li>
						</ul>
					</div>
				</li>
				<li class="liRelative">
					<a href="#">精选系列</a>
					<div class="dropDown">
						<div class="dropDownContentT l">
							<a href="#">全部</a>
						</div>
						<ul class="l">
							<li><a href="#">收藏特辑</a></li>
							<li><a href="#">绝版拍卖</a></li>
						</ul>
					</div>
				</li>
			</ul>
			<div class="nextNav t">
				<ul class="nextListBrand c">
					<li class="nextListItem t">
						<div class="itemTitlle l">适用人群</div>
						<ul class="itemIf l">
							<li><a href="#">女士</a></li>
							<li><a href="#">男士</a></li>
							<li><a href="#">各种人群</a></li>
						</ul>
						<div class="brandBtn">
							<div class="sBtn">
								<a class="selectMore bgIcon"></a>多选
							</div>
						</div>
						<div class="brandBtnCont">
							<div class="confCancel">
								<a href="" class="confirm">确认</a>
								<a class="cancel">取消</a>
							</div>
						</div>
					
					<li class="nextListItem t">
						<div class="itemTitlle l">类型</div>
						<ul class="itemIf l">
							<li><a href="#">跑步</a></li>
							<li><a href="#">训练</a></li>
							<li><a href="#">足球</a></li>
							<li><a href="#">篮球</a></li>
							<li><a href="#">户外</a></li>
							<li><a href="#">休闲</a></li>
							<li><a href="#">室内</a></li>
						</ul>
						<div class="brandBtn">
							<div class="sBtn">
								<a class="selectMore bgIcon"></a>多选
							</div>
						</div>
						<div class="brandBtnCont">
							<div class="confCancel">
								<a href="" class="confirm">确认</a>
								<a class="cancel">取消</a>
							</div>
						</div>
					</li>
					<li class="nextListItem t">
						<div class="itemTitlle l">价格</div>
						<ul class="itemIf l">
							<li><a href="#">199-399</a></li>
							<li><a href="#">399-699</a></li>
							<li><a href="#">699-1099</a></li>
							<li><a href="#">1099+</a></li>
						</ul>
						<div class="brandBtn">
							<div class="sBtn">
								<a class="selectMore bgIcon"></a>多选
							</div>
						</div>
						<div class="brandBtnCont">
							<div class="confCancel">
								<a href="" class="confirm">确认</a>
								<a class="cancel">取消</a>
							</div>
						</div>
					</li>
					<li class="change last t">
						<div class="itemTitlle l">新鞋爆款</div>
						<ul class="itemIf l">
							<li><a href="#">最新上市</a></li>
							<li><a href="#">限量发售</a></li>
							<li><a href="#">本月热卖</a></li>
							<li><a href="#">本周推荐</a></li>
						</ul>
						<div class="brandBtn">
							<div class="sBtn">
								<a class="selectMore bgIcon"></a>多选
							</div>
						</div>
						<div class="brandBtnCont">
							<div class="confCancel">
								<a href="" class="confirm">确认</a>
								<a class="cancel">取消</a>
							</div>
						</div>
					</li>
					<li class="foldMenu" oc="0"><a class="changeA">更多选项</a>
						<em class="changeEm changeEm1"></em>
					</li>
				</ul>
			</div>
			<div id="sortProduct" class="t">
				<div class="layout c">
					<div class="sortProductLeft l">
						<span class="sIcon1">综合<em class="e1"></em></span>
						<span>销量<em></em><i></i></span>
						<span>新品<em></em><i></i></span>
						<span>人气<em></em><i></i></span>
						<span>价格<em class="e2"></em><i></i></span>
					</div>
					<div class="checkTick l">
						<a></a><span>仅看有货</span>
					</div>
					<div class="flipLR r">
						<span class="colorH">1</span>
						<span>/</span>
						<span>13</span>
						<span class="flipL"></span>
						<span class="flipR"></span>
					</div>
				</div>
			</div>
						<div id="app" class="" style="border: 1px solid black;width: 1124px;margin: auto;height: auto;overflow: hidden;">
									<c:forEach items="${marqueList}" var="marque">
									<div class="pCont" style="float: left; margin-left: 32px">
											<div style="height: auto;width: auto;">
												<div class="pImg" id="hr">
													<a href="../marIds?marId=${marque.marId}"><img src="${marque.marUrl}"  style="width: 200px;height: 180px;"/></a>
													<div class="pBuy">立即购买</div>
												</div>
												<div class="pTags">
													<span>新品</span>  
												</div>
												<div class="brandEn">SEPHORACOLLECTION</div>
												<div class="productCn"><a href="../marIds?marId=${marque.marId}" target="_blank">${marque.marName}</a></div>
												<div class="productPrice">￥${marque.marPrice}</div>
										   </div>
									</div>
									 </c:forEach>
									
						</div>
			<div id="sortProduct" class="fixedsort t">
				<div class="layout c">
					<div class="sortProductLeft l">
						<span class="sIcon1">综合<em class="e1"></em></span>
						<span>销量<em></em><i></i></span>
						<span>新品<em></em><i></i></span>
						<span>人气<em></em><i></i></span>
						<span>价格<em class="e2"></em><i></i></span>
					</div>
					<div class="checkTick l">
						<a></a><span>仅看有货</span>
					</div>
					<div class="flipLR r">
						<span class="colorH">1</span>
						<span>/</span>
						<span>13</span>
						<span class="flipL"></span>
						<span class="flipR"></span>
					</div>
				</div>
			</div>
			<div id="pignationBg" class="t">
				<div class="pignationPlace">
					<div class="pignationPlaceList">
						<a class="listPrev" href="#">上一页</a>
						<div class="listPrevPage">
							<a class="bg" href="">1</a>
							<a href="">2</a>
							<a href="">3</a>
							<a href="">4</a>
							<a href="">...</a>
							<a href="">13</a>
						</div>
						<a class="blackFont listPrev" href="#">下一页</a>
						<div class="listPrevGo">
							到第<input class="listPrevGoInput1" />页
							<input type="submit" value="确定" class="listPrevGoInput2"/></div>
					</div>
				</div>
			</div>
			
		</div>
		<footer id="Footer">
			<!--封装-->
		</footer>
		<div id="FixedRight">
			<div class="fixedRightInfo">
				<ul>
					<li><a href="#">
						<em class="fixedRightInfo1">个人信息</em>
						<em class="FixedRightContent0 FixedRightContent1"></em>
					</a></li>
					<li><a href="shoppingCar.html">
						<em class="fixedRightInfo1">购物车</em>
						<em class="FixedRightContent0 FixedRightContent2"></em>
					</a></li>
					<li><a href="#">
						<em class="fixedRightInfo1">联系客服</em>
						<em class="FixedRightContent0 FixedRightContent3"></em>
					</a></li>
					<li><a href="#FixedRight">
						<em class="fixedRightInfo1">移动有家</em>
						<em class="FixedRightContent0 FixedRightContent4"></em>
					</a></li>
					<li><a class="toTop" href="#FixedRight">
						<em class="fixedRightInfo1">返回顶部</em>
						<em class="FixedRightContent0 FixedRightContent5"></em>
					</a></li>
				</ul>
			</div>
		</div>
		
		<script>
			//公共head
			$('header').load("../commonHtml/header.html");
			//公共footer
			$('footer').load("../commonHtml/footer.html");
		</script>
	</body>
</html>
