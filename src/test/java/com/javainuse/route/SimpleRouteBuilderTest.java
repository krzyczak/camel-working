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

//    public SimpleRouteBuilderTest() throws Exception {}

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("applicationContext-camel.xml");
    }

    private MockEndpoint mockOut;

    @Before
    public void init() throws Exception {
        mockOut = getMockEndpoint("mock:result");

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("direct:ingest").to(mockOut);
            }
        });

         template.sendBody("direct:ingest", "hello janusz");
    }

    @Test
    public void shouldFilterEpisodeCounter() throws Exception {
        Thread.sleep(2000);
        mockOut.expectedBodiesReceived("some text");
        mockOut.assertIsSatisfied();
    }
}