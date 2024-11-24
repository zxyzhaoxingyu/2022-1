package com.homework;

public class HomeWork07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car benci = new Car("奔驰", 39);
		benci.test();
		Car bwm = new Car("宝马", -1);
		bwm.test();
		Car byd = new Car("比亚迪", 46);
		byd.test();
		Car zeeker = new Car("极客", 5);
		zeeker.test();
	}

}

class Car {
	private String name;
	private double temperature;

	public Car(String name, double temperature) {
		this.name = name;
		this.temperature = temperature;
	}

	public void test() {
		Air air = new Air();
		air.flow();
	}

	class Air {
		public Air() {
			turnOn();
		}

		public void turnOn() {
			System.out.println(name+"空调已开启");
		}

		public void turnOff() {
			System.out.println(name+"空调已关闭");
		}

		public void flow() {
			if (temperature < 0) {
				System.out.println(name+"吹暖风 ~");
			} else if (temperature > 40) {
				System.out.println(name+"吹冷风 ~");
			} else {
				turnOff();
			}
		}
	}
}
