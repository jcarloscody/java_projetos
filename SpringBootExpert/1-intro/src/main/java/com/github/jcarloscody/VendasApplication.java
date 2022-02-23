package com.github.jcarloscody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.github.jcarloscody.services.MeuServico", "/fora/Fora"})
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String getApplicationNameApplicationProperties;

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @Autowired
    @Qualifier("outroApplicationName")
    private String applicationNameW;

    @GetMapping(path = "/h")
    private String helloWord(){
        return getApplicationNameApplicationProperties;
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
