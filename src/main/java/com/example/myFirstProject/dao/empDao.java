package com.example.myFirstProject.dao;

import java.util.List;

import com.example.myFirstProject.mode.emp;

import pageUtil.Page;


public interface empDao {
	
	public List<emp> getEmpAll(emp emp);
	public List<emp> getEmpAll();
	public emp getById(Integer id);
	public void updateEmp(emp e);
	public void deleteById(Integer id);
	public void insertEmp(emp e);
	public Integer getEmpCount();
	public List<emp> getPageList(Page page);
}
