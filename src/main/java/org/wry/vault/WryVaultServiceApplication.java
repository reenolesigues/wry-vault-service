package org.wry.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class WryVaultServiceApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WryVaultServiceApplication.class);
    	springApplication.addListeners(new ApplicationPidFileWriter("app.pid"));
    	springApplication.run(args);
	}

}
