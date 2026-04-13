package com.codingshuttle.omkar.module1.impl;

import com.codingshuttle.omkar.module1.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberryfrosting")
public class StrawberryFrosting implements Frosting {

    @Override
    public String frostingType() {
        return "Strawberry Frosting";
    }
}
