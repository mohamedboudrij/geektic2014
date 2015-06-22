package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import static org.junit.Assert.*;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Geek;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class GeekDaoImplTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    
    // private ExampleDao exampleDao;
	@Autowired
	private IGeekDAO dao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
				Operations.deleteAllFrom("GEEK"),
				Operations.insertInto("GEEK")
				          .columns("id", "nom", "prenom","sexe")
				          .values(1, "Mohamed", "Boudrij","M")
				          .build());
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindAllGeek() {
    	List<Geek> liste = dao.findAllGeek();
    	assertEquals(1, liste.get(0).getId());
    }
    
    @Test
    public void testFindGeekById() {
    	Geek geek = dao.findById(1);
    	assertEquals(1, geek.getId());
    }
}
