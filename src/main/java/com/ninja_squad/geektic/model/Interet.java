package com.ninja_squad.geektic.model;


import javax.persistence.*;


@Entity
@Table(name="CENTRE_INTERET")
public class Interet {

	@Id
	@Column(name="ID", nullable = false)
		private int id;
	@Column(name="LIBELLE", nullable = false)
	  	private String libelle;
}
