package com.chambre;

public class Chambre {
	
	private int id_chambre;
	private String nomchambre;
	private int maxplace;
	private int id_pavillon;
	
	
	
	public int getId_chambre() {
		return id_chambre;
	}
	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}
	public String getNomchambre() {
		return nomchambre;
	}
	public void setNomchambre(String nomchambre) {
		this.nomchambre = nomchambre;
	}
	public int getMaxplace() {
		return maxplace;
	}
	public void setMaxplace(int maxplace) {
		this.maxplace = maxplace;
	}
	public int getId_pavillon() {
		return id_pavillon;
	}
	public void setId_pavillon(int id_pavillon) {
		this.id_pavillon = id_pavillon;
	}
	
}
