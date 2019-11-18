package com.yidu.avg.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.avg.dao.CarMapper;
import com.yidu.avg.dao.OrderMapper;
import com.yidu.avg.dao.OutBoundMapper;
import com.yidu.avg.dao.SummaryMapper;
import com.yidu.avg.pojo.Car;
import com.yidu.avg.pojo.Marque;
import com.yidu.avg.pojo.Order;
import com.yidu.avg.pojo.Outbound;
import com.yidu.avg.pojo.Summary;
import com.yidu.avg.server.model.CarModel;
import com.yidu.avg.server.model.OrderDetailsModel;
@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OutBoundMapper outBoundMapper;
	@Autowired
	private SummaryMapper summaryMapper;
	public int insert(Order order) {

		return orderMapper.insert(order);
	}

	public List<Order> queryAllOrder(Integer usId){

		return orderMapper.queryAllOrder(usId);
	}
	public void insert(OrderDetailsModel orderDetailsModel) {
		Summary summary=SummaryconvertFromOrderDetailsModel(orderDetailsModel);
		Outbound outbound=convertOutboundFromOrderDetailsModel(orderDetailsModel);
		summaryMapper.insertS(summary);
		outBoundMapper.insertO(outbound);
		return;
	}



	public Outbound convertOutboundFromOrderDetailsModel(OrderDetailsModel orderDetailsModel) {
		if(orderDetailsModel==null) {
			return null;
		}
		Outbound outbound=new Outbound();
		BeanUtils.copyProperties(orderDetailsModel, outbound);
		return outbound;
	}

	public Summary SummaryconvertFromOrderDetailsModel(OrderDetailsModel orderDetailsModel) {
		if(orderDetailsModel==null) {
			return null;
		}
		Summary summary=new Summary();
		BeanUtils.copyProperties(orderDetailsModel, summary);
		return summary;
	}
	public int insertO(Outbound outbound) {
		
		return outBoundMapper.insertO(outbound);
	}
	
	
	public int insertS(Summary summary) {
		
		return summaryMapper.insertS(summary);
	}
	
}	
