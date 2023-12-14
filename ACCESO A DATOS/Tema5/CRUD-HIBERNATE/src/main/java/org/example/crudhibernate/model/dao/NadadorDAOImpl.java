package org.example.crudhibernate.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.crudhibernate.model.entity.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public void update(Nadador nadador) {
        nadador.setNombre("Alvaro");
        nadador.setEdad(47);
        entityManager.merge(nadador);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Nadador nadador = entityManager.find(Nadador.class, id);
        if (nadador != null) {
            entityManager.remove(nadador);
        } else {
            System.out.println("No se encontró un nadador con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<Nadador> findAll() {
        TypedQuery<Nadador> query = entityManager.createQuery("FROM Nadador", Nadador.class);
        return query.getResultList();
    }

    @Override
    public Nadador findByEmail(String email) {
        String jpql = "SELECT n FROM Nadador n WHERE n.email = :email";

        TypedQuery<Nadador> query = entityManager.createQuery(jpql, Nadador.class);
        query.setParameter("email", email);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        String nativeQuery = "DELETE FROM Nadador";
        Query query = entityManager.createNativeQuery(nativeQuery);
        query.executeUpdate();
    }
}
