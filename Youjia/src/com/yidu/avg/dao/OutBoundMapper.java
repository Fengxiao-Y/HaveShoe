package com.yidu.avg.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Outbound;

@Component
public interface OutBoundMapper {
	
	@Select("insert into youjia.outbound\r\n" + 
			"( obTime, soId, odNumber)values\r\n" + 
			"(#{obTime}, #{soId}, #{odNumber})")
	int insertO(Outbound outbound);
	
}
