package com.tutorial.inheritance.intfmethodoverride;

public interface IFlyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}