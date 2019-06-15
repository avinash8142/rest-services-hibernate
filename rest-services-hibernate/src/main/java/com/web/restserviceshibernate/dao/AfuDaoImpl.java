package com.web.restserviceshibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AfuDaoImpl implements AfuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public String getValue(String key, String desc) {
		String sql="select ap_value from winrisk.application_properties where ap_key=:ap_key and ap_desc=:ap_desc";
		List<String> values = getSession().createSQLQuery(sql)
		.setParameter("ap_key", key)
		.setParameter("ap_desc", desc)
		.list();
		
		if(values!=null && values.size()>0)
			return values.get(0);
		return null;
	}

}
