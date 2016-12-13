package cn.itcast.oa.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.QueryHelper;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{
	
	private Long forumId;
	
	/*
	 * 显示单个主题(主帖和回帖列表)
	 */
	public String show(){
		//准备数据
		//1.准备相应的主题
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		//2.准备主题对应的回复列表
		
//		List<Reply> replyList = replyService.findByTopic(topic);
//		ActionContext.getContext().put("replyList", replyList);
		
//		//准备分页信息v1
//		PageBean pageBean = replyService.getPageBeanByTopic(pageNum,pageSize,topic);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		
		//准备分页信息最终版
		QueryHelper queryHelper = new QueryHelper(Reply.class, "r")
		.addCondition("r.topic=?", topic)
		.addOrderProperty("postTime", false);	
		
		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "show";
	}
	
	/**发表新主题页面*/
	public String addUI(){
		//准备数据
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	
	
	//发表新主题
	public String add(){
		/**封装数据*/
		//-->>表单参数已经封装了title, Content;
		//model.setContent(content);
		//model.setTitle(title);
		model.setForum(forumService.getById(forumId));
		
		//-->>当前页面能获取到的数据
		model.setAuthor(getCorrentUser());//当前登录用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());//当前请求的ip
		model.setPostTime(new Date());//当前发布主题时间
		//保存
		topicService.save(model);
		return "toShow";//转到新主题内容显示页面
	}

	//====================================
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	

	
	
	
	

}
