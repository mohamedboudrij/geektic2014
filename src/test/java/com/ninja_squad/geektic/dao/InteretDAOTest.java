package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import static org.junit.Assert.*;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Interet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class InteretDAOTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    
    // private ExampleDao exampleDao;
	@Autowired
	private IGeekDAO dao;
	
	@Autowired
	private InteretDAO daoInteret;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
				Operations.deleteAllFrom("CENTRE_INTERET"),
				Operations.insertInto("CENTRE_INTERET")
				          .columns("id", "libelle")
				          .values(1, "VBA")
				          .values(2, "JAVA")
				          .values(3, "BDD")
				          .build());
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
    
    @Test
    public void testGetInteret() {
    	List<Interet> interet = daoInteret.getAllInteret();
    	assertEquals(2, interet.get(1).getId());
    }
}
