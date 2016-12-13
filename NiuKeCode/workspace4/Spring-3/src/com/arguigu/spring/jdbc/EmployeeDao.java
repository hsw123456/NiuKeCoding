package com.arguigu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	/*
	 * 在DAO 中将 JdbcTemplete 作为DAO 的成员变量使用
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Employee get(Integer id){
		
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id=?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		
		return employee;
	}
}
