package com.yidu.avg.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.avg.dao.MarqueMapper;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
import com.yidu.avg.pojo.Marque;

@Service
public class MarqueService {
	
	@Autowired
	private MarqueMapper marqueMapper;
	
	public List<Marque> MarqueList(){
		
		return marqueMapper.MarqueList();
	}
	public Marque queryMarqueById(Integer marId) throws BusinessException {
		Marque marque = marqueMapper.queryMarqueById(marId);
		if(marque==null) {
			throw new BusinessException(EmBusinessError.COMMODITY_NOT_EXIST);
		}
		return marque;
	}
}
