package com.atguigu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * 静态工厂方法：直接调用某个类的静态方法就可以返回Bean 的实例
 */
public class StaticCarFactory {
	
	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static{
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
	}
	
	public static Car getCar(String name){
		
		return  cars.get(name);
	}

}
