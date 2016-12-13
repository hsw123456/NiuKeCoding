package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
		//接收传递过来的数据
		private Long parentId;
		
		
		public Long getParentId() {
			return parentId;
		} 
		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}
		
		//列表
		public String list() throws Exception {
			
			List<Department> departmentList = null;
			if(parentId == null){
				departmentList = departmentService.findTopList();
			}else {
				departmentList = departmentService.findChildren(parentId);
				//准备上级部门并放入到Map中
				Department parent = departmentService.getById(parentId);
				ActionContext.getContext().put("parent", parent);
			}
			ActionContext.getContext().put("departmentList", departmentList);
			return "list";
		}
	
		//删除
		public String delete() throws Exception {
			departmentService.delete(model.getId());
			return "toList";
		}
		
		//添加页面
		public String addUI() throws Exception {
			//准备显示上级部门的数据
			//为了显示层次化的结构，这里通过遍历顶部节点，为每个子节点
			//重新设计名字
			List<Department> topList = departmentService.findTopList();
			List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
			//放入值栈的map中
			ActionContext.getContext().put("departmentList", departmentList);
			return "saveUI";
		}
		
		//添加
		public String add() throws Exception {
			//封装信息到对象中，包括关联的子，父部门
			Department parentDepartment = departmentService.getById(parentId);
			model.setParent(parentDepartment);
			
			//保存
			departmentService.save(model);
			return "toList";
		}
		
		//修改页面
		public String editUI() throws Exception {
			//准备显示上级部门的数据
			List<Department> departmentList = departmentService.findAll();
			//放入值栈的map中
			ActionContext.getContext().put("departmentList", departmentList);
			
			Department department = departmentService.getById(model.getId());
			ActionContext.getContext().getValueStack().push(department);
			//回显上级部门
			if(department.getParent() !=null){
				parentId = department.getParent().getId();
			}
			
			return "saveUI";
		}
		
		//修改
		public String edit() throws Exception {
			Department department = departmentService.getById(model.getId());
			department.setName(model.getName());
			department.setDescription(model.getDescription());
			department.setParent(departmentService.getById(parentId));//设置所属的上级部门
			
			departmentService.update(department);
			return "toList";
		}

		
		

}
