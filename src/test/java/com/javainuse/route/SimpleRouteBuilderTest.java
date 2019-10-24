package com.javainuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
//import org.apache.http.HttpEntity;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.FormBodyPart;
//import org.apache.http.entity.mime.FormBodyPartBuilder;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.ByteArrayBody;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SimpleRouteBuilderTest<test> extends CamelSpringTestSupport {

    public SimpleRouteBuilderTest() throws Exception {}

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("applicationContext-camel.xml");
    }

    private String tokenResponse = "<html>\n" +
            "<head>\n" +
            " <title>Upload Processed Training Set Data</title>\n" +
            "</head>\n" +
            "<body>\n" +
            " <p>Please upload Processed Training Set Data</p>\n" +
            " <form id=“uploadform” enctype=“multipart/form-data” action=“/up/ts” method=“post”>\n" +
            "   <input type=“file” name=“test_file” />\n" +
            "   <input type=“hidden” id=“token” name=“token” value=“{9dd5a30ce06665ba52b29586501e4479}“/>\n" +
            "   <input type=“submit” value=“upload” />\n" +
            " </form>\n" +
            "</body>\n" +
            "</html>";

    private MockEndpoint mockOut;

    @Before
    public void init() throws Exception {
        mockOut = getMockEndpoint("mock:result");

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                // from("seda:getToken").transform(constant(tokenResponse));
                // from("seda:redact").transform(constant("redact"));
                // from("seda:abbreviations").transform(constant("abbreviation"));
                // from("seda:spelling").transform(constant("spelling"));
                // from("seda:saveMessage")
                //         .bean(MultipartParser.class, "parse")
                //         .to(mockOut);
                from("seda:saveMessage").to(mockOut);
            }
        });

        // requestEntity = setUpMultipartForm();
        // template.sendBody("direct:ingest", requestEntity.getContent());
         template.sendBody("direct:ingest", "requestEntity.getContent()");
    }

    @Test
    public void shouldFilterEpisodeCounter() throws Exception {
        Thread.sleep(1000);
//        mockOut.expects(new Runnable() {
//            public void run() {
//                String expectedResponse="1";
//                List response = getResponseAsList((String) mockOut.getExchanges().get(0).getIn().getBody());
//                for (int i = 0; i < response.size(); i++) {
//                    HashMap hashMap = (HashMap) response.get(i);
//                    String trueValueEpisodeCounter = (String) hashMap.get("episode_counter");
//                    assertEquals(expectedResponse, trueValueEpisodeCounter);
//                }
//            }
//        });
        mockOut.expectedBodiesReceived("some text");
        mockOut.assertIsSatisfied();
    }
}