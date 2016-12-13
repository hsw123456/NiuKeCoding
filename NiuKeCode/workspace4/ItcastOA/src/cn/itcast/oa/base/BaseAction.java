package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.service.ForumService;
import cn.itcast.oa.service.PrivilegeService;
import cn.itcast.oa.service.ReplyService;
import cn.itcast.oa.service.RoleService;
import cn.itcast.oa.service.TopicService;
import cn.itcast.oa.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	
	protected T model= null ;
	
	public BaseAction(){
		try {
			
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	
//==================支持modelDriven===========================
	public T getModel() {
		return model;
	}
//==================封装service声明===========================
	@Autowired
	protected RoleService roleService;
	@Autowired
	protected DepartmentService departmentService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected PrivilegeService privilegeService;
	@Autowired
	protected ForumService forumService;
	
	@Autowired
	protected TopicService topicService;
	@Autowired
	protected ReplyService replyService;
	
	/**
	 * 获取当前登录的用户
	 * @return
	 */
	protected User  getCorrentUser(){
		return  (User) ActionContext.getContext().getSession().get("user");
	}
	
	//========分页用的参数====================================

		protected int pageNum =1;//当前页
		protected int pageSize =10;//每页显示的记录数
		

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		
		
	

}
