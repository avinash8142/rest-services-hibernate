package com.web.restserviceshibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.restserviceshibernate.dao.AfuDao;
import com.web.restserviceshibernate.model.AfuInfo;

@Service
public class AfuServiceImpl implements AfuService {

	@Autowired
	private AfuDao afuDao;
	
	@Override
	public AfuInfo getAfuInfo() {
		String url = afuDao.getValue("afu url", "afu service");
		System.out.println("url is "+url);
		RestTemplate restTemplate = new RestTemplate();
		AfuInfo afu = restTemplate.getForObject(url, AfuInfo.class);
		System.out.println("details "+afu);
		return  afu;
	}

}
