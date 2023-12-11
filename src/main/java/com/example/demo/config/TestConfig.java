package com.example.demo.config;

import com.example.demo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean //toda vez que o perfil de test estiver ativo e chamar a classe TestConfig o método intanciaDb vai subir de forma automática
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }

}
