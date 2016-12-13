package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {

	// 遍历部门树，其中的部门名字修改了，使其显示具有层次
	public static List<Department> getAllDepartments(List<Department> topList) {
		
		List<Department> temp = new ArrayList<Department>();
		loopTreeList(topList, temp,"┣");
		return temp;
		
	}
	
	//遍历部门树，把遍历出的部门信息放入指定temp的集合中
	private static void loopTreeList(Collection<Department> depts,
			List<Department> list,String prefix) {
		
			for (Department dept : depts) {
				
				Department copy = new Department();//使用副本，因为原对象再Session中
				copy.setId(dept.getId());
				copy.setName(prefix +dept.getName());
				// 顶点
				list.add(copy);
				// 子树
				loopTreeList(dept.getChildren(), list,"　"+prefix);//注意在JSp页面上无论有
				//多少空格默认只有一个
			}
	}

}
