package com.tuana9a.repository.v4;

import com.tuana9a.entities.data.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

@Data
@AllArgsConstructor
public class ProductRepoV4 {

    private final EntityManager entityManager;

    public List<Product> findAllPriceSort(boolean desc) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        Order order = desc ? builder.desc(root.get("price")) : builder.asc(root.get("price"));

        criteriaQuery.select(root).orderBy(order);

        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
