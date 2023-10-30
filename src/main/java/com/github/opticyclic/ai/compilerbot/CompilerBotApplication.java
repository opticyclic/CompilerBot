package com.github.opticyclic.ai.compilerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompilerBotApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CompilerBotApplication.class);
        app.setRegisterShutdownHook(false); // Prevents the application from shutting down
        app.run(args);
    }
}
