package cn.itcast.oa.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	public User findUser(String loginName, String password) {
		
		String md5Password = DigestUtils.md5Hex(password);
		
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=?" +
				" AND u.password=?").setParameter(0, loginName)
									.setParameter(1, md5Password).uniqueResult();
		
	}

}
