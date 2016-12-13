package cn.itcast.oa.base;

import java.util.List;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.util.QueryHelper;


public interface DaoSupport<T> {
	
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 按id查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 公共的查询分页的方法
	 * @param pageNum:当前页
	 * @param pageSize：每页显示多少条
	 * @param hql
	 * @param parameters：hql中的参数与顺序与hql 的？顺序对应
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum,int pageSize, String hql, List<Object> parameters);
	/**
	 * 公共的查询分页的方法
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
