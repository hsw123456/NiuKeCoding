package cn.itcast.oa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements
		ForumService {

	@Override
	public List<Forum> findAll() {
		return getSession().createQuery(//
				"FROM Forum f ORDER BY f.position ").list();
	}

	public void moveUp(Long id) {
		// 找出相关的Forum
		Forum forum = getById(id);// 找出当前需要移动的Forum
		Forum other = (Forum) getSession().createQuery(//
				"FROM Forum f WHERE f.position <? ORDER BY f.position DESC")
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult(); // 找出其上面的Fourm

		// 最上面不能上移
		if (other == null) {
			return;
		}

		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);

		// 更新到数据库中,可以不写，此时的对象是持久化状态
		getSession().update(forum);
		getSession().update(other);
	}

	public void moveDown(Long id) {
		// 找出相关的Forum
		Forum forum = getById(id);// 找出当前需要移动的Forum
		Forum other = (Forum) getSession().createQuery(//
				"FROM Forum f WHERE f.position >? ORDER BY f.position ASC")
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult(); // 找出其下面的Fourm

		// 最下面的不能下移
		if (other == null) {
			return;
		}

		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);

		// 更新到数据库中,可以不写，此时的对象是持久化状态
		getSession().update(forum);
		getSession().update(other);

	}

	@Override
	public void save(Forum entity) {
		//保存，设置position的值
		super.save(entity);
		//只有保存完，id才会产生
		entity.setPosition(entity.getId().intValue());
	}
	
	

}
