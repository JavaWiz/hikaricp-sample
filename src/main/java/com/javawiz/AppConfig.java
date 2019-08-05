package com.javawiz;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(value = { 
	      @ComponentScan("com.javawiz") 
	    })
public class AppConfig {

}
