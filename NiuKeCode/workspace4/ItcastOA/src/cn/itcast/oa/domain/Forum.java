package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 板块管理的实体类
 * 
 * @author Administrator
 * 
 */
public class Forum {

	private Long id;
	private String name;
	private String description;

	private int position;// 用于排序时的位置索引
	public Set<Topic> topics = new HashSet<Topic>();
	public int topicCount;// 主题数量
	public int articleCount;// 文章数量（主题数+回复数）
	public Topic lastTopic;// 最后发表的主题

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public Topic getLastTopic() {
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}

}
