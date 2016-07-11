package com.doc.assistant.local.test;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.doc.assistant.configuration.AppConfiguration;

public class PrintBeans {
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
	public void print(){
		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	}
	
	public static void main(String[] args){
		PrintBeans pb = new PrintBeans();
		pb.print();
	}

}
