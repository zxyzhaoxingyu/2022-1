package com.hspedu.InnerClass;

public class AnonymousInnerClassExercise02 {
    public static void main(String[] args) {

        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });

        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class CellPhone implements Bell {
    public void ring() {
        System.out.println("懒猪起床了");
    }

    public void alarmClock(Bell bell) {
        bell.ring();
    }
}