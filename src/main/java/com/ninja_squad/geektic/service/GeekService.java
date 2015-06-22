package com.ninja_squad.geektic.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.IGeekDAO;
import com.ninja_squad.geektic.model.Geek;

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
	IGeekDAO geekservice ;
	
    @RequestMapping(value = "/geeks", method = GET)
    public List<Geek> showGeek() {
        return geekservice.findAllGeek();
    }
    
    @RequestMapping(value = "/geeks/{id}", method = GET)
    public Geek showGeekById(@PathVariable("id") int id) {
        return geekservice.findById(id);
    }
}
