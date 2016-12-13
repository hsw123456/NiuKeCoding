package cn.itcast.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService{
	
	/*@Autowired
	private RoleDao roleDao;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public void delete(Long id) {
		roleDao.delete(id);
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public void save(Role role) {
		roleDao.save(role);
	}*/

}
