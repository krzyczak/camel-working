package com.javainuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("\n\n\n---------------------------------\n\n\n");
        System.out.println(exchange.getIn().getBody(String.class));
        System.out.println("\n\n\n---------------------------------\n\n\n");
    }

}
