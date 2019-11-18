package com.yidu.avg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Order;

@Component
public interface OrderMapper {
	
	@Insert("INSERT INTO youjia.salesorder \r\n" + 
			"(soTime,usId,counts,subtotal)\r\n" + 
			"	VALUES\r\n" + 
			"	(#{soTime},#{usId},#{counts},#{subtotal})\r\n" + 
			"")
	int insert(Order order);
	
	@Select("SELECT*FROM youjia.salesorder WHERE usId=#{usId}")
	List<Order> queryAllOrder(@Param("usId")Integer usId);
}
