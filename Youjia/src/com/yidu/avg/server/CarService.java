package com.yidu.avg.server;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.avg.dao.CarMapper;
import com.yidu.avg.dao.MarqueMapper;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
import com.yidu.avg.pojo.Car;
import com.yidu.avg.pojo.Marque;
import com.yidu.avg.server.model.CarModel;
@Service
public class CarService {
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private MarqueMapper marqueMapper;
	
	@Transactional
	public void insert(CarModel carModel) throws BusinessException {
		Car car = convertCarFromCarModel(carModel);
		carMapper.insert(car);
		Marque marques=marqueMapper.queryMarqueById(car.getId());
		if(marques==null) {
			throw new BusinessException(EmBusinessError.SHOOPING_ERRO);
		}
		Marque marque=new Marque();
		marque.setMarId(car.getId());
		marque.setStores(marques.getStores()-car.getStore());
		marqueMapper.update(marque);
		return;
	}
	
	
	public Car convertCarFromCarModel(CarModel carModel) {
		if(carModel==null) {
			return null;
		}
		Car car=new Car();
		BeanUtils.copyProperties(carModel, car);
		return car;
	}
	
	public Marque convertMarqueFromCarModel(CarModel carModel) {
		if(carModel==null) {
			return null;
		}
		Marque marque=new Marque();
		BeanUtils.copyProperties(carModel, marque);
		return marque;
	}
	
	public List<Car> queryAll(String userName){
		
		return carMapper.queryAllCar(userName);
	}
	public int updateStore(Car car) {
		
		return carMapper.update(car);
	}
	
	public int deleteCommodityById(Integer id,String username,double price) {
		
		return carMapper.deleteCommodityById(id,username,price);
	}
	
	public int deleteCommodityByUsName(String username) {
		
		return carMapper.deleteCommodityByUsName(username);
	}
	public int allMoney(String username) {
		
		return carMapper.allMoney(username);
	}
}	
