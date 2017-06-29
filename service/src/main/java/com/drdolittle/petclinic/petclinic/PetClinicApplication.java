package com.drdolittle.petclinic.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}


    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
            "Dr. Dolittle Petclinic backend Api Documentation",
            "This is REST API documentation of the Dr. Dolittle Petclinic backend",
            "1.0",
            "Dr. Dolittle Petclinic backend terms of service",
            new Contact(
                "Dr. Dolittle",
                "http://www.drdolittle.com",
                "info@drdolittle.com"),
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0");
    }
}
