package com.codingshuttle.omkar.module1;

import com.codingshuttle.omkar.module1.impl.ChocolateFrosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    final Frosting frosting;
    final Syrup syrup;

    public CakeBaker(@Qualifier("chocolatefrosting") Frosting frosting, @Qualifier("chocolatesyrup") Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Baking cake with");
        System.out.println("frosting:" + frosting.frostingType());
        System.out.println("syrup:" + syrup.SyrupType());
    }

}
