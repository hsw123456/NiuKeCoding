package cn.itcast.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.Type;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.QueryHelper;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	// 接收页面传过来的参数
	/**
	 * 0： 表示查看全部主题 
	 * 1：表示查看精华帖
	 */
	private int viewType = 0;
	/**
	 * 0： 表示默认排序（所有置顶帖在前面，并按照最后更新时间降序排列） 
	 * 1：表示只按照最后更新时间降序排列 
	 * 2:只按主题发表时间排序
	 * 3:表示只按主题回复数量排序
	 */
	private int orderBy = 0;
	/*
	 * false: 表示降序 ture: 表示升序
	 */
	private boolean asc = false;

	/**
	 * 板块列表
	 * 
	 * @return
	 */
	public String list() {

		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	/*
	 * 单个板块显示(主题列表)
	 */
	public String show() {
		// 通过id获取相应的板块
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);

		// 准备主题列表，考虑到要进行分页及排序，这里不适用getTopics方法
		// List<Topic> topicList = topicService.findByForum(forum);
		// ActionContext.getContext().put("topicList", topicList);
		//
		// //准备分页信息v1
		// PageBean pageBean =
		// topicService.getPageByForum(pageNum,pageSize,forum);
		// ActionContext.getContext().getValueStack().push(pageBean);

//		// 准备分页信息v2
//		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC"
//				+ ", t.lastUpdateTime DESC";
//		List<Object> parameters = new ArrayList<Object>();
//		parameters.add(forum);
//		PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql,
//				parameters);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 准备分页信息v3
		/*String hql = "FROM Topic t WHERE t.forum=? " ;
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(forum);
		
			if(viewType == 1){//1.表示只看精华帖
				hql += " AND  t.type=? ";
				parameters.add(Topic.TYPE_BEST);
				
			}
			
			if(orderBy == 1){
				hql += " ORDER BY t.lastUpdateTime " + (asc? "ASC":"DESC");
				
			}else if(orderBy == 2){
				hql += " ORDER BY t.postTime "+ (asc? "ASC":"DESC");
			}else if(orderBy == 3){
				hql += " ORDER BY t.replyCount "+ (asc? "ASC":"DESC");
			}else{
				hql += " ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
			}
		
		PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql,
				parameters);
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
	// 准备分页信息v4
		
		QueryHelper queryHelper = new QueryHelper(Topic.class, "t")

		// //过滤条件
		.addCondition("t.forum=?", forum)
		.addCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST)
		// 1.表示只看精华帖

		// 排序条件
		.addOrderProperty((orderBy == 1), "t.lastUpdateTime", asc)
		.addOrderProperty((orderBy == 2), "t.postTime", asc)
		.addOrderProperty((orderBy == 3), "t.replyCount", asc)
		.addOrderProperty((orderBy == 0),"(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)
		.addOrderProperty((orderBy == 0), "t.lastUpdateTime", false);
		
		PageBean pageBean = topicService.getPageBean(pageNum, pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		

		return "show";
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

}
