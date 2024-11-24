package com.enumeration;

public class Enumeration01 {

	//自定义枚举类
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//1.将构造器私有化，防止直接new
/*
*2.去掉set方法，防止属性被修改
*3.在Season内部直接创建对象
*4.优化可以加入final修饰符
*final修饰的一般全部用大写
*/
class Season{
	private String name;
	private String desc;
	 
	public final static Season SPRING = new Season("春天","温暖");
	public final static Season SUMMER = new Season("夏天","炎热");
	public final static Season AUTUMN = new Season("秋天","凉爽");
	public final static Season WINTER = new Season("冬天","寒冷");
	
	private Season(String name,String desc) {
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