package com.tuana9a.repository.v1;

import com.tuana9a.entities.Product;
import com.tuana9a.models.CountAnyByAny;
import com.tuana9a.models.CountEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepoV1 {

    // TODO: hình như mình nhớ không nhầm thì autowired vs persistence context là khác nhau
    // @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public Product findById(int id) {
        String sql = "SELECT e FROM Product e where e.id = ?1 and e.deleted = false";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        query.setParameter(1, id);
        return query.getSingleResult();

    }

    public List<Product> findAll() {
        String sql = "SELECT e FROM Product e WHERE e.deleted = false";
        TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }


    public Long countAll() {
        String sql = "SELECT count(e) FROM Product e WHERE e.deleted = false";
        return entityManager.createQuery(sql, Long.class)
                .getSingleResult();
    }

    public CountEntity customCountAll() {
        String sql = "SELECT " +
                "new com.tuana9a.models.CountEntity('Count Product',count(e)) " +
                "FROM Product e " +
                "WHERE e.deleted = false";
        return entityManager.createQuery(sql, CountEntity.class)
                .getSingleResult();
    }

    public List<CountAnyByAny> countGroupByBrand() {
        String sql = "SELECT " +
                "new com.tuana9a.models.CountAnyByAny(e.brand.name,count(e)) " +
                "FROM Product e " +
                "WHERE e.deleted = false " +
                "GROUP BY e.brand";
        return entityManager.createQuery(sql, CountAnyByAny.class)
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
        Product object = entityManager.find(Product.class, id);
        entityManager.remove(object);
    }
}
