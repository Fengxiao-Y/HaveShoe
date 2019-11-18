package com.yidu.avg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Usershoe;


@Component
public interface UserMapper {
	
	@Insert("INSERT INTO usershoe (usName, usPwd, usSex, usEmail, usAddress, usPhone, usPostal)VALUES(#{usName},#{usPwd},#{usSex},#{usEmail},#{usAddress},#{usPhone},#{usPostal})")
	int insert(Usershoe usershoe);
	
	
	@Select("select*from usershoe where usName=#{usName} and usPwd=#{usPwd}")
	Usershoe queryUser(@Param("usName")String usName,@Param("usPwd")String usPwd);
	
	
	@Select("select*from usershoe where usName=#{usName}")
	List<Usershoe> queryUserByUsPhone(@Param("usName")String usName);
	
}
