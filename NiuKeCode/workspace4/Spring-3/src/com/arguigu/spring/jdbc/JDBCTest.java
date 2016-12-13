package com.arguigu.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sun.management.counter.LongArrayCounter;

public class JDBCTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private EmployeeDao employeeDao;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
	}
	
	
	@Test
	public void testEmployeeDao(){
		System.out.println(employeeDao.get(1));
	}
	/*
	 * 获取单个列的值，或者做统计查询
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	/*
	 *希望查到实体类的集合 
	 *注意调用的不是queryForList()方法；
	 * 
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id> ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);
		System.out.println(employees);
	}
	
	/*
	 * 从数据库中查询一条记录，返回一个对象,使用jdbcTemplate.queryForObject(sql, rowMapper,1)
	 * 不支持级联属性，JdbcTemplete 到底只是一个jdbc的小工具，而不是ORM框架
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id=?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		
		System.out.println(employee);
	}
	/*
	 * 批量执行更新：Update，Insert,Delete
	 */
	@Test
	public void testBatchUpdate(){
		String sql1 = "INSERT INTO employees(last_name, email, dept_id) VALUES('AA','AA@qq.com',3)";
		String sql2 = "INSERT INTO employees(last_name, email, dept_id) VALUES('BB','BB@qq.com',4)";
		String sql3 = "INSERT INTO employees(last_name, email, dept_id) VALUES('CC','CC@qq.com',3)";
		String sql4 = "INSERT INTO employees(last_name, email, dept_id) VALUES('DD','DD@qq.com',1)";
		String sql5 = "INSERT INTO employees(last_name, email, dept_id) VALUES('EE','EE@qq.com',4)";
		
		String[] str = new String[]{sql1,sql2,sql3,sql4,sql5};
		jdbcTemplate.batchUpdate(str);
	
	}

	/*
	 * 执行Insert,update,delete
	 */
	@Test
	public void testUpdate(){
		String sql="UPDATE employees SET last_name=? WHERE id=?";
		jdbcTemplate.update(sql, "Hsw",4);
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
