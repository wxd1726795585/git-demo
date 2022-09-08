package com.example.demo;

/**
 * static 关键字的使用
 * 
 * 1.static:静态的。
 * 2.static 可以用来修饰:属性、方法、代码块、内部类。
 * 
 * 3.使用 static 修饰属性:静态变量(或类变量)。
 * 		3.1  属性:是否使用 static 修饰，又分为:静态属性 VS 非静态属性(实例变量)
 * 		   实例变量:我们创建了类的多个对象，每个对象都独立的拥有了一套类中的非静态属性。
 * 				当修改其中一个非静态属性时，不会导致其他对象中同样的属性值的修饰。
 * 		   静态变量:我们创建了类的多个对象，多个对象共享同一个静态变量。当通过静态变量去修改某一个变量时，
 * 				会导致其他对象调用此静态变量时，是修改过的。
 * 		3.2 static 修饰属性的其他说明:
 * 			① 静态变量随着类的加载而加载。可以通过"类.静态变量"的方式进行调用。
 * 			② 静态变量的加载要早于对象的创建。
 * 			③ 由于类只会加载一次，则静态变量在内存中也只会存在一次。存在方法区的静态域中。
 * 
 * 			④ 		类变量		实例变量
 * 			类		yes			no
 * 			对象		yes			yes
 * 
 * 		3.3 静态属性举例:System.out.Math.PI;
 *  
 */
public class StaticTest {
	public static void main(String[] args) {
		
		Chinese.nation = "中国";
		
		Chinese c1 = new Chinese();
		c1.name = "姚明";
		c1.age = 40;
		c1.nation = "CHN";
		
		Chinese c2 = new Chinese();
		c2.name = "马龙";
		c2.age = 30;
		c2.nation = "CHINA";
		
		System.out.println(c1.nation); 
		
		//编译不通过
//		Chinese.name = "张继科";
		
	}
}
//中国人
class Chinese{
	
	String name;
	int age;
	static String nation;
}
