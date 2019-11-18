package com.yidu.avg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.yidu.avg.pojo.Car;

@Component
public interface CarMapper {
	
	@Insert("INSERT INTO youjia.cartable(id,username, shoeName,price, store, marUrl,shoeSize)VALUES(#{id}, #{username}, #{shoeName}, #{price}, #{store}, #{marUrl},#{shoeSize})")
	int insert(Car car);
	
	@Select("select*from cartable where userName=#{userName}")
	List<Car> queryAllCar(String userName);
	
	@Update("UPDATE youjia.cartable set store = #{store} where shoeName = #{shoeName}")
	int  update(Car car);
	
	@Delete("DELETE FROM youjia.cartable WHERE  id=#{id} and username = #{username} and price=#{price}")
	int deleteCommodityById(@Param("id")Integer id,@Param("username")String username,@Param("price")double price);
	
	@Delete("DELETE FROM youjia.cartable WHERE username = #{username}")
	int deleteCommodityByUsName(@Param("username")String username);
	
	@Select("SELECT SUM(price) FROM cartable WHERE username=#{username}")
	int allMoney(String username);
	
}
