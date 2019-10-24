package com.javainuse.route;

import java.io.IOException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.javainuse.route.MyBean;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//      from("direct:ingest")
////              .bean(MyBean.class, "hello")
//              .log("${body}")
//              .to("seda:saveMessage");
    }
}
