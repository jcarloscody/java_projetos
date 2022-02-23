package com.github.jcarloscody;


import com.github.jcarloscody.anotacao_customizadas.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("dev")
//@Development
public class MinhaConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "O estágio é meu!";
    }

    @Bean(name = "outroApplicationName")
    public String applicationNameW(){
        return "O estágio é meu! Garantido";
    }


}
