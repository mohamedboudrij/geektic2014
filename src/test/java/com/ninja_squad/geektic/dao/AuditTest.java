package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import static org.junit.Assert.*;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.model.Audit;
import com.ninja_squad.geektic.dao.AuditDAO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class AuditTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    
	@Autowired
	private AuditDAO auditDao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
        		Operations.deleteAllFrom("AUDIT"),
        		Operations.deleteAllFrom("GEEK_CENTRE_INTERET"),
        		Operations.deleteAllFrom("GEEK"),
        		Operations.deleteAllFrom("CENTRE_INTERET"),
				Operations.insertInto("GEEK")
				          .columns("id", "nom", "prenom","sexe")
				          .values(1, "Mohamed", "Boudrij","M")
				          .values(2, "Yacine", "Boudrij","M").build(),
				Operations.insertInto("CENTRE_INTERET")
				          .columns("id", "libelle")
				          .values(1, "VBA")
				          .values(2, "JAVA").build(),
				Operations.insertInto("GEEK_CENTRE_INTERET")
				          .columns("id_geek", "id_interet")
				          .values(1, 1)
				          .values(1, 2).build(),
				Operations.insertInto("AUDIT")
				          .columns("id", "id_geek","date","adresse_ip")
				          .values(1, 1,"2015-05-06","192.168.1.32")
				          .values(2, 2,"2015-05-06","192.168.1.32")
				          .build());
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
    
    @Test
    public void testFindAuditById() {
    	Audit audit = auditDao.getAuditById(1);
    	assertEquals(1, audit.getId());
    }
}
