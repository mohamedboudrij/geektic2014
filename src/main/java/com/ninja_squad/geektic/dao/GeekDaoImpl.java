package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Geek;

@Repository
public class GeekDaoImpl implements IGeekDAO{
	@PersistenceContext
	 	private EntityManager entityManager;
	
	@Override
	public List<Geek> findAllGeek() {
		String qlString = "SELECT g FROM Geek g";
		TypedQuery<Geek> query = entityManager.createQuery(qlString, Geek.class);
		List<Geek> List_of_geek = query.getResultList();
		return List_of_geek;
	}
	
	@Override
	public Geek findById(int id){
		/*String qlString = "SELECT g FROM Geek g where g.id =:id";
		TypedQuery<Geek> query = entityManager.createQuery(qlString, Geek.class);
		query.setParameter("id", id);
		Geek geek = query.getSingleResult();
		return geek;*/
		return entityManager.find(Geek.class, id);
	}
	
	@Override
	public List<Geek> searchGeek() {
		
		return null;
	}

}
