package com.hspedu.codeBlock;

public class CodeBlockDetail1 {
    //    构造器的在最前边隐藏了super（）和普通代码块
    //创建一个对象，在一个类调用顺序是：
    //1.调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级是一样的，
    // 如果有多个静态代码块和静态属性初始化，则按他们定义的顺序调用）
    //2.调用普通代码块和普通属性初始化（注意：普通代码块和普通属性初始化调用的优先级是一样的，
    // 如果有多个普通代码块和普通属性初始化，则按他们定义的顺序调用）
    //3.调用构造方法
    public static void main(String[] args) {
        A a = new A();
        System.out.println("------------------------");
        Dog dog1 = new Dog();

    }
}

class A {
    private int n = getN();//普通属性初始化

    {//普通代码块
        System.out.println("普通代码块被调用 ");
    }

    public int getN() {
        System.out.println("getN被调用 ");
        return 10;
    }

    //静态属性初始化
    public static int vue = getVue();

    //静态代码块
    static {
        System.out.println("A的静态代码块被执行  ");
    }

    //静态方法
    public static int getVue() {
        System.out.println("静态方法getVue被执行");
        return 100;
    }

    public A() {
        System.out.println("A无参构造器被调用");
    }
}

class Animal {
    {
        System.out.println("Animal的普通代码块被调用");
    }

    public Animal() {
        System.out.println("Animal的无参构造器被调用");
    }
}

class Dog extends Animal {
    {
        System.out.println("Dog的普通代码块被调用");
    }

    public Dog() {
        System.out.println("Dog的无参构造器被调用");
    }

}