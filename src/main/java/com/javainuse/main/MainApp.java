package com.javainuse.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-camel.xml");
        ctx.start();
        System.out.println("Application context started");
        try {
            // Thread.sleep(5 * 60 * 1000);
            System.out.println("Wating 5s...");
            Thread.sleep(5000);
            System.out.println("Done Wating. Exiting.");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.stop();
        ctx.close();
    }
}
