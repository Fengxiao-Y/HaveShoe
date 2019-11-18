package com.yidu.avg.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.avg.dao.UserMapper;
import com.yidu.avg.pojo.Usershoe;

@Service
public class UserService{
	@Autowired
	private UserMapper userMapper;
	public int insert(Usershoe usershoe) {
		
		return userMapper.insert(usershoe);
	}

	public Usershoe queryUser(String usName, String usPwd) {
		// TODO Auto-generated method stub
		return userMapper.queryUser(usName, usPwd);
	}

	public List<Usershoe> queryUserByUsPhone(String usName) {
		// TODO Auto-generated method stub
		return userMapper.queryUserByUsPhone(usName);
	}

	

}
