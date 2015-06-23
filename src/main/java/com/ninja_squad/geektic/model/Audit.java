package com.ninja_squad.geektic.model;

import javax.persistence.*;

@Entity
@Table(name="AUDIT")
public class Audit {
	
	@Column(name="ID_GEEK", nullable = false)
		private int id_geek;
	@Column(name="DATE", nullable = false)
		private String date;
	@Column(name="ADRESSE_IP", nullable = false)
		private int adresse_ip;
	
	public int getId_geek() {
		return id_geek;
	}
	public String getDate() {
		return date;
	}
	public int getAdresse_ip() {
		return adresse_ip;
	}

}
