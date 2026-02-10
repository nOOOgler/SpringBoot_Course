package com.codingshuttle.omkar.module1.impl;

import com.codingshuttle.omkar.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary                               //if after using qualifier still ambiguous, one with primary will be used
@Component
@Qualifier("Smsnotif")                  //if 2 beans are present of same type, we can give qualifier
@ConditionalOnProperty(name = "notification.type", havingValue = "sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sms sending "+ message);

    }
}
