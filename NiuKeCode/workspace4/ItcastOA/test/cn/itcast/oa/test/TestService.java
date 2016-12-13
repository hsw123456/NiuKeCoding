package cn.itcast.oa.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.User;


@Service
public class TestService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void saveUsers(){
		
		Session session = null;
		session = sessionFactory.getCurrentSession();
		
		
		for(int i= 0; i<25; i++){
			User user = new User();
			user.setName("test_"+ (char)('A'+i));
			session.save(user);
		}
	}

}
