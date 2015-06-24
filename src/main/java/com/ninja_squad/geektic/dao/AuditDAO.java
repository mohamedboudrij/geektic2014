package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Audit;

@Repository
public class AuditDAO {
	
	@PersistenceContext
 	private EntityManager entityManager;
	
	public Audit getAuditById(int id) {
		String qlString = "SELECT count(a.id_geek) FROM Audit a where a.id_geek = :id";
		TypedQuery<Audit> query = entityManager.createQuery(qlString, Audit.class);
		query.setParameter("id", id);
		Audit audit = query.getSingleResult();
		return audit;
	}
}
