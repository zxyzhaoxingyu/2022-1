package com.hspedu.codeBlock;

public class CodeBlockDetail2 {
    //静态代码块只能调用静态属性和静态方法，普通代码块可以调用任意成员
    //创建一个子类对象时（继承关系），他们的静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序如下：
    //1.父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
    //2.子类的静态代码块和静态属性（优先级一样，按定义顺序执行）
    //3.父类的普通代码块和普通属性（优先级一样，按定义顺序执行）
    //4.父类的构造方法
    //5.子类的普通代码块和普通属性（优先级一样，按定义顺序执行）
    //6.子类的构造方法
    public static void main(String[] args) {
        BBB bbb = new BBB();
//1.进行类加载
// 2.创建类对象
        //（1）执行子类无参构造器中的super（）
        //（2）执行父类的普通代码块和普通属性初始化
        //（3）执行父类的无参构造器
        //（4）执行子类的普通代码块和普通属性初始化
        //（5）执行子类的无参构造器
    }
}
class AAA{
    public static int n1=getN1();
    public static int getN1(){
        System.out.println("AAA的静态属性初始化被调用");
        return 1;
    }

    static {
        System.out.println("AAA的静态代码块被调用");
    }

    private int n2=getN2();
    public  int getN2(){
        System.out.println("AAA的普通属性初始化被调用 ");
        return 2;
    }

    {
        System.out.println("AAA的普通代码块被调用");
    }

    public AAA() {
        //隐藏了
        // super（）这里super（）是Object类，所以不显示
        // 普通代码块
        System.out.println("AAA的无参构造器被调用");
    }
}
class BBB extends AAA{
    public static int n3=getN3();
    public static int getN3(){
        System.out.println("BBB的静态属性初始化被调用");
        return 1;
    }

    static {
        System.out.println("BBB的静态代码块被调用");
    }

    private int n4=getN4();
    public  int getN4(){
        System.out.println("BBB的普通属性初始化被调用 ");
        return 2;
    }

    {
        System.out.println("BBB的普通代码块被调用");
    }

    public BBB() {
        //隐藏了
        // super（）
        // 普通代码块
        System.out.println("BBB的无参构造器被调用");
    }

}