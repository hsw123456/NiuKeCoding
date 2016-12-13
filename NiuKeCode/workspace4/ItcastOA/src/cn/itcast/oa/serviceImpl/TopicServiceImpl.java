package cn.itcast.oa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements
		TopicService {
	@Deprecated
	public List<Topic> findByForum(Forum forum) {

		return getSession()
				.createQuery(//
						"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC"
								+ ", t.lastUpdateTime DESC")//
				.setParameter(0, forum).list();
	}

	@Override
	public void save(Topic model) {
		// 业务层处理的数据:设置属性并保存
		model.setType(Topic.TYPE_NORMAL);// 默认为普通帖
		model.setReplyCount(0);
		model.setLastReply(null);
		model.setLastUpdateTime(model.getPostTime());
		// 保存
		getSession().save(model);

		// 维护相关的特殊属性
		/*
		 * topicCount 加1 articleCount 加1 lastTopic 更新为当前的新主题
		 */
		Forum forum = model.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1); // 主题数量
		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量（主题数+回复数）
		forum.setLastTopic(model); // 最后发表的主题
	}
	
	@Deprecated
	public PageBean getPageByForum(int pageNum, int pageSize, Forum forum) {

		// 查询列表
		List list = getSession().createQuery(//
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC"
				+ ", t.lastUpdateTime DESC")
				.setParameter(0, forum)
				//
				.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
		// 查询总数量
		Long count = (Long) getSession().createQuery(//
				"SELECT count(*) FROM Topic t WHERE t.forum=?")
				.setParameter(0, forum).uniqueResult();

		return new PageBean(pageSize, pageNum, list, count.intValue());
	}

}
