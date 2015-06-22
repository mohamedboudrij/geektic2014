//package com.ninja_squad.geektic.dao;
package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.geektic.model.Geek;

public interface IGeekDAO {
	
	List<Geek> findAllGeek();
	Geek findById(int id);
	List<Geek> searchGeek();
	
}
