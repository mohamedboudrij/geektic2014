package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Interet;
@Repository
public class InteretDAO {
	@PersistenceContext
 	private EntityManager entityManager;
	
	public List<Interet> getAllInteret() {
		String qlString = "SELECT ct FROM Interet ct";
		TypedQuery<Interet> query = entityManager.createQuery(qlString, Interet.class);
		List<Interet> List_of_Interet = query.getResultList();
		return List_of_Interet;
	}
	
}
