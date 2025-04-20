package io.todoapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Todo App API",
        description = "This API is used to manage tasks in a todo app",
        contact = @Contact(name = "Todo App", email = ""),
        version = "v1"),
        servers ={
            @Server(description = "local", url = "http://localhost:9090/todoapp"),
        }
)
public class SwaggerConfig {
}
