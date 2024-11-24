package com.hspedu.InnerClass;
//匿名内部类的使用

/**
 * 1.本质是类
 * 2.内部类
 * 3.该类没有名字
 * 4。同时还是一个对象
 * 5.如果外部类和匿名内部类的成员重名，匿名内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用（外部类.this.成员）去访问
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.method();

    }
}

class Outer01{//外部类
    private  int n1=100;
    public void method(){
        /*基于接口的匿名内部类
        1.需求，想使用IA接口，并创建对象
        2.传统方式是写一个类，实现该接口并创建对象
        3.需求是Tiger/Dog类只是使用一次，后面再不使用
        4.可以使用匿名内部类来简化开发
        5.Tiger的编译类型是接口IA类型
        6.Tiger的运行类型是此匿名内部类 Outer01$1
        7.jdk底层在创建匿名内部类Outer01$1，立即马上创建了Outer01$1实例，并且把地址返回给tiger
        8.匿名内部类使用一次就不能再使用(但是已经创建好的实例可以被无限调用，比如下面创建的匿名内部类实例tiger就可以无限使用cry方法)
         */
        IA tiger =new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫。。。");
            }
        };
        tiger.cry();
        tiger.cry();
        tiger.cry();

        /*基于类的匿名内部类
        1.father 编译类型Father
        2.father 运行类型匿名内部类Outer01$2
        3.底层会创建匿名内部类
        4.同时也返回了匿名内部类Outer01$2的实例
        5.注意（"jack"）参数列表会传递给Father的构造器
         */
        Father father = new Father("jack"){
            //可以访问外部类的所有成员，包括私有的
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();
        //  可以直接调用
        new Father("tom") {
            @Override
            public void test() {
                System.out.println("tom的匿名内部类");
            }
        }.test();

        /*基于抽象类的匿名内部类
         */
        Animal animal = new Animal(){
            @Override
            void eat() {
                System.out.println("狗吃骨头");
            }
        };
        animal.eat();
    }
}
interface IA{
    void cry();
}

class Father{
    private String name;
    public Father(String name) {
        System.out.println("father的name="+name);
    }

    public void test(){
    }
}

abstract class Animal{
    abstract void eat();
}
