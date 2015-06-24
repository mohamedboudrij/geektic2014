package com.ninja_squad.geektic.model;

import java.util.List;

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
		private String sexe;
	@Column(name="EMAIL", nullable = false)
  		private String email;
	
	@ManyToMany
    @JoinTable(name = "GEEK_CENTRE_INTERET",
            joinColumns = @JoinColumn(name = "ID_GEEK"),
            inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
	private List<Interet> listOfInteret; 
		
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSexe() {
		if (sexe.equals("H")) sexe="Homme";
		else sexe = "Femme";
		return sexe;
	}
	
	public List<Interet> getListOfInteret() {
		return listOfInteret;
	}

	public int getView(){
		return 0;
	}
	
}
