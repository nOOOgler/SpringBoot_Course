package com.codingshuttle.omkar.module1.impl;

import com.codingshuttle.omkar.module1.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberrysyrup")
public class StrawberrySyrup implements Syrup {
    @Override
    public String SyrupType() {
        return "Strawberry syrup";
    }
}
