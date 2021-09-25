package com.tuana9a.repository.v4;

import com.tuana9a.entities.data.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.criteria.Predicate;

@Repository

@Data
@AllArgsConstructor
public class BrandRepoV4 {

    private final EntityManager entityManager;

    public List<Brand> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);
        criteriaQuery.select(root);
        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Brand findById(Integer id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteriaQuery = builder.createQuery(Brand.class);
        Root<Brand> root = criteriaQuery.from(Brand.class);

        Predicate predicateId = builder.equal(root.get("id"), id);
        Predicate predicateDeletedFalse = builder.equal(root.get("deleted"), false);
        Predicate finalPredicate = builder.and(predicateId, predicateDeletedFalse);

        criteriaQuery.select(root).where(finalPredicate);

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);



        return query.getSingleResult();
    }

}
