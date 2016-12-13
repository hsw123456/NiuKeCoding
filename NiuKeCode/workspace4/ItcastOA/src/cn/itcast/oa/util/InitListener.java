package cn.itcast.oa.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

//用于监听application域
public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		// 获取容器与相关的service对象
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext());

		PrivilegeService privilegeService = ac.getBean(PrivilegeService.class);

		List<Privilege> topPrivilegeList = privilegeService.findTopList();

		sce.getServletContext().setAttribute("topPrivilegeList",
				topPrivilegeList);

		System.out.println("=======>>已经准备数据<<==========");
		
		//准备allPrivileges
		Collection<String> allPrivilegeUrl = privilegeService.getAllPrivileges();
		sce.getServletContext().setAttribute("allPrivilegeUrl",
				allPrivilegeUrl);
		
		System.out.println("=======>>已经准备数据<<==========");

	}

}
