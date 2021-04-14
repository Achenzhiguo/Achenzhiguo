package com.czg.string.com.czg.mapper.impl;

import com.czg.string.com.czg.mapper.Flyable;

public class Plain extends M implements Flyable {
    @Override
    public void fly() {
        System.out.println("我是飞机,我可以飞飞飞飞------");
    }
}
