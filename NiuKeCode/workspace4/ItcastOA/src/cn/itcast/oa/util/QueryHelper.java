package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于辅助拼接HQL语句
 * @author Administrator
 * 本类可用于实现通用的分页方法
 */
public class QueryHelper {

	private String fromClause;// 必须的

	private String whereClause = "";// 可选

	private String orderByClause = "";// 可选

	private List<Object> parameters = new ArrayList<Object>();

	/**
	 * 初始化的时候生成FROM 子句
	 * 
	 * @param clazz
	 * @param alien
	 */
	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " AS " + alias;
	}

	/**
	 * 拼接WHERE 子句
	 * 
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(String condition, Object... params) {
		// 拼接where子句
		if (whereClause.length() == 0) {

			whereClause = " WHERE " + condition;
		} else {

			whereClause += " AND " + condition;
		}

		// 参数
		if (params != null) {
			for (Object o : params) {
				parameters.add(o);
			}
		}
		
		return this;
	}
	//条件成立拼接WHERE 子句
	public QueryHelper addCondition(boolean append,String condition, Object... params) {
		if(append){
			addCondition(condition, params);
		}
		return this;
	}

	/**
	 * 用于拼接ORDER By 子句
	 * @param propertyName
	 * @param asc
	 */
	public QueryHelper addOrderProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {

			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC ":" DESC ");
		} else {

			orderByClause += "," + propertyName + (asc ? " ASC ":" DESC ");
		}
		
		return this;

	}
	
	//条件成立拼接ORDER BY子句
	public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc) {
		if(append){
			addOrderProperty(propertyName, asc);
		}
		
		return this;
	}
	
	/**
	 * 获取HQL中的参数值列表
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
	
	/**
	 * 获取生成的用于查询数据列表的HQL语句
	 * @return
	 */
	public String getListQueryHql(){
		return fromClause+ whereClause+ orderByClause;
	}
	
	/**
	 * 获取生成的用于查询总记录数的HQL语句
	 * @return
	 */
	public String getCountQueryHql(){
		return "SELECT COUNT(*) " + fromClause+ whereClause;
	}
	
	

}
