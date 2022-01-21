package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.CurrencyConverter;
import com.cdac.component.HelloWorld;
import com.cdac.component.TextEditor;



public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");

		HelloWorld h = (HelloWorld) ctx.getBean("hw");
		System.out.println(h.SayHello("Dnyaneshwar"));
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		CurrencyConverter currConv = (CurrencyConverter) ctx.getBean("cc");
		System.out.println(currConv.convert("USD", "INR", 75));
		
		TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
		te.loadDocument("abc.txt");
		
		
}
}