package com.tuana9a.repository.v1;

import com.tuana9a.entities.data.Product;
import com.tuana9a.entities.query.CountAnyByAny;
import com.tuana9a.entities.query.CountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepoV1 {

    @PersistenceContext
    private final EntityManager entityManager;

    public Product queryById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT e FROM Product e where e.id = ?1 and e.deleted = false", Product.class);
        query.setParameter(1, id);
        return query.getSingleResult();

    }

    public List<Product> queryAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT e FROM Product e WHERE e.deleted = false", Product.class);
        return query.getResultList();
    }


    public Long queryCountAll() {
        return entityManager.createQuery("SELECT count(e) FROM Product e WHERE e.deleted = false", Long.class)
                .getSingleResult();
    }

    public CountEntity queryCountAllCustom() {
        return entityManager.createQuery("SELECT " +
                "new com.gemdino.learnspringboot.entities.query.CountEntity('Count Product',count(e)) " +
                "FROM Product e WHERE e.deleted = false", CountEntity.class)
                .getSingleResult();
    }

    public List<CountAnyByAny> queryCountProductByBrand() {
        return entityManager.createQuery("SELECT " +
                "new com.gemdino.learnspringboot.entities.query.CountAnyByAny(e.brand.name,count(e)) " +
                "FROM Product e WHERE e.deleted = false GROUP BY e.brand", CountAnyByAny.class)
                .getResultList();
    }

    @Transactional
    public void persist(Product brand) {
        entityManager.persist(brand);
    }

    @Transactional
    public void merge(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void remove(int id) {
        Product exist = entityManager.find(Product.class, id);
        entityManager.remove(exist);
    }
}
