package com.paracasa.spring.app;

import com.paracasa.spring.app.repository.MenuRepository;
import com.paracasa.spring.app.repository.ProductRepository;
import com.paracasa.spring.app.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParaCasaApplication {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
       SpringApplication.run(ParaCasaApplication.class, args);
    }

    @Bean
    void commandLineRunner(){
        Seeds seeds = new Seeds(menuRepository, productRepository);
        seeds.generateSeeds();
    }


}
