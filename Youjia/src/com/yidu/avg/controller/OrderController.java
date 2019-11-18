package com.yidu.avg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.avg.controller.response.CommonReturnType;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
import com.yidu.avg.pojo.Car;
import com.yidu.avg.pojo.Order;
import com.yidu.avg.server.CarService;
import com.yidu.avg.server.OrderService;
import com.yidu.avg.server.model.OrderDetailsModel;

import javafx.scene.chart.PieChart.Data;
import oracle.net.aso.d;

@Controller
public class OrderController extends BaseController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CarService carService;
	@RequestMapping(value="/payMoney",method = RequestMethod.POST)
	@ResponseBody
	public CommonReturnType OrderDetails(Integer store, double price) throws BusinessException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String dt=df.format(new Date());
		Integer id = (Integer) request.getSession().getAttribute("usId");
		String userName = (String) request.getSession().getAttribute("usName");
		Order order=new Order();
		order.setSoTime((String)df.format(new Date()));
		order.setUsId(id);
		order.setCounts(store);
		order.setSubtotal(price);
		orderService.insert(order);
		carService.deleteCommodityByUsName(userName);
		List<Order> allOrder = orderService.queryAllOrder(id);
		if(allOrder==null) {
			throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
		}
		for (Order orders : allOrder) {
			OrderDetailsModel o=new OrderDetailsModel();
			o.setObTime(df.format(new Date()));
			o.setSoId(orders.getSoId());
			o.setOdNumber(store);
			o.setfName("卖出的鞋子");
			o.setfState("已卖出");
			o.setCountTime(dt);
			o.setfPrice(price);
			orderService.insert(o);
		}
		request.getSession().setAttribute("price", price);
		return CommonReturnType.create(null);
	}
	
}
