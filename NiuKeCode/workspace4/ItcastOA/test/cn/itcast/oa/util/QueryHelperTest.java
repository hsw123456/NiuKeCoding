package cn.itcast.oa.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

public class QueryHelperTest {

	// 接收页面传过来的参数
	/**
	 * 0： 表示查看全部主题 1：表示查看精华帖
	 */
	private int viewType = 0;
	/**
	 * 0： 表示默认排序（所有置顶帖在前面，并按照最后更新时间降序排列） 1：表示只按照最后更新时间降序排列 2:只按主题发表时间排序
	 * 3:表示只按主题回复数量排序
	 */
	private int orderBy = 0;
	/*
	 * false: 表示降序 true: 表示升序
	 */
	private boolean asc = false;

	private Forum forum = new Forum();

	@Test
	public void testQueryHelper() {

		// 准备分页信息v3
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(forum);
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

		System.out.println(queryHelper.getListQueryHql());
		System.out.println(queryHelper.getCountQueryHql());
		System.out.println(queryHelper.getParameters());

	}

}
