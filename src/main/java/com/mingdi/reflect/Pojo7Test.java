package com.mingdi.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Pojo7Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Pojo7 p = new Pojo7();
        p.printName();
        Field nameField = p.getClass().getDeclaredField("name");
        nameField.setAccessible(true);


        Field modifiers = nameField.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

        nameField.set(p, new StringBuilder("111"));
        // modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
        p.printName();
    }
}

