package org.example.crudhibernate.model.dao;

import org.example.crudhibernate.model.entity.Nadador;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NadadorDAO {
    void save(Nadador nadador);
    Nadador findById(Integer id);
    void update(Nadador nadador);
    void delete(Integer id);
    List<Nadador> findAll();
    Nadador findByEmail(String email);
    void deleteAll();
}
