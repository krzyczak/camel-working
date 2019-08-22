package com.javainuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

// import com.javainuse.model.Employee;
// import com.javainuse.processor.CreateEmployeeProcessor;
// import com.javainuse.processor.MyProcessor;
import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleRouteBuilder extends RouteBuilder {

    // JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

    @Override
    public void configure() throws Exception {

        // // route for REST GET Call
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
            // .process(new MyProcessor());

        // from("file:experiments/?noop=true&fileName=in.txt")
        //     .convertBodyTo(String.class)
        //     .log("\n\n------------------------------------\n\n")
        //     .log("Read from the input file")
        //     .to("file:experiments/?fileName=out.txt")
        //     .log("Written to output file")
        //     .log("\n\n------------------------------------\n\n")
        //     .end();

        // // route to read a file and save in another file
        // from("file:experiments/?noop=true&fileName=in.txt").process(new Processor() {
        //     @Override
        //     public void process(Exchange exchange) throws Exception {
        //         Object fileName = exchange.getIn().getHeader("CamelFileName");
        //         exchange.getIn().setBody(fileName+"\n");
        //         System.out.println(fileName);
        //     }
        // }).to("file:experiments/?fileName=out.txt&fileExist=Append")
        // .log("\n\n------------ DONE ----------------------\n\n");

        // .marshal(jsonDataFormat)
        //     .setHeader(Exchange.HTTP_METHOD, simple("POST"))
        //     .setHeader(Exchange.CONTENT_TYPE, constant("application/json")).to("http://dummy.restapiexample.com/api/v1/employees")
        //     .process(new MyProcessor());
    }

}
