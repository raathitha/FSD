package com.crud.app.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication (exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages="com.crud.app")
@ImportResource({"SpringMVC-servlet.xml"})
public class ApplicationEntry {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEntry.class, args);
	}

}
