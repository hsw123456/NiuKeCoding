package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic extends Article {
	/**普通帖*/
	public static final int TYPE_NORMAL = 0;
	/**精华帖*/
	public static final int TYPE_BEST = 1;
	/**置顶帖*/
	public static final int TYPE_TOP = 2;

	private int type;// 主题类型： 置顶， 精华， 普通
	private int replyCount; // 记录回复数
	private Reply lastReply;// 记录最后那条回复
	private Date lastUpdateTime;
	private Set<Reply> replies = new HashSet<Reply>();// 关联的回复

	private Forum forum;// 所属的板块

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	

}
