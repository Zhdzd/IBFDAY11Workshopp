package com.example.Day11Workshop;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class Day11WorkshopApplication {
	//Instantiate the logger
	private static final Logger logger = LoggerFactory.getLogger(Day11WorkshopApplication.class);
	private static final String DEFAULT_PORT ="8080";
	public static void main(String[] args) {
		logger.info("Workshop 11");
		//init the spring app
		SpringApplication app = new SpringApplication(Day11WorkshopApplication.class);
		//decode the java app args using spring args helper
		DefaultApplicationArguments appArgs = 
			new DefaultApplicationArguments(args);
			//return the args from the java args as list of strings
		List optsVal =  appArgs.getOptionValues("port");
		//var to hold up the port number to be pass onto the spring boot app
		String portNumber = null;
		//check 
		if(optsVal == null || optsVal.get(0) == null){
				portNumber = System.getenv("PORT");
				if(portNumber == null)
					portNumber = DEFAULT_PORT;
		}else{
			portNumber =(String)optsVal.get(0);
			
		}
		if(portNumber != null){
				app.setDefaultProperties(
					Collections.singletonMap("server.port", portNumber)
				);
			}
		app.run(args);
		
	}

}
