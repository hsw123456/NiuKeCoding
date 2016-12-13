package cn.itcast.oa.daoImpl;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;


@Deprecated
@Repository
public class DepartmentDaoImpl extends DaoSupportImpl<Department> implements DepartmentDao{

}
