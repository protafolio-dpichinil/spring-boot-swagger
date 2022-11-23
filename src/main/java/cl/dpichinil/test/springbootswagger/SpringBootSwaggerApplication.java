package cl.dpichinil.test.springbootswagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Calculadora API", version = "1.1", description = "Api para operaciones basicas de calculadora"))
public class SpringBootSwaggerApplication {
    /**
     * ejemplo en base para configuracion del proyecto y configuracion de springdoc
     * https://www.baeldung.com/spring-rest-openapi-documentation
     * https://springdoc.org/#Introduction
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerApplication.class, args);
    }

}
