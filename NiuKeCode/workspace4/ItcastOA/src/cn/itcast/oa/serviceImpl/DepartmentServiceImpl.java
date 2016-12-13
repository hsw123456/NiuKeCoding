package cn.itcast.oa.serviceImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService{
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public void update(Department model) {
		
		departmentDao.update(model);
	}

	public void save(Department model) {
		departmentDao.save(model);
	}*/
	/**
	 * 查询顶级部门列表
	 */
	
	public List<Department> findTopList() {
		String hql = "FROM Department d WHERE d.parent IS NULL";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).list();
	}
	
	/**
	 * 查询子部门列表
	 */
	public List<Department> findChildren(Long parentId) {
		String hql = "FROM Department d WHERE d.parent.id=?";
		
		return  sessionFactory.getCurrentSession()
				.createQuery(hql).setParameter(0, parentId).list();
	}



}
