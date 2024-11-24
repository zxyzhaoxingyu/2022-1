package com.homework;

public class HomeWork04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1(new Counter() {
			public void work() {
				System.out.println("cellphone正在工作...");
			}
		});
		new CellPhone() {
			
		}.testWork();
	}

	public static void f1(Counter counter) {
		counter.work();
	}
}

interface Counter {
	void work();
}

class CellPhone implements Counter {
	@Override
	public void work() {
		System.out.println("cellphone正在工作");
	}
	
	public void testWork() {
		System.out.println("cellphone正在检查工作");
	}
}
