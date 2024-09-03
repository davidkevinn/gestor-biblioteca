package com.biblioteca.fuctura.profiles;

import com.biblioteca.fuctura.services.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfile {

    @Autowired
    private DBServices dbServices;

    @Bean
    public void InstanciaDB(){
        this.dbServices.instanciaDB();
    }

}
