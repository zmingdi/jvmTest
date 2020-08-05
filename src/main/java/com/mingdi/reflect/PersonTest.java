package com.mingdi.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * reflect injection test, following condition not working
 * 1. use openJDK,
 * 2. static object initialized in heap constant pool (or to say primative type)
 *
 * Use jdk 1.8.261 works
 */
public class PersonTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //Person p = new Person();
        Person.whereFrom();
        Field f = Person.class.getDeclaredField("from");
        f.setAccessible(true);

        Field modifiers = f.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);

        f.set(Person.class,"euro");
        Person.whereFrom();
    }
}
class Person {
    public static final String from = new String("asia");
    public static void whereFrom(){
        System.out.println(from);
    }
}
