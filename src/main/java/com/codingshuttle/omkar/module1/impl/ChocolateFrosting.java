package com.codingshuttle.omkar.module1.impl;

import com.codingshuttle.omkar.module1.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolatefrosting")
public class ChocolateFrosting implements Frosting {
    @Override
    public String frostingType() {
        return "Chocolate Frosting";
    }
}
