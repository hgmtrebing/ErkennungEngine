package com.erkennung.erkennungapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErkennungApiApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ErkennungApiApplication.class, args);
			System.out.println();
		} catch (Throwable t) {

			while (t != null) {
				System.out.println(t.toString());
				for(StackTraceElement e: t.getStackTrace()) {
					System.out.println(e.toString());
				}
				t = t.getCause();
			}
		}
	}

}
