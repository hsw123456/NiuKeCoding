package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope(value="prototype")
public class RoleAction extends BaseAction<Role> {
/*	private Long id;
	private String name;
	private String description;*/
	
	private Long[] privilegeIds;
	
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	//列表
	public String list() throws Exception{
		
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
				
		return "list";
	}
	
	//删除
	public String delete() throws Exception{
		roleService.delete(model.getId());
		return "toList";
	}
	
	//添加页面
	public String addUI() throws Exception{
		return "saveUI";
	}
	
	//添加
	public String add() throws Exception{
		/*Role role = new Role();
		role.setName(name);
		role.setDescription(description);*/
		roleService.save(model);
		return "toList";
	}
	
	//修改页面
	public String editUI() throws Exception{
		//准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	//修改
	public String edit() throws Exception{
		/*Role role = roleService.getById(id);
		role.setName(name);
		role.setDescription(description);*/
		
		roleService.update(model);
		return "toList";
	}
	
	//设置权限页面
	public String setPrivilegeUI() throws Exception{
		
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		if(role.getPrivileges() != null){
			privilegeIds = new Long[role.getPrivileges().size()];
			int index = 0;
			for(Privilege priv: role.getPrivileges()){
				privilegeIds[index++] = priv.getId();
			}
		}
		
		//准备数据：所有权限列表
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "setPrivilegeUI";
	}
	
	//设置权限
	public String setPrivilege() throws Exception{
		
		//设置关联的权限
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		
		Role role = roleService.getById(model.getId());
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		roleService.update(role);
		return "toList";
	}




}
