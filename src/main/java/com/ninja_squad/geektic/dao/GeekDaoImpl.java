package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Audit;

@Repository
public class GeekDaoImpl implements IGeekDAO{
	@PersistenceContext
	 	public EntityManager entityManager;
	
	@Override
	public List<Geek> findAllGeek() {
		String qlString = "SELECT g FROM Geek g";
		TypedQuery<Geek> query = entityManager.createQuery(qlString, Geek.class);
		List<Geek> List_of_geek = query.getResultList();
		return List_of_geek;
	}
	
	@Override
	public Geek findById(int id){
		/*String qlString = "SELECT g, count(a.id) FROM Geek g,Audit a where g.id = a.id_geek and g.id =:id";
		TypedQuery<Geek> query = entityManager.createQuery(qlString, Geek.class);
		query.setParameter("id", id);
		Geek geek = query.getSingleResult();
		if (geek.getId()>=0) addAudit(id);
		return geek;*/
		return entityManager.find(Geek.class, id);
	}
	
	@Override
	public List<Geek> findBySexeAndInterest(String sexe, int interet){
        String query = "SELECT g FROM Geek g JOIN g.listOfInteret i WHERE g.sexe = :sexe AND i.id = :interet ";
        
        TypedQuery<Geek> query1 = entityManager.createQuery(query, Geek.class); query1.setParameter("sexe", sexe).setParameter("interet", interet);
        return query1.getResultList();
    }

}
