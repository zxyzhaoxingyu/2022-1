package com.hspedu.codeBlock;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Movie {
    private String name;
    private int price;
    private String director;
//static代码块对类进行初始化，它随着类的加载而执行，并且只会执行一次，而普通代码块每创建一个对象就执行一次
//只是用静态成员时，普通代码块不会被调用
//类什么时候被加载

    public static void main(String[] args) {
        //1.创建类的对象实例时
        //BB bb = new BB();
        //2.创建子类的对象实例，父类也会被加载,父类先被加载，子类后被加载
        AA aa = new AA();
        //3.使用类的静态成员时（静态属性，静态方法）
        System.out.println(Cat.name);
    }


    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, int price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }

}

class Cat {
    public static String name="000";

    static {
        System.out.println("Catbeizhixing");
    }
}

class AA extends BB {
    static {
        System.out.println("AAbeizhixing");
    }

}

class BB {
    static {
        System.out.println("BBbeizhixing");
    }
}
