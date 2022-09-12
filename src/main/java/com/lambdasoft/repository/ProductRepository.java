package com.lambdasoft.repository;

import com.lambdasoft.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void create(Product product) {
        this.em.persist(product);
    }

    @Transactional
    public void update(Product product) {
        this.em.merge(product);
    }

    @Transactional
    public void delete(Product product) {
        this.em.remove(product);
    }

    public List<Product> getAll() {
        return this.em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product findById(Long id) {
        return this.em.createQuery("SELECT p FROM Product p WHERE p.id = :idParam", Product.class)
                .setParameter("idParam", id).getSingleResult();
    }

}
