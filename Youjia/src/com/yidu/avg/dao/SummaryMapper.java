package com.yidu.avg.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Summary;

@Component
public interface SummaryMapper {
	
	
	@Insert("INSERT INTO youjia.fiscalsummary(fName, fState, countTime, fPrice)VALUES(#{fName}, #{fState}, #{countTime}, #{fPrice})" )
	int insertS(Summary summary);
}
