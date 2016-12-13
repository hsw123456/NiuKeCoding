package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.QueryHelper;

public interface TopicService extends DaoSupport<Topic> {
	
	/**
	 * 查询指定板块的所有主题(默认排序：所有置顶帖在前面，并按最后跟新的时间降序排序)
	 * @param forum
	 * @return
	 */
	@Deprecated
	List<Topic> findByForum(Forum forum);
	
	/**
	 * 查询分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param forum
	 * @return
	 */

	PageBean getPageByForum(int pageNum, int pageSize, Forum forum);

	
	


}
