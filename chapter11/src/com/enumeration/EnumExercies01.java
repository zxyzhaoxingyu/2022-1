package com.enumeration;

public class EnumExercies01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===所有星期的信息如下===");
		Week[] weeks=Week.values();
		for(Week week:weeks) {
			System.out.println(week);
		}

	}

}
enum Week{
	MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THRUSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
	private String name;
	
	private Week(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return name;
	}
}
