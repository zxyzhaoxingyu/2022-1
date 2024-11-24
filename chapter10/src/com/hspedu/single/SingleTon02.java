package com.hspedu.single;

// 单例模式-懒汉式
public class SingleTon02 {
    public static void main(String[] args) {
        Cat instance = Cat.getCat();
        System.out.println(instance);
    }
}

class Cat {
    private String name;

    //1.将构造器私有化
    private Cat(String name) {
        this.name = name;
    }

    //2. 定义一个静态属性对象
    private static Cat cat;

    //3.创建一个static方法返回Cat对象
    public static Cat getCat() {
        if (cat == null) {
            cat = new Cat("cat");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
