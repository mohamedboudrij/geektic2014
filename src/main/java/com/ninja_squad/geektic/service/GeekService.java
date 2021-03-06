package com.ninja_squad.geektic.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.IGeekDAO;
import com.ninja_squad.geektic.model.Geek;
import com.ninja_squad.geektic.model.Audit;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
public class GeekService {

	@Autowired
	IGeekDAO geekdao ;
	
	private EntityManager entityManager;
	
    @RequestMapping(value = "/geeks", method = GET)
    public List<Geek> showGeek() {
        return geekdao.findAllGeek();
    }
    
    @RequestMapping(value = "/geeks/{id}", method = GET)
    public Geek showGeekById(@PathVariable("id") int id) {
    	Geek geek = geekdao.findById(id);
    	Audit audit = new Audit(1,geek,new Date(),"") ;
    	//entityManager.persist(audit);
        return geek;
    }
    
    @RequestMapping(value = "/result-search", method = GET, params = {"sexe", "interet"})
    public List<Geek> lesGeek(@RequestParam("sexe") String sexe, @RequestParam("interet") int interet) {
        return geekdao.findBySexeAndInterest(sexe, interet);
    }
}
