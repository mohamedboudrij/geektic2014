package com.ninja_squad.geektic.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.InteretDAO;
import com.ninja_squad.geektic.model.Interet;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
public class InteretService {
	
	@Autowired
	InteretDAO interetservice ;
	
    @RequestMapping(value = "/centre-interet", method = GET)
    public List<Interet> getInteret() {
        return interetservice.getAllInteret();
    }
}
