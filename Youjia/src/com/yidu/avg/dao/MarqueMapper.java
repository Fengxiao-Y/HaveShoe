package com.yidu.avg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Marque;

@Component
public interface MarqueMapper {
	
	@Select("SELECT*FROM MARQUE")
	List<Marque> MarqueList();
	
	@Select("SELECT*FROM MARQUE where marId=#{marId}")
	Marque queryMarqueById(Integer marId);
	
	@Update("UPDATE youjia.marque set stores = #{stores} where marId = #{marId}")
	int update(Marque marque);
}
