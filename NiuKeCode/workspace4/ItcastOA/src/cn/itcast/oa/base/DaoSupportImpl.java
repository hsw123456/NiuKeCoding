package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.util.QueryHelper;

@SuppressWarnings("unchecked")
@Transactional
public class DaoSupportImpl<T> implements DaoSupport<T> {

	private Class<T> clazz = null;// 这是一个待解决的问题

	@Autowired
	private SessionFactory sessionFactory;

	public DaoSupportImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];

		System.out.println("clazz--->" + clazz);
	}

	/**
	 * protected 修饰，子类可以访问
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void delete(Long id) {

		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}

	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public T getById(Long id) {

		if (id == null) {
			return null;
		} else {

			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {

		if (ids == null || ids.length == 0) {

			return Collections.EMPTY_LIST;
		} else {

			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
					.setParameterList("ids", ids).list();
		}

	}

	public List<T> findAll() {

		return getSession().createQuery(//
				"FROM  " + clazz.getSimpleName())//
				.list();
	}

	// 通用的分页方式
	@Deprecated
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {

		System.out.println("-------->DaoSupportImpl.getPagebean()");

		// 查询列表
		Query listQuery = getSession().createQuery(hql);
		// 设置参数
		if (parameters != null) {

			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}

		List list = listQuery.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();

		// 查询总数量

		Query countQuery = getSession().createQuery("SELECT count(*)" + hql);
		if (parameters != null) {

			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}

		Long count = (Long) countQuery.uniqueResult();
		return new PageBean(pageSize, pageNum, list, count.intValue());
	}

	/**
	 * 公共的查询分页的方法（最终版）
	 */
	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {

		System.out.println("----->DaoSupportImpl.getPageBean最终版--<");

		// 查询列表
		Query listQuery = getSession().createQuery(queryHelper.getListQueryHql());
		
		// 设置参数,参数列表从QueryHelper中获取
		List<Object> parameters = queryHelper.getParameters();
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}

		List list = listQuery.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();

		// 查询总数量
		Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
		if (parameters != null) {

			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}

		Long count = (Long) countQuery.uniqueResult();
		return new PageBean(pageSize, pageNum, list, count.intValue());
	}

}
