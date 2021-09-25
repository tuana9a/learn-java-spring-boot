package com.tuana9a.repository.v1;

import com.tuana9a.entities.data.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@AllArgsConstructor
public class CustomerRepoV1 {

    @PersistenceContext
    private final EntityManager entityManager;

    public Customer findById(int id) {
        //EXPLAIN: hàm find tìm theo khóa chính
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public void persist(Customer brand) {
        entityManager.persist(brand);
    }

    @Transactional
    public void merge(Customer customer) {
        entityManager.merge(customer);
    }

    @Transactional
    public void remove(int id) {
        Customer exist = entityManager.find(Customer.class, id);
        entityManager.remove(exist);
    }

}
