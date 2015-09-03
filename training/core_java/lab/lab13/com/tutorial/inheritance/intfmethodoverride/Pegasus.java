package com.tutorial.inheritance.intfmethodoverride;
public class Pegasus extends Horse implements IFlyer, IMythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}