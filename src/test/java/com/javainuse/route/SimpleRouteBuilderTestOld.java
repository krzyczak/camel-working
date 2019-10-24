///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.javainuse.route;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import org.apache.camel.component.mock.MockEndpoint;
//import org.apache.camel.test.spring.CamelSpringTestSupport;
//import org.junit.Test;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author krzyczak
// */
//public class SimpleRouteBuilderTestOld extends CamelSpringTestSupport {
//  
//  @Override
//  protected AbstractApplicationContext createApplicationContext() {
//      // return new ClassPathXmlApplicationContext("/Users/krzyczak/Desktop/camel-working/src/main/resources/applicationContext-camel.xml");
//      AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-camel.xml");
//      return ctx;
//  }
//  
//  public SimpleRouteBuilderTest() {
//  }
//  
//  @BeforeClass
//  public static void setUpClass() {
//  }
//  
//  @AfterClass
//  public static void tearDownClass() {
//  }
//  
//  @Before
//  public void setUp() throws Exception {
//    context.start();
//  }
//  
//  @After
//  public void tearDown() throws Exception {
//    context.stop();
//  }
//  
//  private MockEndpoint mockOut;
//
//  /**
//   * Test of configure method, of class SimpleRouteBuilder.
//   */
//  @Test
//  public void testConfigure() throws Exception {
//    // System.out.println("configure");
//    // SimpleRouteBuilder instance = new SimpleRouteBuilder();
//    // instance.configure();
//    // TODO review the generated test code and remove the default call to fail.
//    // fail("The test case is a prototype.");
//    
//    mockOut = getMockEndpoint("mock:result");
//    
//    context.addRoutes(new RouteBuilder() {
//      public void configure() {
////        from("seda:getToken").transform(constant(tokenResponse));
////        from("seda:redact").transform(constant("redact"));
////        from("seda:abbreviations").transform(constant("abbreviation"));
////        from("seda:spelling").transform(constant("spelling"));
////        from("seda:saveMessage").to("mock:out");
//        from("seda:saveMessage").to(mockOut);
//      }
//    });
//    
//    template.sendBody("direct:in", "this is test");
//    mockOut = getMockEndpoint("mock:out");
//    mockOut.setExpectedMessageCount(1);
//    mockOut.expectedBodiesReceived("MyBean is Cool");
//
//    // assertMockEndpointsSatisfied();
//    mockOut.assertIsSatisfied();
//  }  
//}
