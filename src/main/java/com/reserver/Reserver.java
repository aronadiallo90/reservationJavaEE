package com.reserver;
import java.time.LocalDate;

public class Reserver {
	private int id_reservation;
	private int id_chambre;
	private int id_pavillon;
	
	private LocalDate datereservation = LocalDate.now(); // Create a date object

	public LocalDate getDatereservation() {
		return datereservation;
	}

	public void setDatereservation(LocalDate datereservation) {
		this.datereservation = datereservation;
	}

	public int getId_pavillon() {
		return id_pavillon;
	}

	public void setId_pavillon(int id_pavillon) {
		this.id_pavillon = id_pavillon;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
   
	
	
	
}
