package com.example.webdemo.knowledge;

public class singleton {
    private static singleton singleton1 = new singleton();

    // 私有的构造方法,饿汉式
    private singleton() {
    }

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static singleton getSingleton1() {
        return singleton1;
    }
}
