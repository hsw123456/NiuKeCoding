package cn.itcast.oa.util;

import cn.itcast.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//自定义拦截器
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		/*System.out.println(".....之前");
		//放行
		String result = invocation.invoke();
		System.out.println("......之后");
		
		return result;*/
		
		//获取当前登录的User
		User user = (User) ActionContext.getContext().getSession().get("user");
		//当前url
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace +actionName; //对应的权限url
		
		//如果未登录
		if(user == null){
			//如果是去登录就放行
			if(privUrl.startsWith("/user_login")){//user_login, user_loginUI
				return invocation.invoke();
			}
			//如果不是去登录，就去登录页面
			else {
				return "loginUI";
			}
			
		}
		//如果已登录就判断权限
		else{
			if(user.hasPrivilegeByUrl(privUrl)){
				//如果有权限则放行
				return invocation.invoke();
			}else {
				return "noPrivilegeError";
			}
		}
	}


	

}
