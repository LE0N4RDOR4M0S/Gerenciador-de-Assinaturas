package com.leonardoramos.assinaturas;

import org.springframework.boot.SpringApplication;

public class TestAssinaturasApplication {

    public static void main(String[] args) {
        SpringApplication.from(AssinaturasApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
