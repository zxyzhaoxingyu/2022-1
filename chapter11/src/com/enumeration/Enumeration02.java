package com.enumeration;

public class Enumeration02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//使用enum关键字来实现枚举类
//枚举类可以实现接口，但不可以继承别的类，因为java是单继承机制，枚举类自己本身就已经隐式继承了Enum类
enum Season2{
	
//	 
//	public final static Season SPRING = new Season("春天","温暖");
//	public final static Season SUMMER = new Season("夏天","炎热");
//	public final static Season AUTUMN = new Season("秋天","凉爽");
//	public final static Season WINTER = new Season("冬天","寒冷");
	/*
	 * 1.使用enum取代class
	 * 2.public final static Season SPRING = new Season("春天","温暖")直接使用SPRING("春天","温暖")，解读  常量名（实参列表）
	 * 3.如果有多个常量（对象），使用 ，间隔即可
	 * 4.如果使用enum来实现枚举，要求将定义常量对象写在前面
	 * 5.如果使用的是无参构造器创建常量对象，则可以省略（）
	 */
	SPRING("春天","温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
	
	private String name;
	private String desc;
	
	private Season2(String name,String desc) {
		this.name=name;
		this.desc=desc;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
}
