package org.example.crudhibernate.model.dao;

import jakarta.persistence.EntityManager;
import org.example.crudhibernate.model.entity.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NadadorDAOImpl implements NadadorDAO {
    private EntityManager entityManager;

    @Autowired
    public NadadorDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Nadador theNadador) {
        entityManager.persist(theNadador);
    }

    @Override
    public Nadador findById(Integer id) {
        return entityManager.find(Nadador.class, id);
    }
}
