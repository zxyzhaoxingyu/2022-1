package com.homework;

public class HomeWork05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person tang = new Person("唐僧",VehicleFactory.getHorse());
		tang.common();
		tang.passRiver();
		tang.passFireMountain();
		tang.passRiver();

	}

}
interface Vehicle {
	void work();
}

class Horse implements Vehicle{
	public void work() {
		System.out.println("上马！ ");
	}
}

class Boat implements Vehicle{
	public void work() {
		System.out.println("上船！ ");
	}
}

class Plane implements Vehicle{
	public void work() {
		System.out.println("上飞机！ ");
	}
}

class VehicleFactory{
	//单例模式，因为唐僧只有一个白龙马
	private static Horse horse = new Horse();
	private VehicleFactory() {
		
	}
	public static Horse getHorse() {
		return horse;
	}
	
	public static Boat getBoat() {
		return new Boat();
	}
	
	public static Plane getPlane() {
		return new Plane();
	}
}

class Person{
	private String name;
	private Vehicle vehicle;
	public Person(String name,Vehicle vehicle) {
		this.name=name;
		this.vehicle=vehicle;
	}
	
	public void common() {
		if(!(vehicle instanceof Horse)) {
			vehicle = VehicleFactory.getHorse();
		}
		vehicle.work();
	}
	
	public void passRiver() {
		if(!(vehicle instanceof Boat)) {
			vehicle = VehicleFactory.getBoat();
		}
		vehicle.work();
	}
	
	public void passFireMountain() {
		if(!(vehicle instanceof Plane)) {
			vehicle = VehicleFactory.getPlane();
		}
		vehicle.work();
	}
}