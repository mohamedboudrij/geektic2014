package com.ninja_squad.geektic.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="AUDIT")
public class Audit {
	
	@Id
	@Column(name="ID", nullable = false)
	private int id;
	@ManyToOne
	@JoinColumn(name = "ID_GEEK", nullable = false)
		private Geek geek;
	@Column(name="DATE", nullable = false)
		private Date date;
	@Column(name="ADRESSE_IP", nullable = false)
		private String adresseIp;
	
	public Audit() {
		
	}

	public Audit(int id, Geek geek, Date date, String adresseIp) {
		this.id = id;
		this.geek = geek;
		this.date = date;
		this.adresseIp = adresseIp;
	}
	
	public int getId() {
		return id;
	}
	public Geek getGeek() {
		return geek;
	}
	public Date getDate() {
		return date;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	
	
}
