package com.example.testproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.testproject.model.User;

@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<User> findAll() {
		Query query = em.createQuery("from User");
		return query.getResultList();
	}
}
