package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 The lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService package contains the main class
 {@link Application} that serves as the entry point for running the JAX-RS web service.

 This package utilizes the Spring Boot framework to configure and start the web service.
 The {@link SpringApplication} class is used to bootstrap and launch the application.

 To start the web service, execute the {@link Application#main} method and pass any
 necessary command-line arguments.
 </p>
 @see Application
 @see SpringApplication
 @see SpringBootApplication
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
