package com.asimo.accounts.config;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                version = "v1",
                description = "EazyBank Accounts microservice REST API Documentation",
                contact = @Contact(
                        name = "Asim Timsina",
                        email = "asimo@test.com",
                        url ="https://www.google.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url ="https://www.google.com"
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBank Accounts microservice REST API Documentation",
                url ="https://www.google.com"
        )

)
public class SwaggerConfig {
}
