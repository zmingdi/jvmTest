package com.mingdi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InnerLineTest {


    public static void main(String[] args) throws NoSuchMethodException {
        Constructor<?>[] cs = InnerLine.class.getConstructors();
        Constructor<InnerLineB> cm = Constructor.setAccessible(true);
        for(Constructor c : cs) {
            c = m;

        }
    }
    public InnerLine create() {
        System.out.println("hahaha");
        return new InnerLine();
    }
}
class InnerLineB extends InnerLine{
    public InnerLineB() {
        System.out.println("haha B");
    }
}
class InnerLine{

    public InnerLine() {

    }
    public void sayHello() {
        String name="john";

        System.out.println(name);
    }
}
