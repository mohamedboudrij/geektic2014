package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Audit;

@Repository
public class AuditDAO {
	
	@PersistenceContext
 	private EntityManager entityManager;
	
	public long getAuditById(int id) {
		String qlString = "SELECT count(a) FROM Audit a where a.geek.id = :id";
		Query query = entityManager.createQuery(qlString);
		query.setParameter("id", id);
		long audit = (Long)query.getSingleResult();
		return audit;
	}
}
