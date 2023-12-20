package org.example.crudhibernate;

import org.example.crudhibernate.model.dao.NadadorDAO;
import org.example.crudhibernate.model.entity.Nadador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(NadadorDAO nadadorDAO){
        return runner -> {
            //createNadador(nadadorDAO);
            //findNadadorId(nadadorDAO);
            //updateNadador(nadadorDAO);
            //deleteNadador(nadadorDAO);
            //findAll(nadadorDAO);
            //findByEmail(nadadorDAO);
            deleteAll(nadadorDAO);
        };
    }

    private void createNadador(NadadorDAO nadadorDAO) {
        System.out.println("Indroduzco un nadador");
        Nadador tempNadador = new Nadador("Alvaro", "1", "España", 21, "alvaro@gmail.com");
        nadadorDAO.save(tempNadador);
        System.out.println(tempNadador.getId());
    }

    private void findNadadorId(NadadorDAO nadadorDAO) {
        int id = 1;
        Nadador nadador = nadadorDAO.findById(id);
        System.out.println(nadador.getNombre());
    }

    private void updateNadador(NadadorDAO nadadorDAO) {
        int id = 1;
        Nadador nadador = nadadorDAO.findById(id);
        nadadorDAO.update(nadador);
    }

    private void deleteNadador(NadadorDAO nadadorDAO) {
        int id = 5;
        nadadorDAO.delete(id);
    }

    private void findAll(NadadorDAO nadadorDAO) {
        System.out.println(nadadorDAO.findAll());
    }

    private void findByEmail(NadadorDAO nadadorDAO) {
        String email = "denis@gmail.com";
        Nadador nadador = nadadorDAO.findByEmail(email);
        System.out.println(nadador.getNombre());
    }

    public void deleteAll(NadadorDAO nadadorDAO) {
        nadadorDAO.deleteAll();
    }
}
