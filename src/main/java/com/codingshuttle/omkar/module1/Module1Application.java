package com.codingshuttle.omkar.module1;

import com.codingshuttle.omkar.module1.impl.EmailNotificationService;
import com.codingshuttle.omkar.module1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

    private final CakeBaker cakeBaker;
    final NotificationService notificationserviceobj;    //field dependency injection//not prefered

    @Autowired
    PaymentService paymentserviceobj1;

    @Autowired
    PaymentService paymentserviceobj2;

//    @Autowired


//    public Module1Application(@Qualifier("Emailnotif) NotificationService notificationserviceobj) {
//        this.notificationserviceobj = notificationserviceobj;          //constructor dependency injection// preferred// qualifier used
//    }

    public Module1Application(NotificationService notificationserviceobj, CakeBaker cakeBaker) {
        this.notificationserviceobj = notificationserviceobj;          //constructor dependency injection// preferred// conditional on property used
        this.cakeBaker = cakeBaker;
    }

    public static void main(String[] args) {

        SpringApplication.run(Module1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        notificationserviceobj.send("hello");
        cakeBaker.bakeCake();

        //not the springboot way
//        NotificationService notiservice = new EmailNotificationService();
//        notiservice.send("hello");

//        System.out.println(paymentserviceobj1.hashCode());
//        System.out.println(paymentserviceobj2.hashCode());
//        paymentserviceobj1.pay();
//        paymentserviceobj2.pay();
    }
}
