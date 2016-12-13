package cn.itcast.oa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ReplyService;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

	public List<Reply> findByTopic(Topic topic) {
		return getSession().createQuery(//
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC ")//
				.setParameter(0, topic)
				.list();
	}
	
	@Override
	public void save(Reply reply) {
		
		//保存
		getSession().save(reply);
		//维护相关的信息
		/**
		 * 	articleCount	加1	加1
			lastTopic	更新为当前的新主题	
			replyCount	0，默认值	加1
			lastReply	Null，默认值	更新为当前的新回复
			lastUpdateTime	主题的发表时间	更新为当前新回复的时间

		 */
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		
		forum.setArticleCount(forum.getArticleCount()+1);
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		
		getSession().update(topic);
		getSession().update(forum);
	}
	
	@Deprecated
	public PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic) {
		//查询列表
		List list = getSession().createQuery(//
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")
				.setParameter(0, topic)//
				.setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		//查询总数量
		Long count = (Long) getSession().createQuery(//
				"SELECT count(*) FROM Reply r WHERE r.topic=?")
				.setParameter(0, topic)
				.uniqueResult();
		
		return new PageBean(pageSize, pageNum, list, count.intValue());
	}

}
