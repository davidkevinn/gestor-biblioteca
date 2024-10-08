package com.biblioteca.fuctura.profiles;

import com.biblioteca.fuctura.services.DBServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {

    private DBServices dbServices;

    public DevProfile(DBServices dbServices) {
        this.dbServices = dbServices;
    }

    @Bean
    public void instaceDb(){
        dbServices.instanciaDB();
    }
}
