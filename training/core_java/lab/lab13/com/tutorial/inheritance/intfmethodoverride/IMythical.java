package com.tutorial.inheritance.intfmethodoverride;
public interface IMythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}