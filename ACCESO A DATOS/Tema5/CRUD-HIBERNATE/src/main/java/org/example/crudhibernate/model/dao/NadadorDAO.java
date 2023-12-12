package org.example.crudhibernate.model.dao;

import org.example.crudhibernate.model.entity.Nadador;

public interface NadadorDAO {
    void save(Nadador nadador);
    Nadador findById(Integer id);
}
