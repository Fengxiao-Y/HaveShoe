package com.yidu.avg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.avg.controller.response.CommonReturnType;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
import com.yidu.avg.pojo.Car;
import com.yidu.avg.pojo.Marque;
import com.yidu.avg.server.CarService;
import com.yidu.avg.server.MarqueService;
import com.yidu.avg.server.model.CarModel;

@Controller
public class MarqueController extends BaseController{
	
	@Autowired
	private MarqueService marqueService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private CarService carService;
	@RequestMapping("/toList")
	public String queryAllMarque(Model model) throws BusinessException {
		List<Marque> marqueList = marqueService.MarqueList();
		if(marqueList==null) {
			throw new BusinessException(EmBusinessError.COMMODITY_NOT_EXIST);
		}
		request.getSession().setAttribute("marqueList",marqueList);
		System.out.println(marqueList.toString());
		return "redirect:jsp/list.jsp";
	}
	
	@RequestMapping("/marIds")
	public String queryMarqueById(Integer marId) throws BusinessException {
		
		Marque marque = marqueService.queryMarqueById(marId);
		request.getSession().setAttribute("marque", marque);
		return "redirect:jsp/details.jsp";
	}
	@RequestMapping("/homeToShoppingCar")
	public String to() {
	String userName = (String) request.getSession().getAttribute("usName");
	List<Car> carList = carService.queryAll(userName);
	if(carList!=null&&carList.size()>0) {
	int carPrice=carService.allMoney(userName);
	request.getSession().setAttribute("carList", carList);
	request.getSession().setAttribute("carPrice", carPrice);
	return"redirect:jsp/shoppingCar.jsp";
	}else {
		return "redirect:jsp/home.jsp";
	}
	}
	
	@RequestMapping("/toShoppingCar")
	public String toShoppingPage(Integer marId,String marUrl,String shoeName,Integer shoeSize,
			double price,Integer store) throws BusinessException {
		String userName = (String) request.getSession().getAttribute("usName");
		CarModel carModel=new CarModel();
		carModel.setId(marId);
		carModel.setUsername(userName);
		carModel.setMarUrl(marUrl);
		carModel.setShoeName(shoeName);
		carModel.setShoeSize(shoeSize);
		carModel.setPrice(price);
		carModel.setStore(store);
		carService.insert(carModel);
		List<Car> carList = carService.queryAll(userName);
		int carPrice=carService.allMoney(userName);
		request.getSession().setAttribute("carList", carList);
		request.getSession().setAttribute("carPrice", carPrice);
		System.err.println("________________________________+++++++++++++++++++++++++"+carPrice);
		return"redirect:jsp/shoppingCar.jsp";
	}
	@RequestMapping("/deleteById")
	@ResponseBody
	public CommonReturnType delete(Integer id,String username,double price) throws BusinessException {
		carService.deleteCommodityById(id,username,price);
		if(username==null||username=="") {
			throw new BusinessException(EmBusinessError.SHOPPINGCAR_NULL);
		}
		return CommonReturnType.create(null);
		
	}
	@RequestMapping("/deleteByuserName")
	@ResponseBody
	public CommonReturnType deleteUn(String username) throws BusinessException {
		carService.deleteCommodityByUsName(username);
		if(username==null||username=="") {
			throw new BusinessException(EmBusinessError.SHOPPINGCAR_NULL);
		}
		return CommonReturnType.create(null);
		
	}
	@RequestMapping("/toOrder")
	@ResponseBody
	public CommonReturnType toOrderPage() {
		String userName = (String) request.getSession().getAttribute("usName");
		List<Car> orderList = carService.queryAll(userName);
		request.getSession().setAttribute("orderList", orderList);
		int carPrice=carService.allMoney(userName);
		request.getSession().setAttribute("carPrice", carPrice);	
		return CommonReturnType.create(null);
	}
	
	@RequestMapping("/updateForStore")
	@ResponseBody
	public CommonReturnType toUpdateStore(String shoeName,Integer store) {
		Car car=new Car();
		car.setShoeName(shoeName);
		car.setStore(store);
		carService.updateStore(car);
		return CommonReturnType.create(null) ;
	}
}
