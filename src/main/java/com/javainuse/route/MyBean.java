/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.route;

import org.apache.camel.Exchange;

class MyBean {
  private static final String text = "MyBean is Cool";

  public static void hello(Exchange exchange) {
      System.out.println("Isinde bean");
      System.out.println(text);
      String input = exchange.getIn().getBody(String.class);
      exchange.getOut().setBody(text + "  -  " + input);
  }
}
