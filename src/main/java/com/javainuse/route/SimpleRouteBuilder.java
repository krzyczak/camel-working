package com.javainuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:experiments/?noop=true&fileName=in.txt")
            .setHeader(Exchange.HTTP_METHOD, simple("GET"))
            .log("Janus")
            .to("http://ip.jsontest.com").process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    // String data = " | " + exchange.getIn().getBody(String.class);
                    data += " | " + exchange.getIn().getBody(String.class);
                    data += "\n";

                    exchange.getIn().setBody(data);
                }
            }).to("file:experiments/?fileName=out.txt&fileExist=Append")
            .log("\n\n------------ DONE ----------------------\n\n");
    }

}
