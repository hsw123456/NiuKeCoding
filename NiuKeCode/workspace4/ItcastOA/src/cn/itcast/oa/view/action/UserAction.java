package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.PageBean;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;
import cn.itcast.oa.util.DepartmentUtils;
import cn.itcast.oa.util.QueryHelper;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	// 用于接收传到服务器的departmentId
	private Long deptId;
	// 接收岗位id可能是多个岗位
	private Long[] roleIds;

	// 列表
	public String list() throws Exception {

		List<User> userlist = userService.findAll();
		ActionContext.getContext().put("userList", userlist);
		
		PageBean pageBean = userService.getPageBean(pageNum, pageSize, 
				new QueryHelper(User.class, "u"));
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// 删除
	public String delete() throws Exception {

		userService.delete(model.getId());
		return "toList";
	}

	// 添加页面
	public String addUI() throws Exception {
		/**
		 * Action都是用来准备数据的，我们需要在saveUI页面转呗，树状的部门列表 还有岗位列表
		 */
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		// 放入值栈的map中
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	// 添加
	public String add() throws Exception {
		// 封装到对象中(当model是实体类时可以使用model但是要填充其他属性)
		// 设置所属部门
		model.setDepartment(departmentService.getById(deptId));

		// 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));

		// 设置默认密码：1234
		// 利用MD5加密算法保存密码
		String md5Digest = DigestUtils.md5Hex("1234");
		model.setPassword(md5Digest);
		userService.save(model);
		return "toList";
	}

	// 修改页面
	public String editUI() throws Exception {
		// 准备数据
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartments(topList);
		// 放入值栈的map中
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);

		if (user.getDepartment() != null) {
			deptId = user.getDepartment().getId();
		}

		if (user.getRoles() != null) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "saveUI";
	}

	// 修改
	public String edit() throws Exception {
		// 1.从数据库中取出原对象
		User user = userService.getById(model.getId());
		// 2.设置要修改的属性
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());

		// 设置所属部门
		user.setDepartment(departmentService.getById(deptId));

		// 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));

		// 3.更新到数据库
		userService.update(user);
		return "toList";
	}

	// 初始化用户密码
	public String initPassword() throws Exception {

		// 1.从数据库中取出原对象
		User user = userService.getById(model.getId());
		// 2.设置要修改的属性(使用Md5加密)
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);

		// 3.更新到数据库
		userService.update(user);
		return "toList";
	}

	// ===============================================

	/* 登录页面 */
	public String loginUI() throws Exception {

		return "loginUI";
	}

	/* 登录 */
	public String login() throws Exception {
		
		//得到用户所填写的登录名和密码
		String loginName = model.getLoginName();
		String password = model.getPassword();
		
		//判断数据库中是否有记录
		User user = userService.findUser(loginName,password);
		if(user !=null){
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}else {
			//显示错误消息
			addFieldError("login", "用户名或密码不正确！");
			//从新转动登录页面
			return "loginUI";
		}

	}

	/* 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	// =================================================================
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

}
