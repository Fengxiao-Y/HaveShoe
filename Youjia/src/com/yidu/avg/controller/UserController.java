package com.yidu.avg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.avg.controller.response.CommonReturnType;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
import com.yidu.avg.pojo.Usershoe;
import com.yidu.avg.server.UserService;
import com.yidu.avg.util.Md5;


@Controller
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest  request;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public CommonReturnType register(@RequestParam("usName")String usName,
									@RequestParam("usPwd")String usPwd,
									@RequestParam("usSex")String usSex,
									@RequestParam("usEmail")String usEmail,
									@RequestParam("usAddress")String usAddress,
									@RequestParam("usPhone")String usPhone,
									@RequestParam("usPostal")String usPostal) throws BusinessException {
		
		Usershoe u=new Usershoe();
		u.setUsName(usName);
		u.setUsPwd(Md5.MD5(usPwd));
		u.setUsSex(usSex);
		u.setUsEmail(usEmail);
		u.setUsAddress(usAddress);
		u.setUsPhone(usPhone);
		u.setUsPostal(usPostal);
		List<Usershoe> queryUserByUsPhone = userService.queryUserByUsPhone(usName);
		for (Usershoe usershoe : queryUserByUsPhone) {
			if(usershoe.getUsName().equals(usName)) {
				throw new BusinessException(EmBusinessError.USER_EXIST);
			}
		}
		userService.insert(u);
		return CommonReturnType.create(u);
		
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public CommonReturnType login(@RequestParam("usName")String usName,@RequestParam("usPwd")String usPwd) throws BusinessException {
		String usPassWord=Md5.MD5(usPwd);
		Usershoe user = userService.queryUser(usName, usPassWord);
		if(user==null) {
			throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
		}
		request.getSession().setAttribute("usAddress", user.getUsAddress());
		request.getSession().setAttribute("usName", usName);
		request.getSession().setAttribute("usId", user.getUsId());
	return CommonReturnType.create(user);
	}
}
