package com.ninja_squad.geektic.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.AuditDAO;
import com.ninja_squad.geektic.model.Audit;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
public class AuditService {

	@Autowired
	AuditDAO auditservice ;
    
    @RequestMapping(value = "/audit/{id}", method = GET)
    public Audit showAuditByIdGeek(@PathVariable("id") int id) {
        return auditservice.getAuditById(id);
    }
}
