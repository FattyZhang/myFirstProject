package com.example.myFirstProject.service;

import java.util.List;

import com.example.myFirstProject.mode.emp;


public interface empService {
	
	public List<emp> getEmpAll(emp emp);
	public List<emp> getEmpAll();
	public emp getById(Integer id);
	public void updateEmp(emp e);
	public void deleteById(Integer id);
	public void insertEmp(emp e);
	public List<emp> pageList(Integer start, Integer size);
	
}
