package com.hspedu.InnerClass;
/*
匿名内部类的实践
 */
public class AnonymousInnerClassExercise {
    public static void main(String[] args) {
        //当作实参直接传递，简洁高效
        f1(new IB(){
            @Override
            public void test() {
                System.out.println("拍照片");
            }
        });
        //传统方法》》》》硬编码
        f1(new Picture());
    }

    public static void f1(IB ib){

    }
}
interface IB{
    void test();
}

class Picture implements IB{
    @Override
    public void test() {
        System.out.println("拍照片");
    }


}