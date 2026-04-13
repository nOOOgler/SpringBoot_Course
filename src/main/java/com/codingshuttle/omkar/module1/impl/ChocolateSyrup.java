package com.codingshuttle.omkar.module1.impl;

import com.codingshuttle.omkar.module1.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolatesyrup")
public class ChocolateSyrup implements Syrup {
    @Override
    public String SyrupType() {
        return "Chocolate Syrup";
    }
}
