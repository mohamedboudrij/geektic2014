package com.ninja_squad.geektic.model;

import javax.persistence.*;


@Entity
@Table(name="GEEK")
public class Geek {

	@Id
	@Column(name="ID", nullable = false)
		private int id;
	@Column(name="NOM", nullable = false)
	  	private String nom;
	@Column(name="PRENOM", nullable = false)
  		private String prenom;
	@Column(name="SEXE", nullable = false)
		private char sexe;
	@Column(name="EMAIL", nullable = false)
  		private String email;
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getSexe() {
		return sexe;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getView(){
		return 0;
	}
}
