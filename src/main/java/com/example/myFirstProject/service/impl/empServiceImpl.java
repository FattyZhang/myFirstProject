package com.example.myFirstProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myFirstProject.dao.empDao;
import com.example.myFirstProject.mode.emp;
import com.example.myFirstProject.service.empService;

import pageUtil.Page;

@Service
public class empServiceImpl implements empService{
	
	@Autowired
	private empDao empdao;

	public List<emp> getEmpAll(emp emp) {
		return empdao.getEmpAll(emp);
	}

	public emp getById(Integer id) {
		return empdao.getById(id);
	}

	public void updateEmp(emp e) {
		empdao.updateEmp(e);
	}

	public void deleteById(Integer id) {
		empdao.deleteById(id);
	}

	public void insertEmp(emp e) {
		empdao.insertEmp(e);
	}

	public List<emp> getEmpAll() {
		return empdao.getEmpAll();
	}
	public List<emp> pageList(Integer size,Integer currentpage){
		Integer count = empdao.getEmpCount();
		Page page = new Page(size, currentpage, count);
		List<emp> pageList = empdao.getPageList(page);
		return pageList;
	}


}








