package cn.itcast.oa.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
//struts2 的action 是多例的
@Scope("prototype")
public class ActionTest extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("testAction--->excute");
		return super.execute();
	}
	
	public void say(){
		System.out.println("testAction. ...");
	}

}
